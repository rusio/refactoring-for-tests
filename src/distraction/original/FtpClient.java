package distraction.original;

import static java.util.Arrays.asList;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

public class FtpClient {

  private static final int RECONNECT_RETRIES = 3;
  private final String serverUrl;
  private final Cache<String, List<String>> cachedLists;

  public FtpClient(String serverUrl) {
    this.serverUrl = serverUrl;
    this.cachedLists = CacheBuilder.newBuilder()
                                   .expireAfterAccess(1, TimeUnit.MINUTES)
                                   .build();
  }

  public List<String> listFiles(String pattern) throws IOException {
    try {
      return cachedLists.get(pattern, new Callable<List<String>>() {
        @Override
        public List<String> call() throws Exception {
          establishConnection(RECONNECT_RETRIES);
          // NOTE: imagine this lists the remote FTP files
          // according to the given filename pattern
          List<String> remoteFiles = asList("conference-0.rec",
                                            "conference-1.rec");
          return remoteFiles;
        }
      });
    }
    catch (ExecutionException e) {
      throw new IOException(e);
    }
  }

  public File downloadFile(String fileName, String checksum) throws IOException {
    establishConnection(RECONNECT_RETRIES);
    // NOTE: imagine this downloads the file in /tmp
    File localFile = new File("/tmp", fileName);
    checkChecksum(localFile, checksum);
    return localFile;
  }

  private void checkChecksum(File localFile, String checksum) throws IOException {
    byte[] fileBytes = Files.readAllBytes(localFile.toPath());
    HashFunction hashFunction = Hashing.md5();
    HashCode expectedHashCode = hashFunction.hashUnencodedChars(checksum);
    HashCode actualHashCode = hashFunction.hashBytes(fileBytes);
    if (!actualHashCode.equals(expectedHashCode)) {
      throw new IOException("Bad checksum after download!");
    }
  }

  private void establishConnection(int retriesLeft) throws IOException {
    try {
      // NOTE: simulate some connection problems
      System.out.println("Connecting to " + serverUrl);
      if (Math.random() < 0.2) {
        throw new IOException("Connection refused!");
      }
    }
    catch (IOException e) {
      if (retriesLeft > 0) {
        establishConnection(retriesLeft - 1);
      }
      else {
        throw new IOException("Failed after " + RECONNECT_RETRIES + " retries", e);
      }
    }
  }

}
