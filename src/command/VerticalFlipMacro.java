package command;

import java.util.Collections;

import image.Image;

/**
 * This is the vertical flip command macro which vertically inverts an image.
 */
public class VerticalFlipMacro implements CommandMacro {
  private final Image image;

  /**
   * Constructs a vertical flip macro with the given image.
   *
   * @param image the image to perform on
   */
  public VerticalFlipMacro(Image image) {
    this.image = image;
  }

  @Override
  public void command() {
    Collections.reverse(this.image.getPixels());
    for (int i = 0; i < this.image.getHeight(); i++) {
      for (int j = 0, k = this.image.getWidth() - 1; j < k; j++) {
        Collections.reverse(this.image.getPixels().get(i));
      }
    }
  }
}
