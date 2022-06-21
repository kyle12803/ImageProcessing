package command;

import image.Image;

/**
 * Command macro to blur an image.
 */
public class BlurMacro extends AbstractFilter {

  /**
   * Constructor for the command to blur an image.
   *
   * @param image the image to be blurred
   */
  public BlurMacro(Image image) {
    super(image, new double[][]{
            {0.0625, 0.125, 0.0625},
            {0.125, 0.25, 0.125},
            {0.0625, 0.125, 0.0625}
    });
  }
}
