import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import command.CommandMacro;
import command.SepiaMacro;
import image.Image;
import image.ImageImpl;
import image.Pixel;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * This is the class to test the image sepia command.
 */
public class SepiaTest {
  Pixel exampleTest1 = new Pixel(50, 60, 70);
  Pixel exampleTest2 = new Pixel(0, 0, 0);
  Pixel exampleTest3 = new Pixel(60, 60, 60);
  Pixel exampleTest4 = new Pixel(255, 255, 255);
  Pixel exampleTest5 = new Pixel(100, 25, 25);
  Pixel exampleTest6 = new Pixel(55, 25, 55);


  List<List<Pixel>> lop1 = new ArrayList<>(asList(
          new ArrayList<>(asList(exampleTest1, exampleTest2, exampleTest3)),
          new ArrayList<>(asList(exampleTest4, exampleTest5, exampleTest6))));
  List<List<Pixel>> lop2 = new ArrayList<>(asList(
          new ArrayList<>(asList(exampleTest1, exampleTest2)),
          new ArrayList<>(asList(exampleTest3, exampleTest4))));

  Image image1 = new ImageImpl(255, 3, 2, lop1);


  @Test
  public void sepiaTest1() {
    CommandMacro sepiaExample1 = new SepiaMacro(image1);
    sepiaExample1.command();
    assertEquals(79, image1.getPixels().get(0).get(0).getR());
    assertEquals(70, image1.getPixels().get(0).get(0).getG());
    assertEquals(55, image1.getPixels().get(0).get(0).getB());
    assertEquals(0, image1.getPixels().get(0).get(1).getR());
    assertEquals(0, image1.getPixels().get(0).get(1).getG());
    assertEquals(0, image1.getPixels().get(0).get(1).getB());
    assertEquals(81, image1.getPixels().get(0).get(2).getR());
    assertEquals(72, image1.getPixels().get(0).get(2).getG());
    assertEquals(56, image1.getPixels().get(0).get(2).getB());
    assertEquals(255, image1.getPixels().get(1).get(0).getR());
    assertEquals(255, image1.getPixels().get(1).get(0).getG());
    assertEquals(239, image1.getPixels().get(1).get(0).getB());
    assertEquals(63, image1.getPixels().get(1).get(1).getR());
    assertEquals(56, image1.getPixels().get(1).get(1).getG());
    assertEquals(44, image1.getPixels().get(1).get(1).getB());
    assertEquals(51, image1.getPixels().get(1).get(2).getR());
    assertEquals(46, image1.getPixels().get(1).get(2).getG());
    assertEquals(36, image1.getPixels().get(1).get(2).getB());
  }
}
