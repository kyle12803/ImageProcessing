package command;

import image.Image;
import image.Pixel;

/**
 *  Represents the Sepia greyscale by rounding the value of each RGB to the nearest integer after
 *  individual arithmetic application.
 */
public class SepiaMacro implements CommandMacro {
  private final Image image;

  /**
   * Constructs a sepia greyscale macro with the given image.
   *
   * @param image the image to perform the macro on
   */
  public SepiaMacro(Image image) {
    this.image = image;
  }

  @Override
  public void command() {
    for (int i = 0; i < image.getHeight(); i++) {
      for (int j = 0; j < image.getWidth(); j++) {
        Pixel pix = image.getPixels().get(i).get(j);
        int valR = (int) Math.round(
                ((pix.getR() * .393) + (pix.getG() * .769) + (pix.getB() * .189)));
        int valG = (int) Math.round(
                ((pix.getR() * .349) + (pix.getG() * .686) + (pix.getB() * .168)));
        int valB = (int) Math.round(
                ((pix.getR() * .272) + (pix.getG() * .534) + (pix.getB() * .131)));
        image.getPixels().get(i).set(j, new Pixel(Math.min(Math.max(valR, 0), image.getMaxValue()),
                Math.min(Math.max(valG, 0), image.getMaxValue()),
                Math.min(Math.max(valB, 0), image.getMaxValue())));
      }
    }
  }
}