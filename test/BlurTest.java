import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import command.CommandMacro;
import command.BlurMacro;
import image.Image;
import image.ImageImpl;
import image.Pixel;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * Class to test the image blur filter command.
 */
public class BlurTest {
  Pixel exampleTest1 = new Pixel(50, 60, 70);
  Pixel exampleTest2 = new Pixel(0, 0, 0);
  Pixel exampleTest3 = new Pixel(60, 60, 60);
  Pixel exampleTest4 = new Pixel(255, 255, 255);
  Pixel exampleTest5 = new Pixel(100, 25, 25);
  Pixel exampleTest6 = new Pixel(55, 25, 55);


  List<List<Pixel>> lop1 = new ArrayList<>(asList(
          new ArrayList<>(asList(exampleTest1, exampleTest2, exampleTest3)),
          new ArrayList<>(asList(exampleTest4, exampleTest5, exampleTest6))));
  Image image1 = new ImageImpl(255, 3, 2, lop1);


  @Test
  public void sharpenTest1() {
    CommandMacro blurExample1 = new BlurMacro(image1);
    blurExample1.command();
    assertEquals(50, image1.getPixels().get(0).get(0).getR());
    assertEquals(48, image1.getPixels().get(0).get(0).getG());
    assertEquals(50, image1.getPixels().get(0).get(0).getB());
    assertEquals(45, image1.getPixels().get(0).get(1).getR());
    assertEquals(34, image1.getPixels().get(0).get(1).getG());
    assertEquals(36, image1.getPixels().get(0).get(1).getB());
    assertEquals(33, image1.getPixels().get(0).get(2).getR());
    assertEquals(23, image1.getPixels().get(0).get(2).getG());
    assertEquals(27, image1.getPixels().get(0).get(2).getB());
    assertEquals(85, image1.getPixels().get(1).get(0).getR());
    assertEquals(75, image1.getPixels().get(1).get(0).getG());
    assertEquals(75, image1.getPixels().get(1).get(0).getB());
    assertEquals(53, image1.getPixels().get(1).get(1).getR());
    assertEquals(27, image1.getPixels().get(1).get(1).getG());
    assertEquals(31, image1.getPixels().get(1).get(1).getB());
    assertEquals(27, image1.getPixels().get(1).get(2).getR());
    assertEquals(14, image1.getPixels().get(1).get(2).getG());
    assertEquals(23, image1.getPixels().get(1).get(2).getB());
  }
}