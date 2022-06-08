package command;

import image.Image;
import image.Pixel;

/**
 * Represents the greyscale by setting all rgb values to the corresponding pixel's average
 * rgb component.
 */
public class IntensityMacro implements CommandMacro {
  @Override
  public void command(Image image) {
    for (int i = 0; i < image.getHeight(); i++) {
      for (int j = 0; j < image.getWidth(); j++) {
        Pixel pix = image.getPixels().get(i).get(j);
        int val = (pix.getR() + pix.getG() + pix.getB()) / 3;
        image.getPixels().get(i).set(j, new Pixel(val, val, val));
      }
    }
  }
}
