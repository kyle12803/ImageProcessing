package command;

import image.Image;
import model.ImageProcessingModel;

/**
 * This interface represents the command for a macro.
 */
public interface CommandMacro {
  /**
   * This method takes in an image and runs a command on it.
   *
   * @param image This is the image passed in.
   */
  void command(Image image);
}
