package command;


import image.Image;
import image.Pixel;

/**
 * Represents the greyscale by setting all rgb values to the corresponding pixel's red component.
 */
public class RedGreyScaleMacro implements CommandMacro {
  private final Image image;

  /**
   * This is the constructor for the red grey scale macro.
   *
   * @param image - this is the image to run it on.
   */
  public RedGreyScaleMacro(Image image) {
    this.image = image;
  }

  @Override
  public void command() {
    for (int i = 0; i < this.image.getHeight(); i++) {
      for (int j = 0; j < this.image.getWidth(); j++) {
        int val = this.image.getPixels().get(i).get(j).getR();
        this.image.getPixels().get(i).set(j, new Pixel(val, val, val));
      }
    }
  }
}
