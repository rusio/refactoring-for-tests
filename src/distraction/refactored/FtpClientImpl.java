package distraction.refactored;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static java.util.Arrays.asList;

public class FtpClientImpl implements FtpClient {

  private final String serverUrl;
  private final ChecksumVerifier checksumVerifier;

  public FtpClientImpl(String serverUrl, ChecksumVerifier checksumVerifier) {
    this.serverUrl = serverUrl;
    this.checksumVerifier = checksumVerifier;
  }

  @Override
  public List<String> listFiles(String pattern) throws IOException {
    establishConnection();
    // NOTE: imagine this lists the remote FTP files
    // according to the given filename pattern
    List<String> remoteFiles = asList("conference-0.rec", "conference-1.rec");
    return remoteFiles;
  }

  @Override
  public File downloadFile(String fileName, String checksum) throws IOException {
    establishConnection();
    // NOTE: imagine this downloads the file in /tmp
    File localFile = new File("/tmp", fileName);
    checksumVerifier.verifyChecksum(localFile, checksum);
    return localFile;
  }

  private void establishConnection() throws IOException {
    System.out.println("Connecting to " + serverUrl);
    // NOTE: simulate some connection problems
    if (Math.random() < 0.2) {
      throw new IOException("Connection refused!");
    }
  }

}
