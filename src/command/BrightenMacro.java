package command;

import image.Image;
import image.Pixel;

/**
 * Represents a brightness conversion with the given value to increment by. A negative value
 * darkens and a positive value brightens an image.
 */
public class BrightenMacro implements CommandMacro {
  private final int increment;

  public BrightenMacro(int increment) {
    this.increment = increment;
  }

  public void command(Image image) {
    for (int i = 0; i < image.getHeight(); i++) {
      for (int j = 0; j < image.getWidth(); j++) {
        Pixel pix = image.getPixels().get(i).get(j);
        image.getPixels().get(i).set(j, new Pixel(pix.getR() + increment,
                pix.getG() + increment, pix.getB() + increment));
      }
    }
  }
}
