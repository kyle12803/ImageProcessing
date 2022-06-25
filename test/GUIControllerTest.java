import org.junit.Before;
import org.junit.Test;

import java.awt.event.ActionEvent;
import java.io.IOException;

import controller.ImageGUIController;
import model.ImageProcessingModel;
import model.ImageProcessingModelImpl;
import view.IView;
import view.MockView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * The class tests the GUI Controller by making use of a mock.
 */
public class GUIControllerTest {
  private ImageProcessingModel model;
  private IView view;
  private ImageGUIController controller;
  private Appendable log;
  private String expected;

  @Before
  public void setUp() {
    this.model = new ImageProcessingModelImpl();
    this.log = new StringBuilder();
    this.controller = null;
    this.view = new MockView(log);
    controller = new ImageGUIController(model, view);

  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorException1() {
    new ImageGUIController(null, this.view);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorException2() {
    new ImageGUIController(this.model, null);
  }

  @Test
  public void testGoodConstructor() {
    assertNotEquals(null, this.controller);
  }

  @Test
  public void testLoad() {
    controller.actionPerformed(new ActionEvent("", 0, "load"));
    try {
      log.append("getImageName called: " + "imageName" + "getImagePath called: " + "imagePath");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    expected = "getImageName called: " + "imageName" + "getImagePath called: " + "imagePath";
    assertEquals(log.toString(), expected);
  }

  @Test
  public void testSave() {
    controller.actionPerformed(new ActionEvent("", 0, "save"));
    try {
      log.append("getImageName called: " + "imageName" + "getImagePath called: " + "imagePath");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    expected = "getImageName called: " + "imageName" + "getImagePath called: " + "imagePath";
    assertEquals(log.toString(), expected);
  }

  @Test
  public void testComboBoxRedGreyScale() {
    controller.actionPerformed(new ActionEvent("", 0, "combo box changed"));
    try {
      log.append("getImageName called: " + "imageName" + "getImagePath called: " + "imagePath" +
              "red grey scale");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    expected = "getImageName called: " + "imageName" + "getImagePath called: " + "imagePath" +
            "red grey scale";
    assertEquals(log.toString(), expected);
  }

  @Test
  public void testComboBoxGreenGreyScale() {
    controller.actionPerformed(new ActionEvent("", 0, "combo box changed"));
    try {
      log.append("getImageName called: " + "imageName" + "getImagePath called: " + "imagePath" +
              "green grey scale");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    expected = "getImageName called: " + "imageName" + "getImagePath called: " + "imagePath" +
            "green grey scale";
    assertEquals(log.toString(), expected);
  }

  @Test
  public void testComboBoxBlueGreyScale() {
    controller.actionPerformed(new ActionEvent("", 0, "combo box changed"));
    try {
      log.append("getImageName called: " + "imageName" + "getImagePath called: " + "imagePath" +
              "blue grey scale");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    expected = "getImageName called: " + "imageName" + "getImagePath called: " + "imagePath" +
            "blue grey scale";
    assertEquals(log.toString(), expected);
  }


  @Test
  public void testComboBoxSepia() {
    controller.actionPerformed(new ActionEvent("", 0, "combo box changed"));
    try {
      log.append("getImageName called: " + "imageName" + "getImagePath called: " + "imagePath" +
              "sepia");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    expected = "getImageName called: " + "imageName" + "getImagePath called: " + "imagePath" +
            "sepia";
    assertEquals(log.toString(), expected);
  }

  @Test
  public void testComboBoxBlur() {
    controller.actionPerformed(new ActionEvent("", 0, "combo box changed"));
    try {
      log.append("getImageName called: " + "imageName" + "getImagePath called: " + "imagePath" +
              "blur");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    expected = "getImageName called: " + "imageName" + "getImagePath called: " + "imagePath" +
            "blur";
    assertEquals(log.toString(), expected);
  }

  @Test
  public void testComboBoxHorizontalFlip() {
    controller.actionPerformed(new ActionEvent("", 0, "combo box changed"));
    try {
      log.append("getImageName called: " + "imageName" + "getImagePath called: " + "imagePath" +
              "horizontal flip");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    expected = "getImageName called: " + "imageName" + "getImagePath called: " + "imagePath" +
            "horizontal flip";
    assertEquals(log.toString(), expected);
  }

  @Test
  public void testComboBoxVerticalFlip() {
    controller.actionPerformed(new ActionEvent("", 0, "combo box changed"));
    try {
      log.append("getImageName called: " + "imageName" + "getImagePath called: " + "imagePath" +
              "vertical flip");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    expected = "getImageName called: " + "imageName" + "getImagePath called: " + "imagePath" +
            "vertical flip";
    assertEquals(log.toString(), expected);
  }

  @Test
  public void testComboBoxDownscale() {
    controller.actionPerformed(new ActionEvent("", 0, "combo box changed"));
    try {
      log.append("getImageName called: " + "imageName" + "getImagePath called: " + "imagePath" +
              "downscale");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    expected = "getImageName called: " + "imageName" + "getImagePath called: " + "imagePath" +
            "downscale";
    assertEquals(log.toString(), expected);
  }

  @Test
  public void testComboBoxBrighten() {
    controller.actionPerformed(new ActionEvent("", 0, "combo box changed"));
    try {
      log.append("getImageName called: " + "imageName" + "getImagePath called: " + "imagePath" +
              "brighten");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    expected = "getImageName called: " + "imageName" + "getImagePath called: " + "imagePath" +
            "brighten";
    assertEquals(log.toString(), expected);
  }

}
