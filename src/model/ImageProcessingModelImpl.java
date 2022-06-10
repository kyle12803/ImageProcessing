package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
  public Image clone(String image, String dest) throws IllegalArgumentException {
    if (dest == null) {
      throw new IllegalArgumentException("Null destination name.");
    }
    Image img = this.getImage(image);
    int max = img.getMaxValue();
    int width = img.getWidth();
    int height = img.getHeight();
    List<List<Pixel>> lop = new ArrayList<>();

    for (int i = 0; i < height; i++) {
      List<Pixel> pix = new ArrayList<>();
      for (int j = 0; j < width; j++) {
        pix.add(img.getPixels().get(i).get(j));
      }
      lop.add(pix);
    }

    Image clone = new ImageImpl(max, width, height, lop);
    this.moi.put(dest, clone);
    return clone;
  }

  @Override
  public void execute(CommandMacro commandMacro) {
    commandMacro.command();
  }

}
