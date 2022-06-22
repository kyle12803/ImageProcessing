import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import command.Downscale;
import image.Image;
import image.ImageImpl;
import image.Pixel;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * Examples class for downscaling used for testing.
 */
public class DownscaleTest {
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
  Image image2 = new ImageImpl(255, 2, 2, lop2);

  @Test
  public void testDownscale1() {
    assertEquals(2, image1.getHeight());
    assertEquals(3, image1.getWidth());
    Image newImage = new Downscale(image1, 25).resize();
    assertEquals(1, newImage.getHeight());
    assertEquals(2, newImage.getWidth());
    assertEquals(50, newImage.getPixels().get(0).get(0).getR());
    assertEquals(60, newImage.getPixels().get(0).get(0).getG());
    assertEquals(70, newImage.getPixels().get(0).get(0).getB());
    assertEquals(0, newImage.getPixels().get(0).get(1).getR());
    assertEquals(0, newImage.getPixels().get(0).get(1).getG());
    assertEquals(0, newImage.getPixels().get(0).get(1).getB());
  }

  @Test
  public void testDownscale2() {
    assertEquals(2, image2.getHeight());
    assertEquals(2, image2.getWidth());
    Image newImage = new Downscale(image2, 50).resize();
    assertEquals(1, newImage.getHeight());
    assertEquals(1, newImage.getWidth());
    assertEquals(50, newImage.getPixels().get(0).get(0).getR());
    assertEquals(60, newImage.getPixels().get(0).get(0).getG());
    assertEquals(70, newImage.getPixels().get(0).get(0).getB());
  }
}
