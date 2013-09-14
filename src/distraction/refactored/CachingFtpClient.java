package distraction.refactored;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CachingFtpClient implements FtpClient {

  private final FtpClient delegate;
  private final Cache<String, List<String>> cachedLists;

  public CachingFtpClient(FtpClient delegate) {
    this.delegate = delegate;
    this.cachedLists = CacheBuilder.newBuilder()
                                   .expireAfterAccess(1, TimeUnit.MINUTES)
                                   .build();
  }

  @Override
  public List<String> listFiles(final String pattern) throws IOException {
    try {
      return cachedLists.get(pattern, new Callable<List<String>>() {
        @Override
        public List<String> call() throws Exception {
          return delegate.listFiles(pattern);
        }
      });
    }
    catch (ExecutionException e) {
      throw new IOException(e);
    }
  }

  @Override
  public File downloadFile(String fileName, String checksum) throws IOException {
    return delegate.downloadFile(fileName, checksum);
  }
}
