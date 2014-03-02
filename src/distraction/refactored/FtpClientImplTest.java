package distraction.refactored;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.File;
import java.util.List;

import org.junit.Test;

/**
 * NOTE: this core functionality must be tested with an integration
 * test, because of the nature of the thing - list and download remote
 * files. Units like this that act across the process boundary are
 * naturally a subject to integration testing. But we try to
 * minimize the functionality that needs integration testing, and isolate
 * it from the rest, where we can use fast and robust unit tests.
 */
public class FtpClientImplTest {

  private final ChecksumVerifier checksumVerifier = mock(ChecksumVerifier.class);
  private final FtpClientImpl ftpClient = new FtpClientImpl("ftp://my.test.server",
                                                            checksumVerifier);

  @Test
  public void testListFiles() throws Exception {
    List<String> expectedList = asList("conference-0.rec", "conference-1.rec");
    List<String> actualList = ftpClient.listFiles("*.rec");
    assertEquals(expectedList, actualList);
  }

  @Test
  public void testDownloadFile() throws Exception {
    String checksum = "d41d8cd98f00b204e9800998ecf8427e";
    File localFile = ftpClient.downloadFile("conference-0.rec", checksum);
    assertEquals("conference-0.rec", localFile.getName());
    // assertTrue(localFile.exists());
    verify(checksumVerifier).verifyChecksum(localFile, checksum);
  }
}
