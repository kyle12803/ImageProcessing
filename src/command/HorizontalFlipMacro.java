package command;

import java.util.Collections;

import image.Image;

public class HorizontalFlipMacro implements CommandMacro {


  @Override
  public void command(Image image) {
    for (int i = 0; i < image.getHeight(); i++) {
      for (int j = 0, k = image.getWidth() - 1; j < k; j++) {
//        image.getPixels().get(i).add(j, image.getPixels().get(i).get(k));
        Collections.reverse(image.getPixels().get(i));
      }
    }
  }
}
