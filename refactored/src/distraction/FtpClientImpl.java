package distraction;

import simulation.Chances;
import simulation.RemoteCalls;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static java.util.Arrays.asList;

class FtpClientImpl implements FtpClient {

  private final String serverUrl;
  private final ChecksumVerifier verifier;

  public FtpClientImpl(String serverUrl, ChecksumVerifier verifier) {
    this.serverUrl = serverUrl;
    this.verifier = verifier;
  }

  @Override
  public List<String> listFiles(String pattern) throws IOException {
    establishConnection();
    return asList("conference-0.rec", "conference-1.rec");
  }

  @Override
  public File downloadFile(String fileName, String checksum) throws IOException {
    establishConnection();
    File localFile = new File("/tmp", fileName);
    verifier.verifyChecksum(localFile, checksum);
    return localFile;
  }

  private void establishConnection() throws IOException {
    if (Chances.isHappyPath()) {
      RemoteCalls.perform();
      System.out.println("Connected to " + serverUrl);
    }
    else {
      // NOTE: simulate connection problems
      throw new IOException("Connection refused!");
    }
  }

}
