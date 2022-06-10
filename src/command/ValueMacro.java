package command;

import image.Image;
import image.Pixel;

/**
 * Represents the greyscale by setting all rgb values to the corresponding pixel's maximum
 * rgb component.
 */
public class ValueMacro implements CommandMacro {
  private final Image image;

  /**
   * This is the constructor for the value macro.
   *
   * @param image - this is the image to be run the command on.
   */
  public ValueMacro(Image image) {
    this.image = image;
  }

  @Override
  public void command() {
    for (int i = 0; i < this.image.getHeight(); i++) {
      for (int j = 0; j < this.image.getWidth(); j++) {
        int val = Math.max(this.image.getPixels().get(i).get(j).getR(),
                Math.max(this.image.getPixels().get(i).get(j).getG(),
                        this.image.getPixels().get(i).get(j).getB()));
        this.image.getPixels().get(i).set(j, new Pixel(val, val, val));
      }
    }
  }
}
