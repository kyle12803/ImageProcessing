package command;

import image.Image;
import image.Pixel;

/**
 * Represents a brightness conversion with the given value to increment by. A negative value
 * darkens and a positive value brightens an image.
 */
public class BrightenMacro implements CommandMacro {
  private final int increment;
  private final Image image;

  public BrightenMacro(Image image, int increment) {
    this.image = image;
    this.increment = increment;
  }

  public void command() {
    for (int i = 0; i < this.image.getHeight(); i++) {
      for (int j = 0; j < this.image.getWidth(); j++) {
        Pixel pix = this.image.getPixels().get(i).get(j);
        this.image.getPixels().get(i).set(j,
                new Pixel(checkComponent(pix.getR() + increment),
                        checkComponent(pix.getG() + increment),
                        checkComponent(pix.getB() + increment)));
      }
    }
  }

  private int checkComponent(int value) {
    if (value < 0) {
      return 0;
    } else return Math.min(value, image.getMaxValue());
  }
}
