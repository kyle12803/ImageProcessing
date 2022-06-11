import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import command.CommandMacro;
import command.RedGreyScaleMacro;
import image.Image;
import image.ImageImpl;
import image.Pixel;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * Examples class for red greyscale command macro used for testing.
 */
public class RedGreyScaleMacroTest {
  Pixel exampleTest1 = new Pixel(50, 60, 70);
  Pixel exampleTest2 = new Pixel(0, 0, 0);
  Pixel exampleTest3 = new Pixel(60, 60, 60);
  Pixel exampleTest4 = new Pixel(255, 255, 255);
  Pixel exampleTest5 = new Pixel(200, 25, 25);
  Pixel exampleTest6 = new Pixel(55, 25, 55);


  List<List<Pixel>> lop1 = new ArrayList<>(asList(
          new ArrayList<>(asList(exampleTest1, exampleTest2, exampleTest3)),
          new ArrayList<>(asList(exampleTest4, exampleTest5, exampleTest6))));
  List<List<Pixel>> lop2 = new ArrayList<>(asList(
          new ArrayList<>(asList(exampleTest1, exampleTest2)),
          new ArrayList<>(asList(exampleTest3, exampleTest4))));

  Image image1 = new ImageImpl(255, 3, 2, lop1);
  Image image2 = new ImageImpl(255, 2, 2, lop2);

  @Test
  public void redGreyScaleMacroTest1() {
    CommandMacro redGreyScaleExample1 = new RedGreyScaleMacro(image1);
    redGreyScaleExample1.command();
    assertEquals(50, image1.getPixels().get(0).get(0).getR());
    assertEquals(50, image1.getPixels().get(0).get(0).getG());
    assertEquals(50, image1.getPixels().get(0).get(0).getB());
    assertEquals(0, image1.getPixels().get(0).get(1).getR());
    assertEquals(0, image1.getPixels().get(0).get(1).getG());
    assertEquals(0, image1.getPixels().get(0).get(1).getB());
    assertEquals(60, image1.getPixels().get(0).get(2).getR());
    assertEquals(60, image1.getPixels().get(0).get(2).getG());
    assertEquals(60, image1.getPixels().get(0).get(2).getB());
    assertEquals(255, image1.getPixels().get(1).get(0).getR());
    assertEquals(255, image1.getPixels().get(1).get(0).getG());
    assertEquals(255, image1.getPixels().get(1).get(0).getB());
    assertEquals(200, image1.getPixels().get(1).get(1).getR());
    assertEquals(200, image1.getPixels().get(1).get(1).getG());
    assertEquals(200, image1.getPixels().get(1).get(1).getB());
    assertEquals(55, image1.getPixels().get(1).get(2).getR());
    assertEquals(55, image1.getPixels().get(1).get(2).getG());
    assertEquals(55, image1.getPixels().get(1).get(2).getB());

  }

  @Test
  public void redGreyScaleMacroTest2() {
    CommandMacro redGreyScaleExample2 = new RedGreyScaleMacro(image2);
    redGreyScaleExample2.command();
    assertEquals(50, image2.getPixels().get(0).get(0).getR());
    assertEquals(50, image2.getPixels().get(0).get(0).getG());
    assertEquals(50, image2.getPixels().get(0).get(0).getB());
    assertEquals(0, image2.getPixels().get(0).get(1).getR());
    assertEquals(0, image2.getPixels().get(0).get(1).getG());
    assertEquals(0, image2.getPixels().get(0).get(1).getB());
    assertEquals(60, image2.getPixels().get(1).get(0).getR());
    assertEquals(60, image2.getPixels().get(1).get(0).getG());
    assertEquals(60, image2.getPixels().get(1).get(0).getB());
    assertEquals(255, image2.getPixels().get(1).get(1).getR());
    assertEquals(255, image2.getPixels().get(1).get(1).getG());
    assertEquals(255, image2.getPixels().get(1).get(1).getB());
  }
}