package command;

import image.Image;
import image.Pixel;

/**
 * Represents the greyscale by setting all rgb values to the corresponding pixel's average
 * rgb component.
 */
public class IntensityMacro implements CommandMacro {
  private final Image image;

  /**
   * This is the constructor for the intensity macro.
   *
   * @param image - image needed to run the macro on.
   */
  public IntensityMacro(Image image) {
    this.image = image;
  }

  @Override
  public void command() {
    for (int i = 0; i < this.image.getHeight(); i++) {
      for (int j = 0; j < this.image.getWidth(); j++) {
        Pixel pix = this.image.getPixels().get(i).get(j);
        int val = (int) (Math.round((pix.getR() + pix.getG() + pix.getB()) / 3.0));
        this.image.getPixels().get(i).set(j, new Pixel(val, val, val));
      }
    }
  }
}


