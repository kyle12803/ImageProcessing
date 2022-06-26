package view;

import java.awt.event.ActionListener;

import image.Image;

/**
 * This represents the interface for all views in the GUI.
 */
public interface IView {
  /**
   * Make the view visible. This is usually called
   * after the view is constructed
   */
  void makeVisible(ActionListener actionListener);

  /**
   * The method renders the histogram continuously.
   *
   * @param image the image passed in to get rendered.
   */
  public void renderHistogram(Image image);

  /**
   * The method continually renders the image as it is laoded, saved or modified.
   *
   * @param image image passed in for the program.
   */
  public void renderImage(Image image);
}
