package file;

import image.Image;

public interface FileCommand {
  /**
   * Reads a ppm image from file and creates an image object representing it.
   *
   * @param filename the name of the ppm file
   * @return a new image object
   * @throws IllegalArgumentException if the file name does not exist
   */
  Image perform(String filename) throws IllegalArgumentException;
}
