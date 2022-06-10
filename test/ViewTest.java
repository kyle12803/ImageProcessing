import org.junit.Test;

import java.io.IOException;

import view.ImageProcessingView;
import view.ImageProcessingViewImpl;

import static org.junit.Assert.assertEquals;

/**
 * Examples class for image processing view used for testing purposes.
 */
public class ViewTest {
  Appendable ap = new StringBuilder();
  ImageProcessingView view = new ImageProcessingViewImpl(ap);

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorException() {
    new ImageProcessingViewImpl(null);
  }

  @Test
  public void testRenderMessage() {
    try {
      this.view.renderMessage("New message.\n");
    } catch (IOException e) {
      throw new IllegalStateException();
    }
    assertEquals("New message.\n", ap.toString());
    try {
      this.view.renderMessage("Next message lol.\n");
    } catch (IOException e) {
      throw new IllegalStateException();
    }
    assertEquals("New message.\nNext message lol.\n", ap.toString());
  }
}
