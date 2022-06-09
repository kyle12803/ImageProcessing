package command;

import java.util.Collections;

import image.Image;

public class HorizontalFlipMacro implements CommandMacro {
  private final Image image;

  public HorizontalFlipMacro(Image image) {
    this.image = image;
  }

  @Override
  public void command() {
    for (int i = 0; i < this.image.getHeight(); i++) {
      for (int j = 0, k = this.image.getWidth() - 1; j < k; j++) {
//        image.getPixels().get(i).add(j, image.getPixels().get(i).get(k));
        Collections.reverse(this.image.getPixels().get(i));
      }
    }
  }
}
