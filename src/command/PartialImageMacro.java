package command;

import image.Image;
import image.Pixel;

/**
 * Represents a partial image manipulation command macro which only partially applies a command to
 * an image depending on the mask image.
 */
public class PartialImageMacro implements CommandMacro {

  private final Image maskImage;
  private final Image filteredImage;
  private final Image original;

  /**
   * Constructs a partial image command macro.
   *
   * @param maskImage     the mask image to compare to
   * @param filteredImage the image with the already applied command
   * @param original      the original image
   */
  public PartialImageMacro(Image maskImage, Image filteredImage, Image original) {
    this.maskImage = maskImage;
    this.filteredImage = filteredImage;
    this.original = original;
  }

  @Override
  public void command() {
    for (int i = 0; i < this.maskImage.getHeight(); i++) {
      for (int j = 0; j < this.maskImage.getWidth(); j++) {
        Pixel maskPix = this.maskImage.getPixels().get(i).get(j);
        if (maskPix.getR() != 0 || maskPix.getG() != 0 || maskPix.getB() != 0) {
          Pixel originalPix = this.original.getPixels().get(i).get(j);
          this.filteredImage.getPixels().get(i).set(j,
                  new Pixel(originalPix.getR(), originalPix.getG(), originalPix.getB()));
        }
      }
    }
  }
}
