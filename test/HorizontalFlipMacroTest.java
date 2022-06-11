
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import command.CommandMacro;
import command.HorizontalFlipMacro;
import image.Image;
import image.ImageImpl;
import image.Pixel;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * Examples class for horizontal flip command macro used for testing.
 */
public class HorizontalFlipMacroTest {

  Pixel exampleTest1 = new Pixel(50, 60, 70);
  Pixel exampleTest2 = new Pixel(0, 0, 0);
  Pixel exampleTest3 = new Pixel(60, 60, 60);
  Pixel exampleTest4 = new Pixel(255, 255, 255);


  List<List<Pixel>> copy = new ArrayList<>(asList(
          new ArrayList<>(asList(exampleTest1, exampleTest2)),
          new ArrayList<>(asList(exampleTest3, exampleTest4))));
  List<List<Pixel>> lop = new ArrayList<>(asList(
          new ArrayList<>(asList(exampleTest1, exampleTest2)),
          new ArrayList<>(asList(exampleTest3, exampleTest4))));

  Image image1 = new ImageImpl(255, 2, 2, lop);

  @Test
  public void horizontalFlipMacroTest() {
    CommandMacro horizontalFlipMacroExample = new HorizontalFlipMacro(image1);
    horizontalFlipMacroExample.command();
    for (int i = 0; i < image1.getHeight(); i++) {
      int k = image1.getWidth() - 1;
      for (int j = 0; j < image1.getWidth(); j++) {
        Pixel pix1 = copy.get(i).get(j);
        Pixel pix2 = image1.getPixels().get(i).get(k);
        assertEquals(pix1.getR(), pix2.getR());
        assertEquals(pix1.getG(), pix2.getG());
        assertEquals(pix1.getB(), pix2.getB());
        k--;
      }
    }
  }
}
