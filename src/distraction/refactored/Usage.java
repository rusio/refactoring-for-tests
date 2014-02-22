package distraction.refactored;

import java.io.File;
import java.util.List;

public class Usage {

  public static void main(String[] args) throws Exception {
    ChecksumVerifier checksumVerifier = new Md5ChecksumVerifier();
    FtpClient delegate = new FtpClientImpl("ftp://my.server.de",
                                           checksumVerifier);
    FtpClient ftpClient = new CachingFtpClient(new ReconnectingFtpClient(delegate));
    List<String> fileNames = ftpClient.listFiles("*.rec");
    for (String fileName : fileNames) {
      File localFile = ftpClient.downloadFile(fileName, "Bx3A2v34fhq4367");
      System.out.println("FILE: " + localFile);
    }
  }
}
