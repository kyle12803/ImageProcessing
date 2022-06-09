package image;

import java.util.List;

/**
 * Represents an image representation that contains a max value possible value, width, height,
 * and list of pixels.
 */
public class ImageImpl implements Image {
  private final int maxValue;
  private final int width;
  private final int height;
  private final List<List<Pixel>> lop;


  public ImageImpl(int maxValue, int width, int height, List<List<Pixel>> lop)
          throws IllegalArgumentException {
    if (maxValue < 0 || lop == null || width != lop.get(0).size() || height != lop.size()) {
      throw new IllegalArgumentException("Invalid arguments.");
    }
    this.maxValue = maxValue;
    this.width = width;
    this.height = height;
    this.lop = lop;
  }

  @Override
  public int getMaxValue() {
    return this.maxValue;
  }

  @Override
  public int getWidth() {
    return this.width;
  }

  @Override
  public int getHeight() {
    return this.height;
  }

  @Override
  public List<List<Pixel>> getPixels() {
    return this.lop;
  }
}
