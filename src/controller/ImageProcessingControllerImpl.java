package controller;

import java.io.IOException;
import java.util.Scanner;

import model.ImageProcessingModel;
import view.ImageProcessingView;

public class ImageProcessingControllerImpl implements ImageProcessingController {
  private Readable rd;
  private ImageProcessingModel model;
  private ImageProcessingView view;



  public ImageProcessingControllerImpl(Readable rd, ImageProcessingModel model)
          throws IllegalArgumentException {
    if (rd == null || model == null) {
      throw new IllegalArgumentException("Readable or model is null.");
      }
    this.rd = rd;
    this.model = model;
  }

  @Override
  public void runProgram() throws IllegalStateException {
    Scanner sc = new Scanner(rd);
    boolean quit = false;

    //print the welcome message
    this.welcomeMessage();

    while (!quit && sc.hasNext()) { //continue until the user quits
      writeMessage("Type instruction: "); //prompt for the instruction name
      String userInstruction = sc.next(); //take an instruction name
      if (userInstruction.equals("quit") || userInstruction.equals("q")) {
        quit = true;
      }
      else {
        processCommand(userInstruction, sc, model);
      }
    }

    //after the user has quit, print farewell message
    this.farewellMessage();

  }

  private void processCommand(String userInstruction, Scanner sc, ImageProcessingModel model) {
    switch (userInstruction) {
      case "load":
        try {
          String
        } catch () {

        }
    }
  }

  private void welcomeMessage() throws IllegalStateException {
    writeMessage("Welcome to the spreadsheet program!" + System.lineSeparator());
    printMenu();
  }

  private void printMenu() throws IllegalStateException {
    writeMessage("Supported user instructions are: " + System.lineSeparator());
    writeMessage("load [image-path] [image-name]" + System.lineSeparator());
  }

  private void writeMessage(String msg) throws IllegalStateException {
    try {
      this.view.renderMessage(msg);
    } catch (IOException e) {
      throw new IllegalStateException();
    }
  }

  private void farewellMessage() throws IllegalStateException {
    writeMessage("Thank you for using this program!");
  }
}
