package command;

import java.util.ArrayList;
import java.util.List;

import image.Image;
import image.ImageImpl;
import image.Pixel;

/**
 * Represents a downscale function which downsizes an image by altering the width, height, and
 * pixels.
 */
public class Downscale {
  private final Image image;
  private final double scale;

  /**
   * Constructs downsize which resizes an image by the scale percentage given.
   *
   * @param image the image to be downscaled
   * @param scale the percentage to scale by
   * @throws IllegalArgumentException if scale is invalid
   */
  public Downscale(Image image, double scale) throws IllegalArgumentException {
    if (scale < 0 || scale > 100) {
      throw new IllegalArgumentException("Invalid scale to downsize.");
    }
    this.image = image;
    this.scale = scale;
  }

  /**
   * Resizes an image by creating a new image with the updated width, height, and new list of
   * pixels.
   *
   * @return the new downsized image
   */
  public Image resize() {
    // do we need this math.round?
    int newWidth = (int) ((1.0 - scale / 100) * this.image.getWidth());
    int newHeight = (int) ((1.0 - scale / 100) * this.image.getHeight());

    List<List<Pixel>> lop = new ArrayList<>();
    for (int i = 0; i < newHeight; i++) {
      List<Pixel> row = new ArrayList<>();
      for (int j = 0; j < newWidth; j++) {
        // x = (x' / w') * w
        row.add(pixelConverter(i * this.image.getHeight() / (double) newHeight,
                j * this.image.getWidth() / (double) newWidth));
      }
      lop.add(row);
    }
    return new ImageImpl(255, newWidth, newHeight, lop);
  }

  private Pixel pixelConverter(double i, double j) {
    Pixel A = this.image.getPixels().get((int) Math.floor(i)).get((int) Math.floor(j));
    Pixel B = this.image.getPixels().get((int) Math.ceil(i)).get((int) Math.floor(j));
    Pixel C = this.image.getPixels().get((int) Math.floor(i)).get((int) Math.ceil(j));
    Pixel D = this.image.getPixels().get((int) Math.ceil(i)).get((int) Math.ceil(j));

    double mRed = B.getR() * (j - Math.floor(j)) + A.getR() * (Math.round(j + 0.5) - j);
    double nRed = D.getR() * (j - Math.floor(j)) + C.getR() * (Math.round(j + 0.5) - j);
    int cRed = (int) (Math.round(nRed * (i - Math.floor(i)) + mRed * (Math.round(i + 0.5) - i)));

    double mGreen = B.getG() * (j - Math.floor(j)) + A.getG() * (Math.round(j + 0.5) - j);
    double nGreen = D.getG() * (j - Math.floor(j)) + C.getG() * (Math.round(j + 0.5) - j);
    int cGreen = (int) (Math.round(nGreen * (i - Math.floor(i)) + mGreen * (Math.round(i + 0.5) - i)));

    double mBlue = B.getB() * (j - Math.floor(j)) + A.getB() * (Math.round(j + 0.5) - j);
    double nBlue = D.getB() * (j - Math.floor(j)) + C.getB() * (Math.round(j + 0.5) - j);
    int cBlue = (int) (Math.round(nBlue * (i - Math.floor(i)) + mBlue * (Math.round(i + 0.5) - i)));

    return new Pixel(cRed, cGreen, cBlue);
  }
}
