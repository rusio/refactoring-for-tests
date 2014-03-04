package distraction.refactored;

import java.io.File;
import java.util.List;

class Usage {

  public static void main(String[] args) throws Exception {
    ChecksumVerifier verifier = new Md5ChecksumVerifier();
    FtpClient delegate = new FtpClientImpl("ftp://my.server.de", verifier);
    FtpClient ftpClient = new CachingFtpClient(new ReconnectingFtpClient(delegate));
    List<String> fileNames = ftpClient.listFiles("*.rec");
    for (String fileName : fileNames) {
      File localFile = ftpClient.downloadFile(fileName, "Bx3A2v34fhq4367");
      System.out.println("FILE: " + localFile);
    }
  }
}
