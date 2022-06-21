package file;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.imageio.ImageIO;

import image.Image;
import image.ImageImpl;
import image.Pixel;

/**
 * This is the class to load a file.
 */
public class LoadFile {

  /**
   * This is the method to load an image within our program.
   *
   * @param filename the file name of the file we want to load
   * @return an image is returned after loading
   * @throws IllegalArgumentException if the name or image is null
   */
  public Image load(String filename) throws IllegalArgumentException {
    Scanner sc;
    String[] arr = filename.split("\\.");
    Image loaded;
    switch (arr[arr.length - 1]) {
      case ("ppm"):
        try {
          sc = new Scanner(new FileInputStream(filename));
        } catch (IOException e) {
          throw new IllegalArgumentException();
        }
        StringBuilder builder = new StringBuilder();
        //read the file line by line, and populate a string. This will throw away any comment lines
        while (sc.hasNextLine()) {
          String s = sc.nextLine();
          if (s.charAt(0) != '#') {
            builder.append(s).append(System.lineSeparator());
          }
        }
        sc.close();

        //now set up the scanner to read from the string we just built
        sc = new Scanner(builder.toString());

        String token;

        token = sc.next();
        if (!token.equals("P3")) {
          System.out.println("Invalid PPM file: plain RAW file should begin with P3");
        }
        int width = sc.nextInt();
        int height = sc.nextInt();
        int maxValue = sc.nextInt();

        List<List<Pixel>> lop = new ArrayList<>();
        for (int i = 0; i < height; i++) {
          List<Pixel> row = new ArrayList<>();
          for (int j = 0; j < width; j++) {
            int r = sc.nextInt();
            int g = sc.nextInt();
            int b = sc.nextInt();
            row.add(new Pixel(r, g, b));
          }
          lop.add(row);
        }
        loaded = new ImageImpl(maxValue, width, height, lop);
        sc.close();
        break;
      case "png":
      case "jpg":
      case "jpeg":
      case "bmp":
        try {
          BufferedImage image = ImageIO.read(new File(filename));
          List<List<Pixel>> list = new ArrayList<>();
          for (int i = 0; i < image.getHeight(); i++) {
            List<Pixel> row = new ArrayList<>();
            for (int j = 0; j < image.getWidth(); j++) {
              int val = image.getRGB(j, i);
              Color color = new Color(val);
              Pixel pix = new Pixel(color.getRed(), color.getGreen(), color.getBlue());
              row.add(pix);
            }
            list.add(row);
          }
          loaded = new ImageImpl(255, image.getWidth(), image.getHeight(), list);
        } catch (IOException e) {
          throw new IllegalArgumentException();
        }
        break;
      default:
        return null;
    }
    return loaded;
  }
}

