package distraction.refactored;

import java.io.File;
import java.io.IOException;

interface ChecksumVerifier {

  void verifyChecksum(File localFile, String checksum) throws IOException;

}
