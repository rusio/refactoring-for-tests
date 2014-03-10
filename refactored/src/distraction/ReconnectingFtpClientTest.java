package distraction;

import com.google.common.collect.ImmutableList;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ReconnectingFtpClientTest {
  private static final String NAME_PATTERN = "*.rec";
  private static final List<String> REMOTE_FILES = ImmutableList.of("file0.rec",
                                                                    "file1.rec");
  private static final String REMOTE_FILE = "file0.rec";
  private static final String CHECKSUM = "checksum";
  private static final File LOCAL_FILE = new File("/tmp", REMOTE_FILE);

  private final FtpClient delegate = mock(FtpClient.class);
  private final ReconnectingFtpClient sut = new ReconnectingFtpClient(delegate);

  @Rule
  public ExpectedException expectedError = ExpectedException.none();

  @Test
  public void testDownloadFile_HappyPath() throws Exception {
    when(delegate.downloadFile(REMOTE_FILE, CHECKSUM)).thenReturn(LOCAL_FILE);
    File result = sut.downloadFile(REMOTE_FILE, CHECKSUM);
    assertThat(result, is(LOCAL_FILE));
  }

  @Test
  public void testDownloadFile_ReconnectSuccess() throws Exception {
    // simulate 2 failed retries followed by a last-minute success
    when(delegate.downloadFile(REMOTE_FILE, CHECKSUM)).thenThrow(new IOException(),
                                                                 new IOException(),
                                                                 new IOException())
                                                      .thenReturn(LOCAL_FILE);
    File result = sut.downloadFile(REMOTE_FILE, CHECKSUM);
    assertThat(result, is(LOCAL_FILE));
  }

  @Test
  public void testDownloadFile_ReconnectFailure() throws Exception {
    // simulate 3 failed retries after the initial attempt
    IOException e0 = new IOException();
    IOException e1 = new IOException();
    IOException e2 = new IOException();
    IOException e3 = new IOException();
    when(delegate.downloadFile(REMOTE_FILE, CHECKSUM)).thenThrow(e0, e1, e2, e3);
    expectedError.expectCause(is(e3));
    sut.downloadFile(REMOTE_FILE, CHECKSUM);
  }

  @Test
  public void testListFiles_HappyPath() throws Exception {
    when(delegate.listFiles(NAME_PATTERN)).thenReturn(REMOTE_FILES);
    List<String> result = sut.listFiles(NAME_PATTERN);
    assertThat(result, is(REMOTE_FILES));
  }

  @Test
  public void testListFiles_ReconnectSuccess() throws Exception {
    // simulate 2 failed retries followed by a last-minute success
    when(delegate.listFiles(NAME_PATTERN)).thenThrow(new IOException(),
                                                     new IOException(),
                                                     new IOException())
                                          .thenReturn(REMOTE_FILES);
    List<String> result = sut.listFiles(NAME_PATTERN);
    assertThat(result, is(REMOTE_FILES));
  }

  @Test
  public void testListFiles_ReconnectFailure() throws Exception {
    // simulate 3 failed retries after the initial attempt
    IOException e0 = new IOException();
    IOException e1 = new IOException();
    IOException e2 = new IOException();
    IOException e3 = new IOException();
    when(delegate.listFiles(NAME_PATTERN)).thenThrow(e0, e1, e2, e3);
    expectedError.expectCause(is(e3));
    sut.listFiles(NAME_PATTERN);
  }
}
