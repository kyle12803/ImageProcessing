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
  public void execute(CommandMacro commandMacro) {
    commandMacro.command();
  }
}
