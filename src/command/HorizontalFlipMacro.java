package command;

import java.util.Collections;

import image.Image;

/**
 * This is the class to horizontally flip an image.
 */
public class HorizontalFlipMacro implements CommandMacro {
  private final Image image;

  /**
   * This is the command to horizontally flip an image.
   *
   * @param image - this is the image to horizontally flip.
   */
  public HorizontalFlipMacro(Image image) {
    this.image = image;
  }

  @Override
  public void command() {
    for (int i = 0; i < this.image.getHeight(); i++) {
      for (int j = 0, k = this.image.getWidth() - 1; j < k; j++) {
        Collections.reverse(this.image.getPixels().get(i));
      }
    }
  }
}
