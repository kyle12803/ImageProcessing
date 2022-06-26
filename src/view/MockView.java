package view;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import image.Image;
import image.ImageImpl;
import image.Pixel;

import static java.util.Arrays.asList;

/**
 * This represents the mock view used in testing.
 */
public class MockView implements IView {
  private final Appendable log;

  /**
   * This is the Mock constructor.
   * @param log - log used to append things.
   */
  public MockView(Appendable log) {
    this.log = log;
  }

  /**
   * Calls made to check the name.
   *
   * @return a string which means image name was called.
   */
  public String getImageName() {
    try {
      log.append("getImageName called: ");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return "imageName";
  }

  /**
   * calls made to get path of an image.
   *
   * @return a string which manes path was called.
   */
  public String getImagePath() {
    try {
      log.append("getImagePath called: ");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return "imagePath";
  }


  @Override
  public void makeVisible(ActionListener actionListener) {
    Pixel exampleTest1 = new Pixel(50, 60, 70);
    Pixel exampleTest2 = new Pixel(0, 0, 0);
    Pixel exampleTest3 = new Pixel(60, 60, 60);
    Pixel exampleTest4 = new Pixel(255, 255, 255);
    Pixel exampleTest5 = new Pixel(100, 25, 25);
    Pixel exampleTest6 = new Pixel(55, 25, 55);


    List<List<Pixel>> lop1 = new ArrayList<>(asList(
            new ArrayList<>(asList(exampleTest1, exampleTest2, exampleTest3)),
            new ArrayList<>(asList(exampleTest4, exampleTest5, exampleTest6))));
    Image image1 = new ImageImpl(255, 3, 2, lop1);
    switch (actionListener.toString()) {
      case "load":
        this.getImagePath();
        this.getImageName();
        this.renderImage(image1);
        this.renderHistogram(image1);
        break;
      case "save":
        this.getImagePath();
        this.getImageName();
        this.renderImage(image1);
        this.renderHistogram(image1);
        break;
      case "comboBoxChanged":
        this.getImagePath();
        this.getImageName();
        this.renderImage(image1);
        this.renderHistogram(image1);
        break;
      default:
    }
  }


  @Override
  public void renderHistogram(Image image) {
    try {
      log.append("Histogram made");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void renderImage(Image image) {
    try {
      log.append("Image added");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
