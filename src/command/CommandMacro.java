package command;

import image.Image;
import model.ImageProcessingModel;

/**
 * This interface represents the command for a macro.
 */
public interface CommandMacro {
  /**
   * This method runs a specific command on an image.
   */
  void command();
}
