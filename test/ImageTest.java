import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import image.Image;
import image.ImageImpl;
import image.Pixel;

/**
 * This class makes sure everything within an image class works as intended.
 */
public class ImageTest {
  Pixel exampleTest1 = new Pixel(50,60,70);
  Pixel exampleTest2 = new Pixel(0,0,0);
  Pixel exampleTest3 = new Pixel(60,60,60);
  Pixel exampleTest4 = new Pixel(255,255,255);
  Pixel exampleTest5 = new Pixel(300,25,25);
  Pixel exampleTest6 = new Pixel(55,25,55);


  List<List<Pixel>> lop1 = new ArrayList(asList(exampleTest1, exampleTest2,
          exampleTest3, exampleTest4, exampleTest5, exampleTest6));
  List<List<Pixel>> lop2 =  new ArrayList(asList(exampleTest1, exampleTest2,
          exampleTest3));

  Image image1 = new ImageImpl(255, 2, 1, lop1);
  Image image2 = new ImageImpl(70, 1, 1, lop2);

  @Before
  public void testConstructor(){
    Image image1 = new ImageImpl(255, 2, 1, lop1);
    Image image2 = new ImageImpl(70, 2, 1, lop2);
  }

  @Test
  public void testGetMaxValue(){
    assertEquals(255, image1.getMaxValue());
    assertEquals(70, image2.getMaxValue());
  }

  @Test
  public void testGetWidth(){
    assertEquals(2, image1.getWidth());
    assertEquals(1, image2.getWidth());
  }

  @Test
  public void testGetLop(){
    assertEquals(lop1, image1.getPixels());
    assertEquals(lop2, image2.getPixels());
  }



}
