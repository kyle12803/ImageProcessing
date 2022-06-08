package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import command.CommandMacro;
import image.Image;
import image.ImageImpl;
import image.Pixel;

/**
 * Represents the implementation of an image processor.
 */
public class ImageProcessingModelImpl implements ImageProcessingModel {

  private Map<String, Image> moi;

  public ImageProcessingModelImpl() {
    this.moi = new HashMap<String, Image>();
  }

  @Override
  public Image loadImage(String filename) throws IllegalArgumentException {
    Scanner sc;

    try {
      sc = new Scanner(new FileInputStream(filename));
    } catch (FileNotFoundException e) {
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
    return new ImageImpl(maxValue, width, height, lop);
  }

  @Override
  public void addImage(Image img, String name) throws IllegalArgumentException {
    if (img == null || name == null) {
      throw new IllegalArgumentException("Invalid image or name.");
    }
    this.moi.put(name, img);
  }

  @Override
  public Image getImage(String key) throws IllegalArgumentException {
    if (key == null) {
      throw new IllegalArgumentException("Invalid key to get.");
    }
    return this.moi.get(key);
  }

  @Override
  public void execute(CommandMacro commandMacro, String key) {
    commandMacro.command(this.moi.get(key));
  }
}
