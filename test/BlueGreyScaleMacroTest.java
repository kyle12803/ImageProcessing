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
 * This is the class to run our blue grey scale macro tests.
 */
public class BlueGreyScaleMacroTest {

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
    this.exampleTest5 = new Pixel(200, 25, 25);
    this.exampleTest6 = new Pixel(55, 25, 55);
    this.lop1 = new ArrayList<>(asList(
        new ArrayList<>(asList(exampleTest1, exampleTest2, exampleTest3)),
        new ArrayList<>(asList(exampleTest4, exampleTest5, exampleTest6))));
    this.lop2 = new ArrayList<>(asList(
        new ArrayList<>(asList(exampleTest1, exampleTest2)),
        new ArrayList<>(asList(exampleTest3, exampleTest4))));

    this.image1 = new ImageImpl(255, 3, 2, lop1);
    this.image2 = new ImageImpl(255, 2, 2, lop2);
    this.modelExample = new ImageProcessingModelImpl();
  }

  @Test
  public void blueGreyScaleMacroTest1() {
    CommandMacro blueGreyScaleExample1 = new BlueGreyScaleMacro(image1);
    blueGreyScaleExample1.command();
    assertEquals(70, image1.getPixels().get(0).get(0).getR());
    assertEquals(70, image1.getPixels().get(0).get(0).getG());
    assertEquals(70, image1.getPixels().get(0).get(0).getB());
    assertEquals(0, image1.getPixels().get(0).get(1).getR());
    assertEquals(0, image1.getPixels().get(0).get(1).getG());
    assertEquals(0, image1.getPixels().get(0).get(1).getB());
    assertEquals(60, image1.getPixels().get(0).get(2).getR());
    assertEquals(60, image1.getPixels().get(0).get(2).getG());
    assertEquals(60, image1.getPixels().get(0).get(2).getB());
    assertEquals(255, image1.getPixels().get(1).get(0).getR());
    assertEquals(255, image1.getPixels().get(1).get(0).getG());
    assertEquals(255, image1.getPixels().get(1).get(0).getB());
    assertEquals(25, image1.getPixels().get(1).get(1).getR());
    assertEquals(25, image1.getPixels().get(1).get(1).getG());
    assertEquals(25, image1.getPixels().get(1).get(1).getB());
    assertEquals(55, image1.getPixels().get(1).get(2).getR());
    assertEquals(55, image1.getPixels().get(1).get(2).getG());
    assertEquals(55, image1.getPixels().get(1).get(2).getB());

  }

  @Test
  public void blueGreyScaleMacroTest2() {
    CommandMacro blueGreyScaleExample2 = new BlueGreyScaleMacro(image2);
    blueGreyScaleExample2.command();
    assertEquals(70, image2.getPixels().get(0).get(0).getR());
    assertEquals(70, image2.getPixels().get(0).get(0).getG());
    assertEquals(70, image2.getPixels().get(0).get(0).getB());
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