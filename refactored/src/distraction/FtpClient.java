package distraction;

import java.io.File;
import java.io.IOException;
import java.util.List;

interface FtpClient {

  List<String> listFiles(String namePattern) throws IOException;

  File downloadFile(String fileName, String checksum) throws IOException;

}
