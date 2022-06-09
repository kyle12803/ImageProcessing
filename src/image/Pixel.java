package image;

/**
 * Represents a single pixel which contains red, green, and blue components.
 */
public class Pixel {
  private final int red;
  private final int green;
  private final int blue;

  /**
   * Constructs a pixel with the given combination of red, blue, and green components.
   *
   * @param red   the value of red
   * @param green the value of green
   * @param blue  the value of blue
   * @throws IllegalArgumentException if any of the components are negative
   */
  public Pixel(int red, int green, int blue) throws IllegalArgumentException{
    if (red < 0 || green < 0 || blue < 0) {
      throw new IllegalArgumentException("Invalid RGB components.");
    }
    this.red = red;
    this.green = green;
    this.blue = blue;
  }

  public int getR() {
    return this.red;
  }

  public int getG() {
    return this.green;
  }

  public int getB() {
    return this.blue;
  }
}
