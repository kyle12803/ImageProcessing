package command;

import java.util.Collections;

import image.Image;

public class VerticalFlipMacro implements CommandMacro {
  private final Image image;

  public VerticalFlipMacro(Image image) {
    this.image = image;
  }
  @Override
  public void command() {
    Collections.reverse(this.image.getPixels());
  }
}
