package command;

import image.Image;
import image.Pixel;

abstract class AbstractFilter implements CommandMacro {
  private final double[][] matrix;
  private final Image image;

  public AbstractFilter(Image image, double[][] matrix) {
    this.image = image;
    this.matrix = matrix;
  }

  @Override
  public void command() {
    for (int k = 0; k < this.image.getHeight(); k++) {
      for (int l = 0; l < this.image.getWidth(); l++) {
        double newRed = 0;
        double newGreen = 0;
        double newBlue = 0;


        for (int i = 0; i < this.matrix.length; i++) {
          for (int j = 0; j < this.matrix.length; j++) {
            int x = k - (matrix.length / 2) + i;
            int y = l - (matrix.length / 2) + j;
            if (x >= 0 && x < image.getHeight()
                    && y >= 0 && y < image.getWidth()) {
              Pixel pix = this.image.getPixels().get(x).get(y);
              newRed += pix.getR() * this.matrix[i][j];
              newGreen += pix.getG() * this.matrix[i][j];
              newBlue += pix.getB() * this.matrix[i][j];
            }
          }
        }

        this.image.getPixels().get(k).set(l,
                new Pixel(Math.min(Math.max((int) newRed, 0), image.getMaxValue()),
                        Math.min(Math.max((int) newGreen, 0), image.getMaxValue()),
                        (Math.min(Math.max((int) newBlue, 0), image.getMaxValue()))));
      }
    }
  }
}
