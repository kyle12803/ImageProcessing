package controller;

import java.io.IOException;
import java.util.Scanner;

import model.ImageProcessingModel;

public class ImageProcessingControllerImpl implements ImageProcessingController {
  private Readable rd;
  private ImageProcessingModel model;



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


  }

  private void welcomeMessage() {

  }

  private void writeMessage(String msg) {
    try {
      this.view.renderMessage(msg);
    } catch (IOException e) {
      throw new IllegalStateException();
    }
  }
}
