package file;

import java.io.FileOutputStream;
import java.io.IOException;

public class SaveFile {

  public void save(String filepath, String contents) throws IOException {
      FileOutputStream output = new FileOutputStream(filepath);
      byte[] array = contents.getBytes();
      // Writes byte to the file
      output.write(array);
      output.close();
  }
}
