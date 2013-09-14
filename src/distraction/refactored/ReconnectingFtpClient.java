package distraction.refactored;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ReconnectingFtpClient implements FtpClient {

  private static final int RETRY_COUNT = 3;
  private final FtpClient delegate;

  public ReconnectingFtpClient(FtpClient delegate) {
    this.delegate = delegate;
  }

  @Override
  public List<String> listFiles(String pattern) throws IOException {
    IOException cause = null;
    for (int i = 0; i <= RETRY_COUNT; i++) {
      try {
        return delegate.listFiles(pattern);
      }
      catch (IOException e) {
        cause = e;
      }
    }
    throw new IOException("Failed after " + RETRY_COUNT + " retries!", cause);
  }

  @Override
  public File downloadFile(String fileName, String checksum) throws IOException {
    IOException cause = null;
    for (int i = 0; i <= RETRY_COUNT; i++) {
      try {
        return delegate.downloadFile(fileName, checksum);
      }
      catch (IOException e) {
        cause = e;
      }
    }
    throw new IOException("Failed after " + RETRY_COUNT + " retries!", cause);
  }
}
