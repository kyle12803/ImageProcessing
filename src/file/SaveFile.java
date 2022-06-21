package file;

import image.Image;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import image.Pixel;

/**
 * This is the class needed to save a file.
 */
public class SaveFile {
  private final Image image;

  public SaveFile(Image image) {
    this.image = image;
  }

  /**
   * This is the method to save an image.
   *
   * @param filepath the filepath of the image.
   * @throws IOException if nothing can be written or read.
   */
  public void save(String filepath) throws IOException {
    try {
      String[] arr = filepath.split("\\.");
      switch (arr[arr.length - 1]) {
        case "ppm":
          BufferedOutputStream output;
          try {
            output = new BufferedOutputStream(new FileOutputStream(filepath));
            StringBuilder rgbs = new StringBuilder();
            for (int i = 0; i < this.image.getHeight(); i++) {
              for (int j = 0; j < this.image.getWidth(); j++) {
                Pixel pix = this.image.getPixels().get(i).get(j);
                rgbs.append(pix.getR())
                        .append(" ")
                        .append(pix.getG())
                        .append(" ")
                        .append(pix.getB())
                        .append(" ");
              }
            }
            String contents = "P3\n" + " " + this.image.getWidth() + " " +
                    this.image.getHeight() + " "
                    + this.image.getMaxValue() + " " + rgbs.toString();
            byte[] array = contents.getBytes();
            // Writes byte to the file
            output.write(array);
            output.flush();
            output.close();
          } catch (IOException e) {
            throw new IllegalArgumentException("Could not save PPM file.");
          }
          break;
        case "jpg":
        case "jpeg":
        case "bmp":
          try {
            List<List<Pixel>> lop = image.getPixels();
            BufferedImage img = new BufferedImage(image.getWidth(), image.getHeight(),
                    BufferedImage.TYPE_INT_RGB);
            copyPixels(filepath, arr, lop, img);
          } catch (IOException e) {
            throw new IllegalArgumentException("Could not save file.");
          }
          break;
        case "png":
          try {
            List<List<Pixel>> lop = image.getPixels();
            BufferedImage img = new BufferedImage(image.getWidth(), image.getHeight(),
                    BufferedImage.TYPE_INT_ARGB);
            copyPixels(filepath, arr, lop, img);
          } catch (IOException e) {
            throw new IllegalArgumentException("Could not save file.");
          }
          break;
        default:
      }
    } catch (NullPointerException e) {
      throw new IllegalArgumentException("Could not save file.");
    }
  }

  private void copyPixels(String filepath, String[] arr, List<List<Pixel>> lop, BufferedImage img)
          throws IOException {
    for (int i = 0; i < image.getHeight(); i++) {
      for (int j = 0; j < image.getWidth(); j++) {
        Pixel pix = lop.get(i).get(j);

        int rgb = new Color(pix.getR(), pix.getG(), pix.getB()).getRGB();
        img.setRGB(j, i, rgb);
      }
    }
    ImageIO.write(img, arr[arr.length - 1],
            new File(filepath));
  }
}
