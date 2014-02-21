package distraction.original;

import java.io.File;
import java.util.List;

public class Usage {

  public static void main(String[] args) throws Exception {
    FtpClient ftpClient = new FtpClient("ftp://my.server.de");
    List<String> fileNames = ftpClient.listFiles("*.rec");
    for (String fileName : fileNames) {
      File localFile = ftpClient.downloadFile(fileName, "Bx3A2v34fhq4367");
    }
  }
}
