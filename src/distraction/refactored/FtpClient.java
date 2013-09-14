package distraction.refactored;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface FtpClient {

  List<String> listFiles(String pattern) throws IOException;

  File downloadFile(String fileName, String checksum) throws IOException;

}
