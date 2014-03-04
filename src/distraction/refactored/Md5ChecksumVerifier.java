package distraction.refactored;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

public class Md5ChecksumVerifier implements ChecksumVerifier {

  @Override
  public void verifyChecksum(File localFile, String checksum) throws IOException {
    byte[] fileBytes = Files.readAllBytes(localFile.toPath());
    HashFunction hashFunction = Hashing.md5();
    HashCode expectedHashCode = hashFunction.hashUnencodedChars(checksum);
    HashCode actualHashCode = hashFunction.hashBytes(fileBytes);
    if (!actualHashCode.equals(expectedHashCode)) {
      throw new IOException("Bad checksum after download!");
    }
  }
}
