package image;

import java.util.List;

/**
 * Represents an image which derives from a ppm file.
 */
public interface Image {
  /**
   * Returns max value of an image.
   *
   * @return - this is the max value.
   */
  int getMaxValue();

  /**
   * This is the width of the image.
   *
   * @return - this is the width of the image.
   */
  int getWidth();

  /**
   * This gets the height.
   *
   * @return - this is the height of the image.
   */
  int getHeight();

  /**
   * This is the list of pixels.
   *
   * @return - the list of pixels of the image.
   */
  List<List<Pixel>> getPixels();
}
