import org.junit.Before;
import org.junit.Test;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import controller.ImageProcessingController;
import controller.ImageProcessingControllerImpl;
import image.Image;
import image.ImageImpl;
import image.Pixel;
import model.ImageProcessingModel;
import model.ImageProcessingModelImpl;
import view.ImageProcessingView;
import view.ImageProcessingViewImpl;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * Examples class for image processing controller used for testing purposes.
 */
public class ControllerTest {
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
  ImageProcessingModel model;
  ImageProcessingView view;
  ImageProcessingController controller;
  Appendable ap;
  Readable rd;

  @Before
  public void setUp() {
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
    this.model = new ImageProcessingModelImpl();
    this.model.addImage(image1, "first");
    this.model.addImage(image2, "second");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorException1() {
    new ImageProcessingControllerImpl(null, this.model, this.view);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorException2() {
    new ImageProcessingControllerImpl(rd, null, this.view);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorException3() {
    new ImageProcessingControllerImpl(rd, this.model, null);
  }

  @Test
  public void testRunProgramQuit() {
    this.rd = new StringReader("Q");
    this.ap = new StringBuilder();
    this.view = new ImageProcessingViewImpl(ap);
    this.controller = new ImageProcessingControllerImpl(rd, model, view);
    controller.runProgram();
    assertEquals("Welcome to the image processing program!" + System.lineSeparator() +
            "Supported user instructions are: " + System.lineSeparator() +
            "load [image-path] [image-name]" + System.lineSeparator() +
            "save [image-path] [image-name]" + System.lineSeparator() +
            "red-component [image-name] [dest-image-name]" + System.lineSeparator() +
            "green-component [image-name] [dest-image-name]" + System.lineSeparator() +
            "blue-component [image-name] [dest-image-name]" + System.lineSeparator() +
            "value [image-name] [dest-image-name]" + System.lineSeparator() +
            "luma [image-name] [dest-image-name]" + System.lineSeparator() +
            "intensity [image-name] [dest-image-name]" + System.lineSeparator() +
            "horizontal-flip [image-name] [dest-image-name]" + System.lineSeparator() +
            "vertical-flip [image-name] [dest-image-name]" + System.lineSeparator() +
            "blur [image-name] [dest-image-name]" + System.lineSeparator() +
            "sharpen [image-name] [dest-image-name]" + System.lineSeparator() +
            "sepia [image-name] [dest-image-name]" + System.lineSeparator() +
            "brighten [increment] [image-name] [dest-image-name]" + System.lineSeparator() +
            "downscale [percentage-scale] [image-name] [dest-image-name]" + System.lineSeparator() +
            "If you would like to partially manipulate an image please use: " +
            "[command] [image-name] [mask-image] [dest-name]" + System.lineSeparator() +
            "q or quit (quit the program) " + System.lineSeparator() +
            "m or menu (prints the supported instructions menu) " + System.lineSeparator() +
            "Type instruction: Thank you for using this program!", this.ap.toString());
  }

  @Test
  public void testRunProgramInvalidOperation() {
    this.rd = new StringReader("load a a q");
    this.ap = new StringBuilder();
    this.view = new ImageProcessingViewImpl(ap);
    this.controller = new ImageProcessingControllerImpl(rd, model, view);
    controller.runProgram();
    assertEquals("Welcome to the image processing program!" + System.lineSeparator() +
            "Supported user instructions are: " + System.lineSeparator() +
            "load [image-path] [image-name]" + System.lineSeparator() +
            "save [image-path] [image-name]" + System.lineSeparator() +
            "red-component [image-name] [dest-image-name]" + System.lineSeparator() +
            "green-component [image-name] [dest-image-name]" + System.lineSeparator() +
            "blue-component [image-name] [dest-image-name]" + System.lineSeparator() +
            "value [image-name] [dest-image-name]" + System.lineSeparator() +
            "luma [image-name] [dest-image-name]" + System.lineSeparator() +
            "intensity [image-name] [dest-image-name]" + System.lineSeparator() +
            "horizontal-flip [image-name] [dest-image-name]" + System.lineSeparator() +
            "vertical-flip [image-name] [dest-image-name]" + System.lineSeparator() +
            "blur [image-name] [dest-image-name]" + System.lineSeparator() +
            "sharpen [image-name] [dest-image-name]" + System.lineSeparator() +
            "sepia [image-name] [dest-image-name]" + System.lineSeparator() +
            "brighten [increment] [image-name] [dest-image-name]" + System.lineSeparator() +
            "downscale [percentage-scale] [image-name] [dest-image-name]" + System.lineSeparator() +
            "If you would like to partially manipulate an image please use: " +
            "[command] [image-name] [mask-image] [dest-name]" + System.lineSeparator() +
            "q or quit (quit the program) " + System.lineSeparator() +
            "m or menu (prints the supported instructions menu) " + System.lineSeparator() +
            "Type instruction: Invalid operation! Please try again." + "\n" +
            "Thank you for using this program!", this.ap.toString());
  }

  @Test
  public void testRunLoad() {
    this.rd = new StringReader("load res/grandma.ppm grandma \n");
    this.ap = new StringBuilder();
    this.view = new ImageProcessingViewImpl(ap);
    this.controller = new ImageProcessingControllerImpl(rd, model, view);
    controller.runProgram();
    assertEquals("Welcome to the image processing program!" + System.lineSeparator() +
            "Supported user instructions are: " + System.lineSeparator() +
            "load [image-path] [image-name]" + System.lineSeparator() +
            "save [image-path] [image-name]" + System.lineSeparator() +
            "red-component [image-name] [dest-image-name]" + System.lineSeparator() +
            "green-component [image-name] [dest-image-name]" + System.lineSeparator() +
            "blue-component [image-name] [dest-image-name]" + System.lineSeparator() +
            "value [image-name] [dest-image-name]" + System.lineSeparator() +
            "luma [image-name] [dest-image-name]" + System.lineSeparator() +
            "intensity [image-name] [dest-image-name]" + System.lineSeparator() +
            "horizontal-flip [image-name] [dest-image-name]" + System.lineSeparator() +
            "vertical-flip [image-name] [dest-image-name]" + System.lineSeparator() +
            "blur [image-name] [dest-image-name]" + System.lineSeparator() +
            "sharpen [image-name] [dest-image-name]" + System.lineSeparator() +
            "sepia [image-name] [dest-image-name]" + System.lineSeparator() +
            "brighten [increment] [image-name] [dest-image-name]" + System.lineSeparator() +
            "downscale [percentage-scale] [image-name] [dest-image-name]" + System.lineSeparator() +
            "If you would like to partially manipulate an image please use: " +
            "[command] [image-name] [mask-image] [dest-name]" + System.lineSeparator() +
            "q or quit (quit the program) " + System.lineSeparator() +
            "m or menu (prints the supported instructions menu) " + System.lineSeparator() +
            "Type instruction: Thank you for using this program!", this.ap.toString());
  }

  @Test
  public void testRunProgramSave() {
    this.rd = new StringReader("load res/grandma.ppm grandma \n" +
            "red-component grandma redGrandma \n" +
            "save res/grandma.ppm redGrandma \n"
            + "q");
    this.ap = new StringBuilder();
    this.view = new ImageProcessingViewImpl(ap);
    this.controller = new ImageProcessingControllerImpl(rd, model, view);
    controller.runProgram();
    assertEquals("Welcome to the image processing program!" + System.lineSeparator() +
                    "Supported user instructions are: " + System.lineSeparator() +
                    "load [image-path] [image-name]" + System.lineSeparator() +
                    "save [image-path] [image-name]" + System.lineSeparator() +
                    "red-component [image-name] [dest-image-name]" + System.lineSeparator() +
                    "green-component [image-name] [dest-image-name]" + System.lineSeparator() +
                    "blue-component [image-name] [dest-image-name]" + System.lineSeparator() +
                    "value [image-name] [dest-image-name]" + System.lineSeparator() +
                    "luma [image-name] [dest-image-name]" + System.lineSeparator() +
                    "intensity [image-name] [dest-image-name]" + System.lineSeparator() +
                    "horizontal-flip [image-name] [dest-image-name]" + System.lineSeparator() +
                    "vertical-flip [image-name] [dest-image-name]" + System.lineSeparator() +
                    "blur [image-name] [dest-image-name]" + System.lineSeparator() +
                    "sharpen [image-name] [dest-image-name]" + System.lineSeparator() +
                    "sepia [image-name] [dest-image-name]" + System.lineSeparator() +
                    "brighten [increment] [image-name] [dest-image-name]" + System.lineSeparator() +
                    "downscale [percentage-scale] [image-name] [dest-image-name]" +
                    System.lineSeparator() +
                    "If you would like to partially manipulate an image please use: " +
                    "[command] [image-name] [mask-image] [dest-name]" + System.lineSeparator() +
                    "q or quit (quit the program) " + System.lineSeparator() +
                    "m or menu (prints the supported instructions menu) " + System.lineSeparator() +
                    "Type instruction: Type instruction: Type instruction: Type instruction: " +
                    "Thank you for using this program!",
            this.ap.toString());
  }

  @Test
  public void testRunProgramBlue() {
    this.rd = new StringReader("load res/grandma.ppm grandma \n" +
            "blue-component grandma redGrandma \n" + "q");
    this.ap = new StringBuilder();
    this.view = new ImageProcessingViewImpl(ap);
    this.controller = new ImageProcessingControllerImpl(rd, model, view);
    controller.runProgram();
    assertEquals("Welcome to the image processing program!" + System.lineSeparator() +
            "Supported user instructions are: " + System.lineSeparator() +
            "load [image-path] [image-name]" + System.lineSeparator() +
            "save [image-path] [image-name]" + System.lineSeparator() +
            "red-component [image-name] [dest-image-name]" + System.lineSeparator() +
            "green-component [image-name] [dest-image-name]" + System.lineSeparator() +
            "blue-component [image-name] [dest-image-name]" + System.lineSeparator() +
            "value [image-name] [dest-image-name]" + System.lineSeparator() +
            "luma [image-name] [dest-image-name]" + System.lineSeparator() +
            "intensity [image-name] [dest-image-name]" + System.lineSeparator() +
            "horizontal-flip [image-name] [dest-image-name]" + System.lineSeparator() +
            "vertical-flip [image-name] [dest-image-name]" + System.lineSeparator() +
            "blur [image-name] [dest-image-name]" + System.lineSeparator() +
            "sharpen [image-name] [dest-image-name]" + System.lineSeparator() +
            "sepia [image-name] [dest-image-name]" + System.lineSeparator() +
            "brighten [increment] [image-name] [dest-image-name]" + System.lineSeparator() +
            "downscale [percentage-scale] [image-name] [dest-image-name]" + System.lineSeparator() +
            "If you would like to partially manipulate an image please use: " +
            "[command] [image-name] [mask-image] [dest-name]" + System.lineSeparator() +
            "q or quit (quit the program) " + System.lineSeparator() +
            "m or menu (prints the supported instructions menu) " + System.lineSeparator() +
            "Type instruction: Type instruction: Type instruction: " +
            "Thank you for using this program!", this.ap.toString());
  }

  @Test
  public void testRunProgramRed() {
    this.rd = new StringReader("load res/grandma.ppm grandma \n" +
            "red-component grandma redGrandma \n" + "q");
    this.ap = new StringBuilder();
    this.view = new ImageProcessingViewImpl(ap);
    this.controller = new ImageProcessingControllerImpl(rd, model, view);
    controller.runProgram();
    assertEquals("Welcome to the image processing program!" + System.lineSeparator() +
            "Supported user instructions are: " + System.lineSeparator() +
            "load [image-path] [image-name]" + System.lineSeparator() +
            "save [image-path] [image-name]" + System.lineSeparator() +
            "red-component [image-name] [dest-image-name]" + System.lineSeparator() +
            "green-component [image-name] [dest-image-name]" + System.lineSeparator() +
            "blue-component [image-name] [dest-image-name]" + System.lineSeparator() +
            "value [image-name] [dest-image-name]" + System.lineSeparator() +
            "luma [image-name] [dest-image-name]" + System.lineSeparator() +
            "intensity [image-name] [dest-image-name]" + System.lineSeparator() +
            "horizontal-flip [image-name] [dest-image-name]" + System.lineSeparator() +
            "vertical-flip [image-name] [dest-image-name]" + System.lineSeparator() +
            "blur [image-name] [dest-image-name]" + System.lineSeparator() +
            "sharpen [image-name] [dest-image-name]" + System.lineSeparator() +
            "sepia [image-name] [dest-image-name]" + System.lineSeparator() +
            "brighten [increment] [image-name] [dest-image-name]" + System.lineSeparator() +
            "downscale [percentage-scale] [image-name] [dest-image-name]" + System.lineSeparator() +
            "If you would like to partially manipulate an image please use: " +
            "[command] [image-name] [mask-image] [dest-name]" + System.lineSeparator() +
            "q or quit (quit the program) " + System.lineSeparator() +
            "m or menu (prints the supported instructions menu) " + System.lineSeparator() +
            "Type instruction: Type instruction: Type instruction: " +
            "Thank you for using this program!", this.ap.toString());
  }

  @Test
  public void testRunProgramGreen() {
    this.rd = new StringReader("load res/grandma.ppm grandma \n" +
            "green-component grandma redGrandma \n" + "q");
    this.ap = new StringBuilder();
    this.view = new ImageProcessingViewImpl(ap);
    this.controller = new ImageProcessingControllerImpl(rd, model, view);
    controller.runProgram();
    assertEquals("Welcome to the image processing program!" + System.lineSeparator() +
            "Supported user instructions are: " + System.lineSeparator() +
            "load [image-path] [image-name]" + System.lineSeparator() +
            "save [image-path] [image-name]" + System.lineSeparator() +
            "red-component [image-name] [dest-image-name]" + System.lineSeparator() +
            "green-component [image-name] [dest-image-name]" + System.lineSeparator() +
            "blue-component [image-name] [dest-image-name]" + System.lineSeparator() +
            "value [image-name] [dest-image-name]" + System.lineSeparator() +
            "luma [image-name] [dest-image-name]" + System.lineSeparator() +
            "intensity [image-name] [dest-image-name]" + System.lineSeparator() +
            "horizontal-flip [image-name] [dest-image-name]" + System.lineSeparator() +
            "vertical-flip [image-name] [dest-image-name]" + System.lineSeparator() +
            "blur [image-name] [dest-image-name]" + System.lineSeparator() +
            "sharpen [image-name] [dest-image-name]" + System.lineSeparator() +
            "sepia [image-name] [dest-image-name]" + System.lineSeparator() +
            "brighten [increment] [image-name] [dest-image-name]" + System.lineSeparator() +
            "downscale [percentage-scale] [image-name] [dest-image-name]" + System.lineSeparator() +
            "If you would like to partially manipulate an image please use: " +
            "[command] [image-name] [mask-image] [dest-name]" + System.lineSeparator() +
            "q or quit (quit the program) " + System.lineSeparator() +
            "m or menu (prints the supported instructions menu) " + System.lineSeparator() +
            "Type instruction: Type instruction: Type instruction: " +
            "Thank you for using this program!", this.ap.toString());
  }

  @Test
  public void testRunProgramValue() {
    this.rd = new StringReader("load res/grandma.ppm grandma \n" +
            "value grandma redGrandma \n" + "q");
    this.ap = new StringBuilder();
    this.view = new ImageProcessingViewImpl(ap);
    this.controller = new ImageProcessingControllerImpl(rd, model, view);
    controller.runProgram();
    assertEquals("Welcome to the image processing program!" + System.lineSeparator() +
            "Supported user instructions are: " + System.lineSeparator() +
            "load [image-path] [image-name]" + System.lineSeparator() +
            "save [image-path] [image-name]" + System.lineSeparator() +
            "red-component [image-name] [dest-image-name]" + System.lineSeparator() +
            "green-component [image-name] [dest-image-name]" + System.lineSeparator() +
            "blue-component [image-name] [dest-image-name]" + System.lineSeparator() +
            "value [image-name] [dest-image-name]" + System.lineSeparator() +
            "luma [image-name] [dest-image-name]" + System.lineSeparator() +
            "intensity [image-name] [dest-image-name]" + System.lineSeparator() +
            "horizontal-flip [image-name] [dest-image-name]" + System.lineSeparator() +
            "vertical-flip [image-name] [dest-image-name]" + System.lineSeparator() +
            "blur [image-name] [dest-image-name]" + System.lineSeparator() +
            "sharpen [image-name] [dest-image-name]" + System.lineSeparator() +
            "sepia [image-name] [dest-image-name]" + System.lineSeparator() +
            "brighten [increment] [image-name] [dest-image-name]" + System.lineSeparator() +
            "downscale [percentage-scale] [image-name] [dest-image-name]" + System.lineSeparator() +
            "If you would like to partially manipulate an image please use: " +
            "[command] [image-name] [mask-image] [dest-name]" + System.lineSeparator() +
            "q or quit (quit the program) " + System.lineSeparator() +
            "m or menu (prints the supported instructions menu) " + System.lineSeparator() +
            "Type instruction: Type instruction: Type instruction: " +
            "Thank you for using this program!", this.ap.toString());
  }

  @Test
  public void testRunProgramIntensity() {
    this.rd = new StringReader("load res/grandma.ppm grandma \n" +
            "intensity grandma redGrandma \n" + "q");
    this.ap = new StringBuilder();
    this.view = new ImageProcessingViewImpl(ap);
    this.controller = new ImageProcessingControllerImpl(rd, model, view);
    controller.runProgram();
    assertEquals("Welcome to the image processing program!" + System.lineSeparator() +
            "Supported user instructions are: " + System.lineSeparator() +
            "load [image-path] [image-name]" + System.lineSeparator() +
            "save [image-path] [image-name]" + System.lineSeparator() +
            "red-component [image-name] [dest-image-name]" + System.lineSeparator() +
            "green-component [image-name] [dest-image-name]" + System.lineSeparator() +
            "blue-component [image-name] [dest-image-name]" + System.lineSeparator() +
            "value [image-name] [dest-image-name]" + System.lineSeparator() +
            "luma [image-name] [dest-image-name]" + System.lineSeparator() +
            "intensity [image-name] [dest-image-name]" + System.lineSeparator() +
            "horizontal-flip [image-name] [dest-image-name]" + System.lineSeparator() +
            "vertical-flip [image-name] [dest-image-name]" + System.lineSeparator() +
            "blur [image-name] [dest-image-name]" + System.lineSeparator() +
            "sharpen [image-name] [dest-image-name]" + System.lineSeparator() +
            "sepia [image-name] [dest-image-name]" + System.lineSeparator() +
            "brighten [increment] [image-name] [dest-image-name]" + System.lineSeparator() +
            "downscale [percentage-scale] [image-name] [dest-image-name]" + System.lineSeparator() +
            "If you would like to partially manipulate an image please use: " +
            "[command] [image-name] [mask-image] [dest-name]" + System.lineSeparator() +
            "q or quit (quit the program) " + System.lineSeparator() +
            "m or menu (prints the supported instructions menu) " + System.lineSeparator() +
            "Type instruction: Type instruction: Type instruction: " +
            "Thank you for using this program!", this.ap.toString());
  }

  @Test
  public void testRunProgramHorizontalFlip() {
    this.rd = new StringReader("load res/grandma.ppm grandma \n" +
            "horizontal-flip grandma redGrandma \n" + "q");
    this.ap = new StringBuilder();
    this.view = new ImageProcessingViewImpl(ap);
    this.controller = new ImageProcessingControllerImpl(rd, model, view);
    controller.runProgram();
    assertEquals("Welcome to the image processing program!" + System.lineSeparator() +
            "Supported user instructions are: " + System.lineSeparator() +
            "load [image-path] [image-name]" + System.lineSeparator() +
            "save [image-path] [image-name]" + System.lineSeparator() +
            "red-component [image-name] [dest-image-name]" + System.lineSeparator() +
            "green-component [image-name] [dest-image-name]" + System.lineSeparator() +
            "blue-component [image-name] [dest-image-name]" + System.lineSeparator() +
            "value [image-name] [dest-image-name]" + System.lineSeparator() +
            "luma [image-name] [dest-image-name]" + System.lineSeparator() +
            "intensity [image-name] [dest-image-name]" + System.lineSeparator() +
            "horizontal-flip [image-name] [dest-image-name]" + System.lineSeparator() +
            "vertical-flip [image-name] [dest-image-name]" + System.lineSeparator() +
            "blur [image-name] [dest-image-name]" + System.lineSeparator() +
            "sharpen [image-name] [dest-image-name]" + System.lineSeparator() +
            "sepia [image-name] [dest-image-name]" + System.lineSeparator() +
            "brighten [increment] [image-name] [dest-image-name]" + System.lineSeparator() +
            "downscale [percentage-scale] [image-name] [dest-image-name]" + System.lineSeparator() +
            "If you would like to partially manipulate an image please use: " +
            "[command] [image-name] [mask-image] [dest-name]" + System.lineSeparator() +
            "q or quit (quit the program) " + System.lineSeparator() +
            "m or menu (prints the supported instructions menu) " + System.lineSeparator() +
            "Type instruction: Type instruction: Type instruction: " +
            "Thank you for using this program!", this.ap.toString());
  }

  @Test
  public void testRunProgramVerticalFlip() {
    this.rd = new StringReader("load res/grandma.ppm grandma \n" +
            "vertical-flip grandma redGrandma \n" + "q");
    this.ap = new StringBuilder();
    this.view = new ImageProcessingViewImpl(ap);
    this.controller = new ImageProcessingControllerImpl(rd, model, view);
    controller.runProgram();
    assertEquals("Welcome to the image processing program!" + System.lineSeparator() +
            "Supported user instructions are: " + System.lineSeparator() +
            "load [image-path] [image-name]" + System.lineSeparator() +
            "save [image-path] [image-name]" + System.lineSeparator() +
            "red-component [image-name] [dest-image-name]" + System.lineSeparator() +
            "green-component [image-name] [dest-image-name]" + System.lineSeparator() +
            "blue-component [image-name] [dest-image-name]" + System.lineSeparator() +
            "value [image-name] [dest-image-name]" + System.lineSeparator() +
            "luma [image-name] [dest-image-name]" + System.lineSeparator() +
            "intensity [image-name] [dest-image-name]" + System.lineSeparator() +
            "horizontal-flip [image-name] [dest-image-name]" + System.lineSeparator() +
            "vertical-flip [image-name] [dest-image-name]" + System.lineSeparator() +
            "blur [image-name] [dest-image-name]" + System.lineSeparator() +
            "sharpen [image-name] [dest-image-name]" + System.lineSeparator() +
            "sepia [image-name] [dest-image-name]" + System.lineSeparator() +
            "brighten [increment] [image-name] [dest-image-name]" + System.lineSeparator() +
            "downscale [percentage-scale] [image-name] [dest-image-name]" + System.lineSeparator() +
            "If you would like to partially manipulate an image please use: " +
            "[command] [image-name] [mask-image] [dest-name]" + System.lineSeparator() +
            "q or quit (quit the program) " + System.lineSeparator() +
            "m or menu (prints the supported instructions menu) " + System.lineSeparator() +
            "Type instruction: Type instruction: Type instruction: " +
            "Thank you for using this program!", this.ap.toString());
  }

  @Test
  public void testRunProgramBrighten() {
    this.rd = new StringReader("load res/grandma.ppm grandma \n" +
            "brighten 10 grandma redGrandma \n" + "q");
    this.ap = new StringBuilder();
    this.view = new ImageProcessingViewImpl(ap);
    this.controller = new ImageProcessingControllerImpl(rd, model, view);
    controller.runProgram();
    assertEquals("Welcome to the image processing program!" + System.lineSeparator() +
            "Supported user instructions are: " + System.lineSeparator() +
            "load [image-path] [image-name]" + System.lineSeparator() +
            "save [image-path] [image-name]" + System.lineSeparator() +
            "red-component [image-name] [dest-image-name]" + System.lineSeparator() +
            "green-component [image-name] [dest-image-name]" + System.lineSeparator() +
            "blue-component [image-name] [dest-image-name]" + System.lineSeparator() +
            "value [image-name] [dest-image-name]" + System.lineSeparator() +
            "luma [image-name] [dest-image-name]" + System.lineSeparator() +
            "intensity [image-name] [dest-image-name]" + System.lineSeparator() +
            "horizontal-flip [image-name] [dest-image-name]" + System.lineSeparator() +
            "vertical-flip [image-name] [dest-image-name]" + System.lineSeparator() +
            "blur [image-name] [dest-image-name]" + System.lineSeparator() +
            "sharpen [image-name] [dest-image-name]" + System.lineSeparator() +
            "sepia [image-name] [dest-image-name]" + System.lineSeparator() +
            "brighten [increment] [image-name] [dest-image-name]" + System.lineSeparator() +
            "downscale [percentage-scale] [image-name] [dest-image-name]" + System.lineSeparator() +
            "If you would like to partially manipulate an image please use: " +
            "[command] [image-name] [mask-image] [dest-name]" + System.lineSeparator() +
            "q or quit (quit the program) " + System.lineSeparator() +
            "m or menu (prints the supported instructions menu) " + System.lineSeparator() +
            "Type instruction: Type instruction: Type instruction: " +
            "Thank you for using this program!", this.ap.toString());
  }

  @Test
  public void testProgramBlur() {
    this.rd = new StringReader("load res/grandma.ppm grandma \n" +
            "blur grandma redGrandma \n" + "q");
    this.ap = new StringBuilder();
    this.view = new ImageProcessingViewImpl(ap);
    this.controller = new ImageProcessingControllerImpl(rd, model, view);
    controller.runProgram();
    assertEquals("Welcome to the image processing program!" + System.lineSeparator() +
            "Supported user instructions are: " + System.lineSeparator() +
            "load [image-path] [image-name]" + System.lineSeparator() +
            "save [image-path] [image-name]" + System.lineSeparator() +
            "red-component [image-name] [dest-image-name]" + System.lineSeparator() +
            "green-component [image-name] [dest-image-name]" + System.lineSeparator() +
            "blue-component [image-name] [dest-image-name]" + System.lineSeparator() +
            "value [image-name] [dest-image-name]" + System.lineSeparator() +
            "luma [image-name] [dest-image-name]" + System.lineSeparator() +
            "intensity [image-name] [dest-image-name]" + System.lineSeparator() +
            "horizontal-flip [image-name] [dest-image-name]" + System.lineSeparator() +
            "vertical-flip [image-name] [dest-image-name]" + System.lineSeparator() +
            "blur [image-name] [dest-image-name]" + System.lineSeparator() +
            "sharpen [image-name] [dest-image-name]" + System.lineSeparator() +
            "sepia [image-name] [dest-image-name]" + System.lineSeparator() +
            "brighten [increment] [image-name] [dest-image-name]" + System.lineSeparator() +
            "downscale [percentage-scale] [image-name] [dest-image-name]" + System.lineSeparator() +
            "If you would like to partially manipulate an image please use: " +
            "[command] [image-name] [mask-image] [dest-name]" + System.lineSeparator() +
            "q or quit (quit the program) " + System.lineSeparator() +
            "m or menu (prints the supported instructions menu) " + System.lineSeparator() +
            "Type instruction: Type instruction: Type instruction: " +
            "Thank you for using this program!", this.ap.toString());
  }

  @Test
  public void testProgramSharpen() {
    this.rd = new StringReader("load res/grandma.ppm grandma \n" +
            "sharpen grandma redGrandma \n" + "q");
    this.ap = new StringBuilder();
    this.view = new ImageProcessingViewImpl(ap);
    this.controller = new ImageProcessingControllerImpl(rd, model, view);
    controller.runProgram();
    assertEquals("Welcome to the image processing program!" + System.lineSeparator() +
            "Supported user instructions are: " + System.lineSeparator() +
            "load [image-path] [image-name]" + System.lineSeparator() +
            "save [image-path] [image-name]" + System.lineSeparator() +
            "red-component [image-name] [dest-image-name]" + System.lineSeparator() +
            "green-component [image-name] [dest-image-name]" + System.lineSeparator() +
            "blue-component [image-name] [dest-image-name]" + System.lineSeparator() +
            "value [image-name] [dest-image-name]" + System.lineSeparator() +
            "luma [image-name] [dest-image-name]" + System.lineSeparator() +
            "intensity [image-name] [dest-image-name]" + System.lineSeparator() +
            "horizontal-flip [image-name] [dest-image-name]" + System.lineSeparator() +
            "vertical-flip [image-name] [dest-image-name]" + System.lineSeparator() +
            "blur [image-name] [dest-image-name]" + System.lineSeparator() +
            "sharpen [image-name] [dest-image-name]" + System.lineSeparator() +
            "sepia [image-name] [dest-image-name]" + System.lineSeparator() +
            "brighten [increment] [image-name] [dest-image-name]" + System.lineSeparator() +
            "downscale [percentage-scale] [image-name] [dest-image-name]" + System.lineSeparator() +
            "If you would like to partially manipulate an image please use: " +
            "[command] [image-name] [mask-image] [dest-name]" + System.lineSeparator() +
            "q or quit (quit the program) " + System.lineSeparator() +
            "m or menu (prints the supported instructions menu) " + System.lineSeparator() +
            "Type instruction: Type instruction: Type instruction: " +
            "Thank you for using this program!", this.ap.toString());
  }

  @Test
  public void testProgramSepia() {
    this.rd = new StringReader("load res/grandma.ppm grandma \n" +
            "sepia grandma redGrandma \n" + "q");
    this.ap = new StringBuilder();
    this.view = new ImageProcessingViewImpl(ap);
    this.controller = new ImageProcessingControllerImpl(rd, model, view);
    controller.runProgram();
    assertEquals("Welcome to the image processing program!" + System.lineSeparator() +
            "Supported user instructions are: " + System.lineSeparator() +
            "load [image-path] [image-name]" + System.lineSeparator() +
            "save [image-path] [image-name]" + System.lineSeparator() +
            "red-component [image-name] [dest-image-name]" + System.lineSeparator() +
            "green-component [image-name] [dest-image-name]" + System.lineSeparator() +
            "blue-component [image-name] [dest-image-name]" + System.lineSeparator() +
            "value [image-name] [dest-image-name]" + System.lineSeparator() +
            "luma [image-name] [dest-image-name]" + System.lineSeparator() +
            "intensity [image-name] [dest-image-name]" + System.lineSeparator() +
            "horizontal-flip [image-name] [dest-image-name]" + System.lineSeparator() +
            "vertical-flip [image-name] [dest-image-name]" + System.lineSeparator() +
            "blur [image-name] [dest-image-name]" + System.lineSeparator() +
            "sharpen [image-name] [dest-image-name]" + System.lineSeparator() +
            "sepia [image-name] [dest-image-name]" + System.lineSeparator() +
            "brighten [increment] [image-name] [dest-image-name]" + System.lineSeparator() +
            "downscale [percentage-scale] [image-name] [dest-image-name]" + System.lineSeparator() +
            "If you would like to partially manipulate an image please use: " +
            "[command] [image-name] [mask-image] [dest-name]" + System.lineSeparator() +
            "q or quit (quit the program) " + System.lineSeparator() +
            "m or menu (prints the supported instructions menu) " + System.lineSeparator() +
            "Type instruction: Type instruction: Type instruction: " +
            "Thank you for using this program!", this.ap.toString());
  }

  @Test
  public void testLoadPng() {
    this.rd = new StringReader("load res/grandma.png granny \n" + "q");
    this.ap = new StringBuilder();
    this.view = new ImageProcessingViewImpl(ap);
    this.controller = new ImageProcessingControllerImpl(rd, model, view);
    controller.runProgram();
    assertEquals("Welcome to the image processing program!" + System.lineSeparator() +
            "Supported user instructions are: " + System.lineSeparator() +
            "load [image-path] [image-name]" + System.lineSeparator() +
            "save [image-path] [image-name]" + System.lineSeparator() +
            "red-component [image-name] [dest-image-name]" + System.lineSeparator() +
            "green-component [image-name] [dest-image-name]" + System.lineSeparator() +
            "blue-component [image-name] [dest-image-name]" + System.lineSeparator() +
            "value [image-name] [dest-image-name]" + System.lineSeparator() +
            "luma [image-name] [dest-image-name]" + System.lineSeparator() +
            "intensity [image-name] [dest-image-name]" + System.lineSeparator() +
            "horizontal-flip [image-name] [dest-image-name]" + System.lineSeparator() +
            "vertical-flip [image-name] [dest-image-name]" + System.lineSeparator() +
            "blur [image-name] [dest-image-name]" + System.lineSeparator() +
            "sharpen [image-name] [dest-image-name]" + System.lineSeparator() +
            "sepia [image-name] [dest-image-name]" + System.lineSeparator() +
            "brighten [increment] [image-name] [dest-image-name]" + System.lineSeparator() +
            "downscale [percentage-scale] [image-name] [dest-image-name]" + System.lineSeparator() +
            "If you would like to partially manipulate an image please use: " +
            "[command] [image-name] [mask-image] [dest-name]" + System.lineSeparator() +
            "q or quit (quit the program) " + System.lineSeparator() +
            "m or menu (prints the supported instructions menu) " + System.lineSeparator() +
            "Type instruction: Type instruction: " +
            "Thank you for using this program!", this.ap.toString());
  }

  @Test
  public void testLoadJpg() {
    this.rd = new StringReader("load res/grandma.jpg granny \n" + "q");
    this.ap = new StringBuilder();
    this.view = new ImageProcessingViewImpl(ap);
    this.controller = new ImageProcessingControllerImpl(rd, model, view);
    controller.runProgram();
    assertEquals("Welcome to the image processing program!" + System.lineSeparator() +
            "Supported user instructions are: " + System.lineSeparator() +
            "load [image-path] [image-name]" + System.lineSeparator() +
            "save [image-path] [image-name]" + System.lineSeparator() +
            "red-component [image-name] [dest-image-name]" + System.lineSeparator() +
            "green-component [image-name] [dest-image-name]" + System.lineSeparator() +
            "blue-component [image-name] [dest-image-name]" + System.lineSeparator() +
            "value [image-name] [dest-image-name]" + System.lineSeparator() +
            "luma [image-name] [dest-image-name]" + System.lineSeparator() +
            "intensity [image-name] [dest-image-name]" + System.lineSeparator() +
            "horizontal-flip [image-name] [dest-image-name]" + System.lineSeparator() +
            "vertical-flip [image-name] [dest-image-name]" + System.lineSeparator() +
            "blur [image-name] [dest-image-name]" + System.lineSeparator() +
            "sharpen [image-name] [dest-image-name]" + System.lineSeparator() +
            "sepia [image-name] [dest-image-name]" + System.lineSeparator() +
            "brighten [increment] [image-name] [dest-image-name]" + System.lineSeparator() +
            "downscale [percentage-scale] [image-name] [dest-image-name]" + System.lineSeparator() +
            "If you would like to partially manipulate an image please use: " +
            "[command] [image-name] [mask-image] [dest-name]" + System.lineSeparator() +
            "q or quit (quit the program) " + System.lineSeparator() +
            "m or menu (prints the supported instructions menu) " + System.lineSeparator() +
            "Type instruction: Type instruction: " +
            "Thank you for using this program!", this.ap.toString());
  }

  @Test
  public void testLoadBmp() {
    this.rd = new StringReader("load res/grandma.bmp granny \n" + "q");
    this.ap = new StringBuilder();
    this.view = new ImageProcessingViewImpl(ap);
    this.controller = new ImageProcessingControllerImpl(rd, model, view);
    controller.runProgram();
    assertEquals("Welcome to the image processing program!" + System.lineSeparator() +
            "Supported user instructions are: " + System.lineSeparator() +
            "load [image-path] [image-name]" + System.lineSeparator() +
            "save [image-path] [image-name]" + System.lineSeparator() +
            "red-component [image-name] [dest-image-name]" + System.lineSeparator() +
            "green-component [image-name] [dest-image-name]" + System.lineSeparator() +
            "blue-component [image-name] [dest-image-name]" + System.lineSeparator() +
            "value [image-name] [dest-image-name]" + System.lineSeparator() +
            "luma [image-name] [dest-image-name]" + System.lineSeparator() +
            "intensity [image-name] [dest-image-name]" + System.lineSeparator() +
            "horizontal-flip [image-name] [dest-image-name]" + System.lineSeparator() +
            "vertical-flip [image-name] [dest-image-name]" + System.lineSeparator() +
            "blur [image-name] [dest-image-name]" + System.lineSeparator() +
            "sharpen [image-name] [dest-image-name]" + System.lineSeparator() +
            "sepia [image-name] [dest-image-name]" + System.lineSeparator() +
            "brighten [increment] [image-name] [dest-image-name]" + System.lineSeparator() +
            "downscale [percentage-scale] [image-name] [dest-image-name]" + System.lineSeparator() +
            "If you would like to partially manipulate an image please use: " +
            "[command] [image-name] [mask-image] [dest-name]" + System.lineSeparator() +
            "q or quit (quit the program) " + System.lineSeparator() +
            "m or menu (prints the supported instructions menu) " + System.lineSeparator() +
            "Type instruction: Type instruction: " +
            "Thank you for using this program!", this.ap.toString());
  }

  @Test
  public void testRunProgramSaveJPG() {
    this.rd = new StringReader("load res/grandma.ppm grandma \n" +
            "red-component grandma redGrandma \n" +
            "save res/grandma.jpg redGrandma \n"
            + "q");
    this.ap = new StringBuilder();
    this.view = new ImageProcessingViewImpl(ap);
    this.controller = new ImageProcessingControllerImpl(rd, model, view);
    controller.runProgram();
    assertEquals("Welcome to the image processing program!" + System.lineSeparator() +
                    "Supported user instructions are: " + System.lineSeparator() +
                    "load [image-path] [image-name]" + System.lineSeparator() +
                    "save [image-path] [image-name]" + System.lineSeparator() +
                    "red-component [image-name] [dest-image-name]" + System.lineSeparator() +
                    "green-component [image-name] [dest-image-name]" + System.lineSeparator() +
                    "blue-component [image-name] [dest-image-name]" + System.lineSeparator() +
                    "value [image-name] [dest-image-name]" + System.lineSeparator() +
                    "luma [image-name] [dest-image-name]" + System.lineSeparator() +
                    "intensity [image-name] [dest-image-name]" + System.lineSeparator() +
                    "horizontal-flip [image-name] [dest-image-name]" + System.lineSeparator() +
                    "vertical-flip [image-name] [dest-image-name]" + System.lineSeparator() +
                    "blur [image-name] [dest-image-name]" + System.lineSeparator() +
                    "sharpen [image-name] [dest-image-name]" + System.lineSeparator() +
                    "sepia [image-name] [dest-image-name]" + System.lineSeparator() +
                    "brighten [increment] [image-name] [dest-image-name]" + System.lineSeparator() +
                    "downscale [percentage-scale] [image-name] [dest-image-name]" +
                    System.lineSeparator() +
                    "If you would like to partially manipulate an image please use: " +
                    "[command] [image-name] [mask-image] [dest-name]" + System.lineSeparator() +
                    "q or quit (quit the program) " + System.lineSeparator() +
                    "m or menu (prints the supported instructions menu) " + System.lineSeparator() +
                    "Type instruction: Type instruction: Type instruction: Type instruction: " +
                    "Thank you for using this program!",
            this.ap.toString());
  }

  @Test
  public void testRunProgramSavePNG() {
    this.rd = new StringReader("load res/grandma.ppm grandma \n" +
            "red-component grandma redGrandma \n" +
            "save res/grandma.png redGrandma \n"
            + "q");
    this.ap = new StringBuilder();
    this.view = new ImageProcessingViewImpl(ap);
    this.controller = new ImageProcessingControllerImpl(rd, model, view);
    controller.runProgram();
    assertEquals("Welcome to the image processing program!" + System.lineSeparator() +
                    "Supported user instructions are: " + System.lineSeparator() +
                    "load [image-path] [image-name]" + System.lineSeparator() +
                    "save [image-path] [image-name]" + System.lineSeparator() +
                    "red-component [image-name] [dest-image-name]" + System.lineSeparator() +
                    "green-component [image-name] [dest-image-name]" + System.lineSeparator() +
                    "blue-component [image-name] [dest-image-name]" + System.lineSeparator() +
                    "value [image-name] [dest-image-name]" + System.lineSeparator() +
                    "luma [image-name] [dest-image-name]" + System.lineSeparator() +
                    "intensity [image-name] [dest-image-name]" + System.lineSeparator() +
                    "horizontal-flip [image-name] [dest-image-name]" + System.lineSeparator() +
                    "vertical-flip [image-name] [dest-image-name]" + System.lineSeparator() +
                    "blur [image-name] [dest-image-name]" + System.lineSeparator() +
                    "sharpen [image-name] [dest-image-name]" + System.lineSeparator() +
                    "sepia [image-name] [dest-image-name]" + System.lineSeparator() +
                    "brighten [increment] [image-name] [dest-image-name]" + System.lineSeparator() +
                    "downscale [percentage-scale] [image-name] [dest-image-name]" +
                    System.lineSeparator() +
                    "If you would like to partially manipulate an image please use: " +
                    "[command] [image-name] [mask-image] [dest-name]" + System.lineSeparator() +
                    "q or quit (quit the program) " + System.lineSeparator() +
                    "m or menu (prints the supported instructions menu) " + System.lineSeparator() +
                    "Type instruction: Type instruction: Type instruction: Type instruction: " +
                    "Thank you for using this program!",
            this.ap.toString());
  }

  @Test
  public void testRunProgramSaveBMP() {
    this.rd = new StringReader("load res/grandma.ppm grandma \n" +
            "red-component grandma redGrandma \n" +
            "save res/grandma.bmp redGrandma \n"
            + "q");
    this.ap = new StringBuilder();
    this.view = new ImageProcessingViewImpl(ap);
    this.controller = new ImageProcessingControllerImpl(rd, model, view);
    controller.runProgram();
    assertEquals("Welcome to the image processing program!" + System.lineSeparator() +
                    "Supported user instructions are: " + System.lineSeparator() +
                    "load [image-path] [image-name]" + System.lineSeparator() +
                    "save [image-path] [image-name]" + System.lineSeparator() +
                    "red-component [image-name] [dest-image-name]" + System.lineSeparator() +
                    "green-component [image-name] [dest-image-name]" + System.lineSeparator() +
                    "blue-component [image-name] [dest-image-name]" + System.lineSeparator() +
                    "value [image-name] [dest-image-name]" + System.lineSeparator() +
                    "luma [image-name] [dest-image-name]" + System.lineSeparator() +
                    "intensity [image-name] [dest-image-name]" + System.lineSeparator() +
                    "horizontal-flip [image-name] [dest-image-name]" + System.lineSeparator() +
                    "vertical-flip [image-name] [dest-image-name]" + System.lineSeparator() +
                    "blur [image-name] [dest-image-name]" + System.lineSeparator() +
                    "sharpen [image-name] [dest-image-name]" + System.lineSeparator() +
                    "sepia [image-name] [dest-image-name]" + System.lineSeparator() +
                    "brighten [increment] [image-name] [dest-image-name]" + System.lineSeparator() +
                    "downscale [percentage-scale] [image-name] [dest-image-name]" +
                    System.lineSeparator() +
                    "If you would like to partially manipulate an image please use: " +
                    "[command] [image-name] [mask-image] [dest-name]" + System.lineSeparator() +
                    "q or quit (quit the program) " + System.lineSeparator() +
                    "m or menu (prints the supported instructions menu) " + System.lineSeparator() +
                    "Type instruction: Type instruction: Type instruction: Type instruction: " +
                    "Thank you for using this program!",
            this.ap.toString());
  }

  @Test
  public void testRunProgramDownsize() {
    this.rd = new StringReader("load res/grandma.ppm grandma \n" +
            "downscale 50 grandma downsize \n" +
            "save res/downsize.ppm downsize \n"
            + "q");
    this.ap = new StringBuilder();
    this.view = new ImageProcessingViewImpl(ap);
    this.controller = new ImageProcessingControllerImpl(rd, model, view);
    controller.runProgram();
    assertEquals("Welcome to the image processing program!" + System.lineSeparator() +
                    "Supported user instructions are: " + System.lineSeparator() +
                    "load [image-path] [image-name]" + System.lineSeparator() +
                    "save [image-path] [image-name]" + System.lineSeparator() +
                    "red-component [image-name] [dest-image-name]" + System.lineSeparator() +
                    "green-component [image-name] [dest-image-name]" + System.lineSeparator() +
                    "blue-component [image-name] [dest-image-name]" + System.lineSeparator() +
                    "value [image-name] [dest-image-name]" + System.lineSeparator() +
                    "luma [image-name] [dest-image-name]" + System.lineSeparator() +
                    "intensity [image-name] [dest-image-name]" + System.lineSeparator() +
                    "horizontal-flip [image-name] [dest-image-name]" + System.lineSeparator() +
                    "vertical-flip [image-name] [dest-image-name]" + System.lineSeparator() +
                    "blur [image-name] [dest-image-name]" + System.lineSeparator() +
                    "sharpen [image-name] [dest-image-name]" + System.lineSeparator() +
                    "sepia [image-name] [dest-image-name]" + System.lineSeparator() +
                    "brighten [increment] [image-name] [dest-image-name]" + System.lineSeparator() +
                    "downscale [percentage-scale] [image-name] [dest-image-name]" +
                    System.lineSeparator() +
                    "If you would like to partially manipulate an image please use: " +
                    "[command] [image-name] [mask-image] [dest-name]" + System.lineSeparator() +
                    "q or quit (quit the program) " + System.lineSeparator() +
                    "m or menu (prints the supported instructions menu) " + System.lineSeparator() +
                    "Type instruction: Type instruction: Type instruction: Type instruction: " +
                    "Thank you for using this program!",
            this.ap.toString());
  }
}
