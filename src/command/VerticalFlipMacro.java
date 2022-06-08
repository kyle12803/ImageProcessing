package command;

import java.util.Collections;

import image.Image;

public class VerticalFlipMacro implements CommandMacro {

  @Override
  public void command(Image image) {
    Collections.reverse(image.getPixels());
  }
}
