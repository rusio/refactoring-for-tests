package distraction;

import com.google.common.collect.ImmutableList;

import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CachingFtpClientTest {
  private static final String NAME_PATTERN = "*.rec";
  private static final List<String> REMOTE_FILES = ImmutableList.of("file0.rec",
                                                                    "file1.rec");
  private static final String REMOTE_FILE = "file0.rec";
  private static final String CHECKSUM = "checksum";
  private static final File LOCAL_FILE = new File("/tmp", REMOTE_FILE);

  private final FtpClient delegate = mock(FtpClient.class);

  @Rule
  public ExpectedException expectedError = ExpectedException.none();

  @Test
  public void testDownloadFile_HappyPath() throws Exception {
    CachingFtpClient sut = new CachingFtpClient(delegate);
    when(delegate.downloadFile(REMOTE_FILE, CHECKSUM)).thenReturn(LOCAL_FILE);
    File result = sut.downloadFile(REMOTE_FILE, CHECKSUM);
    assertThat(result, is(LOCAL_FILE));
  }

  @Test
  public void testListFiles_CacheMiss() throws Exception {
    CachingFtpClient sut = new CachingFtpClient(delegate);
    when(delegate.listFiles(NAME_PATTERN)).thenReturn(REMOTE_FILES);
    List<String> result = sut.listFiles(NAME_PATTERN);
    assertThat(result, is(REMOTE_FILES));
  }

  @Test
  public void testListFiles_CacheHit() throws Exception {
    CachingFtpClient sut = new CachingFtpClient(delegate);
    when(delegate.listFiles(NAME_PATTERN)).thenReturn(REMOTE_FILES, null);
    List<String> result1 = sut.listFiles(NAME_PATTERN);
    List<String> result2 = sut.listFiles(NAME_PATTERN);
    assertThat(result1, is(REMOTE_FILES));
    assertThat(result2, is(REMOTE_FILES));
  }

  @Test
  public void testListFiles_ExecutionException() throws Exception {
    CachingFtpClient sut = new CachingFtpClient(delegate);
    when(delegate.listFiles(NAME_PATTERN)).thenThrow(new IOException());
    expectedError.expect(instanceOf(IOException.class));
    expectedError.expectCause(CoreMatchers.isA(ExecutionException.class));
    sut.listFiles(NAME_PATTERN); // should throw
  }
}
