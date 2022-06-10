package command;

import image.Image;
import image.Pixel;

/**
 * Represents the greyscale by setting all rgb values to the corresponding pixel's green component.
 */
public class GreenGreyScaleMacro implements CommandMacro {
  private final Image image;

  /**
   * This is the constructor for a green grey scale macro.
   *
   * @param image - the image to run command on.
   */
  public GreenGreyScaleMacro(Image image) {
    this.image = image;
  }

  @Override
  public void command() {
    for (int i = 0; i < this.image.getHeight(); i++) {
      for (int j = 0; j < this.image.getWidth(); j++) {
        int val = this.image.getPixels().get(i).get(j).getG();
        this.image.getPixels().get(i).set(j, new Pixel(val, val, val));
      }
    }
  }
}
