package command;

import image.Image;

/**
 * Command macro to sharpen an image.
 */
public class SharpenMacro extends AbstractFilter {

  /**
   * Constructor for the command to sharpen an image.
   *
   * @param image the image to be sharpened
   */
  public SharpenMacro(Image image) {
    super(image, new double[][]{
            {-0.125, -0.125, -0.125, -0.125, -0.125},
            {-0.125, 0.25, 0.25, 0.25, -0.125},
            {-0.125, 0.25, 1.0, 0.25, -0.125},
            {-0.125, 0.25, 0.25, 0.25, -0.125},
            {-0.125, -0.125, -0.125, -0.125, -0.125}
    });
  }

}
