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
import static org.junit.Assert.assertTrue;

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
  public void testConstructor(){
    this.exampleTest1 = new Pixel(50,60,70);
    this.exampleTest2 = new Pixel(0,0,0);
    this.exampleTest3 = new Pixel(60,60,60);
    this.exampleTest4 = new Pixel(255,255,255);
    this.exampleTest5 = new Pixel(300,25,25);
    this.exampleTest6 = new Pixel(55,25,55);
    this.lop1 = new ArrayList<>(asList(
            new ArrayList<>(asList(exampleTest1, exampleTest2, exampleTest3)),
            new ArrayList<>(asList(exampleTest4, exampleTest5, exampleTest6))));
    this.lop2 =  new ArrayList<>(asList(
            new ArrayList<>(asList(exampleTest1, exampleTest2)),
            new ArrayList<>(asList(exampleTest3, exampleTest4))));

    this.image1 = new ImageImpl(255, 3, 2, lop1);
    this.image2 = new ImageImpl(70, 2, 2, lop2);
    this.modelExample = new ImageProcessingModelImpl();
  }

  @Test
  public void testAddImage(){
    modelExample.addImage(image1, "Image 1");
    modelExample.addImage(image2, "Image 2");
    assertEquals(image1, modelExample.getImage("Image 1"));
    assertEquals(image2, modelExample.getImage("Image 2"));
  }

  @Test (expected = IllegalArgumentException.class)
  public void testExceptionAddImage(){
    modelExample.addImage(null, null);
    modelExample.addImage(image1, null);
    modelExample.addImage(null, "image");
  }


  @Test
  public void testGetImage(){
    modelExample.addImage(image1, "Image 1");
    modelExample.addImage(image2, "Image 2");
    assertEquals(image1, modelExample.getImage("Image 1"));
    assertEquals(image2, modelExample.getImage("Image 2"));
  }

  @Test (expected = IllegalArgumentException.class)
  public void testExceptionGetImage(){
    modelExample.getImage(null);
    modelExample.getImage("Kyle");
  }

  /**
   * This test will only test one command to make sure that the execute method works. Each command
   * will have their own file to make sure the execution of that command behaves appropriately.
   */
  @Test
  public void testExecute(){
    CommandMacro blueGreyScaleMacroExample = new BlueGreyScaleMacro(image2);
    modelExample.addImage(image2, "Image 2");
    modelExample.execute(blueGreyScaleMacroExample);
    assertTrue(exampleTest1.getR() == 70
            && exampleTest1.getG() == 70
            && exampleTest1.getB() == 70);
    assertTrue(exampleTest2.getB() == 0
            && exampleTest2.getR() == 0
            && exampleTest3.getG() == 0);
    assertTrue(exampleTest3.getB() == 60
            && exampleTest2.getG() == 60
            && exampleTest2.getR() == 60);

  }



}
