package command;

import image.Image;
import image.Pixel;

/**
 * Represents the greyscale by setting all rgb values to the corresponding pixel's blue component.
 */
public class BlueGreyScaleMacro implements CommandMacro {
  private final Image image;

  /**
   * Constructs a blue grey scale macro with the given image.
   *
   * @param image the image to perform the macro on
   */
  public BlueGreyScaleMacro(Image image) {
    this.image = image;
  }

  @Override
  public void command() {
    for (int i = 0; i < this.image.getHeight(); i++) {
      for (int j = 0; j < this.image.getWidth(); j++) {
        int val = image.getPixels().get(i).get(j).getB();
        image.getPixels().get(i).set(j, new Pixel(val, val, val));
      }
    }
  }
}
