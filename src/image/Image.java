package image;

import java.util.List;

/**
 * Represents an image which derives from a ppm file.
 */
public interface Image {
  int getMaxValue();

  int getWidth();

  int getHeight();

  List<List<Pixel>> getPixels();
}
