package distraction.refactored;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ReconnectingFtpClientTest {

  private static final String PATTERN = "*.rec";
  private final FtpClient delegate = mock(FtpClient.class);
  private final ReconnectingFtpClient ftpClient = new ReconnectingFtpClient(delegate);

  @Test
  public void testListFiles_HappyPath() throws Exception {
    ftpClient.listFiles(PATTERN);
    verify(delegate).listFiles("*.rec");
  }

  @Test
  public void testListFiles_ReconnectSuccess() throws Exception {
    List<String> veryLastResult = asList("conference.rec");

    // simulate 3 failures and one success at the very last attempt
    when(delegate.listFiles(PATTERN)).thenThrow(new IOException("1"),
                                                new IOException("2"),
                                                new IOException("3"))
                                     .thenReturn(veryLastResult);

    // in this case we expect that we get the very last result
    assertEquals(veryLastResult, ftpClient.listFiles(PATTERN));
  }

  @Test
  public void testListFiles_ReconnectFailure() throws Exception {
    // simulate 4 failures - the last attempt has failed too
    when(delegate.listFiles(PATTERN)).thenThrow(new IOException("1"),
                                                new IOException("2"),
                                                new IOException("3"),
                                                new IOException("4"));
    try {
      ftpClient.listFiles(PATTERN);
      fail("Expected IOException(4) was not thrown.");
    }
    catch (IOException e) {
      // in this case we expect that the last exception
      // is captured and thrown as a cause for the error
      assertEquals("4", e.getCause().getMessage());
    }
  }

}
