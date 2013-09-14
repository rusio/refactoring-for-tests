package distraction.refactored;

import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * NOTE: this must be an integration test, because it is a real impl.
 * Pieces like this that cross the process boundary are naturally
 * a subject to integration testing. At some point you have to test
 * the units that communicate with the outer world by ITs. But we
 * test only these units with ITs, the remaining units can be tested
 * with unit-tests now!
 */
@Ignore("Integration Test")
public class FtpClientImplTest {

  ChecksumVerifier checksumVerifier = mock(ChecksumVerifier.class);
  FtpClientImpl ftpClient = new FtpClientImpl("ftp://my.test.server",
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
    assertTrue(localFile.exists());
    verify(checksumVerifier).verifyChecksum(localFile, checksum);
  }
}
