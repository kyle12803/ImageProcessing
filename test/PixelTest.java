import org.junit.Test;

import static org.junit.Assert.assertEquals;

import image.Pixel;

/**
 * This test class makes sure that everything within a Pixel class works
 * properly.
 */
public class PixelTest {

  Pixel exampleTest1 = new Pixel(50, 60, 70);
  Pixel exampleTest2 = new Pixel(0, 0, 0);
  Pixel exampleTest3 = new Pixel(60, 60, 60);
  Pixel exampleTest4 = new Pixel(255, 255, 255);

  @Test
  public void testGetRed() {
    assertEquals(50, exampleTest1.getR());
    assertEquals(0, exampleTest2.getR());
    assertEquals(60, exampleTest3.getR());
    assertEquals(255, exampleTest4.getR());
  }

  @Test
  public void testGetBlue() {
    assertEquals(70, exampleTest1.getB());
    assertEquals(0, exampleTest2.getB());
    assertEquals(60, exampleTest3.getB());
    assertEquals(255, exampleTest4.getB());
  }

  @Test
  public void testGetGreen() {
    assertEquals(60, exampleTest1.getG());
    assertEquals(0, exampleTest2.getG());
    assertEquals(60, exampleTest3.getG());
    assertEquals(255, exampleTest4.getG());
  }
}
