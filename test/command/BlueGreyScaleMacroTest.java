package command;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import image.Image;
import image.ImageImpl;
import image.Pixel;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class BlueGreyScaleMacroTest {

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
  public void blueGreyScaleMacroTest(){
    CommandMacro blueGreyScaleExample1 = new BlueGreyScaleMacro(image1);
    CommandMacro blueGreyScaleExample2 = new BlueGreyScaleMacro(image2);
    blueGreyScaleExample1.command();
    blueGreyScaleExample2.command();
  }


}