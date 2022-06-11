import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import command.BlueGreyScaleMacro;
import command.CommandMacro;
import image.Image;
import image.ImageImpl;
import image.Pixel;
import model.ImageProcessingModel;
import model.ImageProcessingModelImpl;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * Examples class of an image processing model used for testing purposes.
 */
public class ModelTest {
  Pixel exampleTest1;
  Pixel exampleTest2;
  Pixel exampleTest3;
  Pixel exampleTest4;
  Pixel exampleTest5;
  Pixel exampleTest6;

  List<List<Pixel>> lop1;
  List<List<Pixel>> lop2;

  Image image1;
  Image image2;

  ImageProcessingModel modelExample;

  @Before
  public void testConstructor() {
    this.exampleTest1 = new Pixel(50, 60, 70);
    this.exampleTest2 = new Pixel(0, 0, 0);
    this.exampleTest3 = new Pixel(60, 60, 60);
    this.exampleTest4 = new Pixel(255, 255, 255);
    this.exampleTest5 = new Pixel(300, 25, 25);
    this.exampleTest6 = new Pixel(55, 25, 55);
    this.lop1 = new ArrayList<>(asList(
        new ArrayList<>(asList(exampleTest1, exampleTest2, exampleTest3)),
        new ArrayList<>(asList(exampleTest4, exampleTest5, exampleTest6))));
    this.lop2 = new ArrayList<>(asList(
        new ArrayList<>(asList(exampleTest1, exampleTest2)),
        new ArrayList<>(asList(exampleTest3, exampleTest4))));

    this.image1 = new ImageImpl(255, 3, 2, lop1);
    this.image2 = new ImageImpl(70, 2, 2, lop2);
    this.modelExample = new ImageProcessingModelImpl();
  }

  @Test
  public void testAddImage() {
    modelExample.addImage(image1, "Image 1");
    modelExample.addImage(image2, "Image 2");
    assertEquals(image1, modelExample.getImage("Image 1"));
    assertEquals(image2, modelExample.getImage("Image 2"));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testExceptionAddImage1() {
    modelExample.addImage(null, null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testExceptionAddImage2() {
    modelExample.addImage(image1, null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testExceptionAddImage3() {
    modelExample.addImage(null, "image");
  }

  @Test
  public void testGetImage() {
    modelExample.addImage(image1, "Image 1");
    modelExample.addImage(image2, "Image 2");
    assertEquals(image1, modelExample.getImage("Image 1"));
    assertEquals(image2, modelExample.getImage("Image 2"));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testExceptionGetImage() {
    modelExample.getImage(null);
    modelExample.getImage("Kyle");
  }

  @Test
  public void testClone() {
    this.modelExample.addImage(image1, "first");
    Image clone = this.modelExample.clone("first", "firstClone");
    assertEquals(image1.getMaxValue(), clone.getMaxValue());
    assertEquals(image1.getWidth(), clone.getWidth());
    assertEquals(image1.getHeight(), clone.getHeight());
    for (int i = 0; i < image1.getHeight(); i++) {
      for (int j = 0; j < image1.getWidth(); j++) {
        Pixel pix1 = image1.getPixels().get(i).get(j);
        Pixel pix2 = clone.getPixels().get(i).get(j);
        assertEquals(pix1.getR(), pix2.getR());
        assertEquals(pix1.getG(), pix2.getG());
        assertEquals(pix1.getB(), pix2.getB());
      }
    }
  }

  @Test(expected = IllegalArgumentException.class)
  public void testCloneException1() {
    modelExample.clone(null, "image");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testCloneException2() {
    this.modelExample.addImage(image1, "first");
    modelExample.clone("first", null);
  }

  /**
   * This test will only test one command to make sure that the execute method
   * works. Each command
   * will have their own file to make sure the execution of that command behaves
   * appropriately.
   */
  @Test
  public void testExecute() {
    modelExample.addImage(image2, "Image 2");
    Image clone = this.modelExample.clone("Image 2", "2Clone");
    CommandMacro blueGreyScaleMacroExample = new BlueGreyScaleMacro(clone);
    modelExample.execute(blueGreyScaleMacroExample);
    for (int i = 0; i < image2.getHeight(); i++) {
      for (int j = 0; j < image2.getWidth(); j++) {
        int val = image2.getPixels().get(i).get(j).getB();
        Pixel pix = clone.getPixels().get(i).get(j);
        assertEquals(pix.getR(), val);
        assertEquals(pix.getG(), val);
        assertEquals(pix.getB(), val);
      }
    }
  }
}
