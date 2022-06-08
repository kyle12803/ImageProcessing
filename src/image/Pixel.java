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
   */
  public Pixel(int red, int green, int blue) {
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
