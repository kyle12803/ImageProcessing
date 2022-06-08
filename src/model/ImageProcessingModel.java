package model;

import command.CommandMacro;
import image.Image;

/**
 * This interface represents the operations offered by the image processing
 * model. One object of the model is one image processor.
 */
public interface ImageProcessingModel {
  /**
   * Reads a ppm image from file and creates an image object representing it.
   *
   * @param filename the name of the ppm file
   * @return a new image object
   * @throws IllegalArgumentException if the file name does not exist
   */
  Image loadImage(String filename) throws IllegalArgumentException;

  /**
   * Adds the given image to the map of images with the key as the given string value.
   *
   * @param img  the image passed in
   * @param name the name we would like to give to the image
   * @throws IllegalArgumentException if the image or name is null
   */
  void addImage(Image img, String name) throws IllegalArgumentException;

  /**
   * Retrieves the image at the given key of the map.
   *
   * @param key the name of the image
   * @return the image at the given key
   * @throws IllegalArgumentException if the key is null
   */
  Image getImage(String key) throws IllegalArgumentException;

  /**
   * This is the method where we will call the macro on the model.
   *
   * @param commandMacro the command passed in which we will execute on the model.
   * @param key          the name of the image to be used
   */
  void execute(CommandMacro commandMacro, String key);
}
