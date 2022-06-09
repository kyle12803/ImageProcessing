package command;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import image.Image;
import image.ImageImpl;
import image.Pixel;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class RedGreyScaleMacroTest {
  Pixel exampleTest1 = new Pixel(50,60,70);
  Pixel exampleTest2 = new Pixel(0,0,0);
  Pixel exampleTest3 = new Pixel(60,60,60);
  Pixel exampleTest4 = new Pixel(255,255,255);
  Pixel exampleTest5 = new Pixel(300,25,25);
  Pixel exampleTest6 = new Pixel(55,25,55);


  List<List<Pixel>> lop1 = new ArrayList<>(asList(
          new ArrayList<>(asList(exampleTest1, exampleTest2, exampleTest3)),
          new ArrayList<>(asList(exampleTest4, exampleTest5, exampleTest6))));
  List<List<Pixel>> lop2 =  new ArrayList<>(asList(
          new ArrayList<>(asList(exampleTest1, exampleTest2)),
          new ArrayList<>(asList(exampleTest3, exampleTest4))));

  Image image1 = new ImageImpl(255, 3, 2, lop1);
  Image image2 = new ImageImpl(70, 2, 2, lop2);

  @Test
  public void blueGreyScaleMacroTest1(){
    CommandMacro redGreyScaleExample1 = new RedGreyScaleMacro(image1);
    redGreyScaleExample1.command();
    assertEquals(exampleTest1.getR() == exampleTest1.getB(),
            exampleTest1.getR() == exampleTest1.getG());
    assertEquals(exampleTest2.getR() == exampleTest2.getB(),
            exampleTest2.getR() == exampleTest2.getG());
    assertEquals(exampleTest3.getR() == exampleTest3.getB(),
            exampleTest3.getR() == exampleTest3.getG());
    assertEquals(exampleTest4.getR() == exampleTest4.getB(),
            exampleTest4.getR() == exampleTest4.getG());
    assertEquals(exampleTest5.getR() == exampleTest5.getB(),
            exampleTest5.getR() == exampleTest5.getG());
    assertEquals(exampleTest6.getR() == exampleTest6.getB(),
            exampleTest6.getR() == exampleTest6.getG());

  }

  @Test
  public void blueGreyScaleMacroTest2(){
    CommandMacro redGreyScaleExample2 = new RedGreyScaleMacro(image2);
    redGreyScaleExample2.command();
    assertEquals(exampleTest1.getR() == exampleTest1.getB(),
            exampleTest1.getR() == exampleTest1.getG());
    assertEquals(exampleTest2.getR() == exampleTest2.getB(),
            exampleTest2.getR() == exampleTest2.getG());
    assertEquals(exampleTest3.getR() == exampleTest3.getB(),
            exampleTest3.getR() == exampleTest3.getG());
    assertEquals(exampleTest4.getR() == exampleTest4.getB(),
            exampleTest4.getR() == exampleTest4.getG());
  }
}
