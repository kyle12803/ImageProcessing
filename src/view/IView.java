package view;

import java.awt.event.ActionListener;

public interface IView {
  /**
   * Make the view visible. This is usually called
   * after the view is constructed
   */
  void makeVisible();

  /**
   * Provide the view with an action listener for
   * the button that should cause the program to
   * process a command. This is so that when the button
   * is pressed, control goes to the action listener
   *
   * @param actionEvent the event going on which will be passed in.
   */
  void setCommandButtonListener(ActionListener actionEvent);

  /**
   * Get the command typed by the user
   *
   * @return
   */
  String getImageCommand();


  /**
   * Transmit an error message to the view, in case
   * the command could not be processed correctly
   *
   * @param error this is the error message to be shown.
   */
  void showErrorMessage(String error);


}
