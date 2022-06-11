package model;

import command.CommandMacro;
import image.Image;

/**
 * This interface represents the operations offered by the image processing
 * model. One object of the model is one image processor.
 */
public interface ImageProcessingModel {

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
   * Clones an image by adding a duplicate to the map of images.
   *
   * @param image the name of the image to be cloned
   * @param dest  the name of the new clone image
   * @return the new image that has the same properties
   * @throws IllegalArgumentException if the image name is null
   */
  Image clone(String image, String dest) throws IllegalArgumentException;

  /**
   * This is the method where we will call the macro on the model.
   *
   * @param commandMacro the command passed in which we will execute on the model.
   */
  void execute(CommandMacro commandMacro);
}
