package file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SaveFile {

  void save(String filepath, String contents) throws IOException {
//    try {
      FileOutputStream output = new FileOutputStream(filepath);
      byte[] array = contents.getBytes();
      // Writes byte to the file
      output.write(array);
      output.close();
  }
}
