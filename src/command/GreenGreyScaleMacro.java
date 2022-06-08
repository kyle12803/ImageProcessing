package command;

import image.Image;
import image.Pixel;

/**
 * Represents the greyscale by setting all rgb values to the corresponding pixel's green component.
 */
public class GreenGreyScaleMacro implements CommandMacro {

  @Override
  public void command(Image image) {
    for (int i = 0; i < image.getHeight(); i++) {
      for (int j = 0; j < image.getWidth(); j++) {
        int val = image.getPixels().get(i).get(j).getG();
        image.getPixels().get(i).set(j, new Pixel(val, val, val));
      }
    }
  }
}
