package file;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * This is the method needed to save a file.
 */
public class SaveFile {

  /**
   * This is the method to save an image.
   *
   * @param filepath - this is the filepath of the image.
   * @param contents - this is the contents of the image.
   * @throws IOException - thrown if nothing can be written or read.
   */
  public void save(String filepath, String contents) throws IOException {
    FileOutputStream output = new FileOutputStream(filepath);
    byte[] array = contents.getBytes();
    // Writes byte to the file
    output.write(array);
    output.close();
  }
}
