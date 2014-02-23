package distraction.refactored;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.File;
import java.util.List;

import org.junit.Test;

/**
 * NOTE: this must be an integration test, because of the real impl.
 * Pieces like this that cross the process boundary are naturally
 * a subject to integration testing. At some point you have to test
 * the units that communicate with the outer world by ITs. We try to
 * minimize the functionality that needs testing with ITs, and extract
 * it from the rest, where we can use fast and isolated unit tests.
 */
public class FtpClientImplTest {

  private final ChecksumVerifier checksumVerifier = mock(ChecksumVerifier.class);
  private final FtpClientImpl ftpClient = new FtpClientImpl("ftp://my.test.server",
                                              checksumVerifier);

  @Test
  public void testListFiles() throws Exception {
    // NOTE: listFiles() opens a real FTP connection so
    // now the FTP server must be set up accordingly.
    List<String> expectedList = asList("conference-0.rec", "conference-1.rec");
    List<String> actualList = ftpClient.listFiles("*.rec");
    assertEquals(expectedList, actualList);
  }

  @Test
  public void testDownloadFile() throws Exception {
    String checksum = "234fsfd32";
    File localFile = ftpClient.downloadFile("conference-0.rec", checksum);
    assertEquals("conference-0.rec", localFile.getName());
    // assertTrue(localFile.exists());
    verify(checksumVerifier).verifyChecksum(localFile, checksum);
  }
}
