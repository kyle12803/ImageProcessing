package view;

import java.awt.event.ActionListener;

public interface IView {
  /**
   * Make the view visible. This is usually called
   * after the view is constructed
   */
  void makeVisible(ActionListener actionListener);


  /**
   * Transmit an error message to the view, in case
   * the command could not be processed correctly
   *
   * @param error this is the error message to be shown.
   */
  void showErrorMessage(String error);


}
