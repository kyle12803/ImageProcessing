package view;

import java.io.IOException;

/**
 * This interface represents the image's view where it will work with the controller and its inputs.
 */
public interface ImageProcessingView {
  /**
   * Render message renders an input message and works with the controller.
   *
   * @param msg message input into the function to work with the controller.
   * @throws IOException - thrown if not readable or null.
   */
  void renderMessage(String msg) throws IOException;
}
