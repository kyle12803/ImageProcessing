package command;

import image.Image;
import image.Pixel;

/**
 * Represents the Luma greyscale by rounding the value of RGB's to the nearest integer after
 * arithmetic application.
 */
public class LumaMacro implements CommandMacro {
  private final Image image;

  /**
   * This is the constructor to run the luma macro.
   *
   * @param image - this is the image for the luma macro to run on.
   */
  public LumaMacro(Image image) {
    this.image = image;
  }

  @Override
  public void command() {
    for (int i = 0; i < image.getHeight(); i++) {
      for (int j = 0; j < image.getWidth(); j++) {
        Pixel pix = image.getPixels().get(i).get(j);
        int val = (int) Math.round(
                (pix.getR() * .2126) + (pix.getG() * .7152) + (pix.getB() * .0722));
        image.getPixels().get(i).set(j, new Pixel(val, val, val));
      }
    }
  }
}
