package controller;

/**
 * This class represents the controller of an interactive image processing application.
 * This controller offers a simple text interface in which the user can type instructions
 * to convert an image to their choosing.
 *
 * <p>This controller works with any Readable to read its inputs and
 * any Appendable to transmit output. This controller directly uses
 * the Appendable object (i.e. there is no official "view")
 */
public interface ImageProcessingController {
  /**
   * Runs the image processing program.
   *
   * @throws IllegalStateException if the controller is unable to successfully read input
   *                               or transmit output
   */
  void runProgram() throws IllegalStateException;
}
