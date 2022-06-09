package controller;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import command.BlueGreyScaleMacro;
import command.BrightenMacro;
import command.GreenGreyScaleMacro;
import command.HorizontalFlipMacro;
import command.IntensityMacro;
import command.LumaMacro;
import command.RedGreyScaleMacro;
import command.ValueMacro;
import command.VerticalFlipMacro;
import file.LoadFIle;
import file.SaveFile;
import image.Image;
import model.ImageProcessingModel;
import view.ImageProcessingView;

public class ImageProcessingControllerImpl implements ImageProcessingController {
  private Readable rd;
  private ImageProcessingModel model;
  private ImageProcessingView view;

  public ImageProcessingControllerImpl(Readable rd, ImageProcessingModel model,
                                       ImageProcessingView view) throws IllegalArgumentException {
    if (rd == null || model == null || view == null) {
      throw new IllegalArgumentException("Readable or model is null.");
    }
    this.rd = rd;
    this.model = model;
    this.view = view;
  }

  @Override
  public void runProgram() throws IllegalStateException {
    Scanner sc = new Scanner(rd);
    boolean quit = false;

    //print the welcome message
    this.welcomeMessage();

    while (!quit && sc.hasNext()) { //continue until the user quits
      writeMessage("Type instruction: "); //prompt for the instruction name
      String[] line = sc.nextLine().split(" ");
      if (line[0].equals("quit") || line[0].equals("q")) {
        quit = true;
      } else {
        processCommand(line, sc, model);
      }
    }

    //after the user has quit, print farewell message
    this.farewellMessage();

  }

  private void processCommand(String[] line, Scanner sc, ImageProcessingModel model) {
    switch (line[0]) {
      case "load":
        if (line.length == 3) {
          try {
            String path = line[1];
            String name = line[2];
            this.model.addImage(new LoadFIle().load(path), name);
          } catch (NoSuchElementException | IllegalArgumentException e) {
            throw new IllegalStateException();
          }
        } else {
          writeMessage("Invalid operation! Please try again.\n");
        }
        break;
      case "save":
        if (line.length == 3) {
          try {
            String path = line[1];
            String name = line[2];
            Image img = this.model.getImage(name);
            String contents = "P3\n" + img.getHeight() + " " + img.getWidth() + " " + img.getMaxValue() + " "
                    + img.getPixels();
             new SaveFile().save(path, contents);
          } catch (NoSuchElementException | IllegalArgumentException | IOException e) {
            throw new IllegalStateException();
          }
        } else {
          writeMessage("Invalid operation! Please try again.\n");
        }
        break;
      case "red-component":
        if (line.length == 3) {
          try {
            String imgName = line[1];
            String destName = line[2];
            this.model.execute(new RedGreyScaleMacro(this.model.getImage(imgName)));
          } catch (NoSuchElementException | IllegalArgumentException e) {
            throw new IllegalStateException();
          }
        }
        break;
      case "green-component":
        if (line.length == 3) {
          try {
            String imgName = line[1];
            String destName = line[2];
            this.model.execute(new GreenGreyScaleMacro(this.model.getImage(imgName)));
          } catch (NoSuchElementException | IllegalArgumentException e) {
            throw new IllegalStateException();
          }
        }
        break;
      case "blue-component":
        if (line.length == 3) {
          try {
            String imgName = line[1];
            String destName = line[2];
            this.model.execute(new BlueGreyScaleMacro(this.model.getImage(imgName)));
          } catch (NoSuchElementException | IllegalArgumentException e) {
            throw new IllegalStateException();
          }
        }
        break;
      case "value-component":
        if (line.length == 3) {
          try {
            String imgName = line[1];
            String destName = line[2];
            this.model.execute(new ValueMacro(this.model.getImage(imgName)));
          } catch (NoSuchElementException | IllegalArgumentException e) {
            throw new IllegalStateException();
          }
        }
        break;
      case "intensity-component":
        if (line.length == 3) {
          try {
            String imgName = line[1];
            String destName = line[2];
            this.model.execute(new IntensityMacro(this.model.getImage(imgName)));
          } catch (NoSuchElementException | IllegalArgumentException e) {
            throw new IllegalStateException();
          }
        }
        break;
      case "luma-component":
        if (line.length == 3) {
          try {
            String imgName = line[1];
            String destName = line[2];
            this.model.execute(new LumaMacro(this.model.getImage(imgName)));
          } catch (NoSuchElementException | IllegalArgumentException e) {
            throw new IllegalStateException();
          }
        }
        break;
      case "brighten":
        if (line.length == 4) {
          try {
            int increment = Integer.parseInt(line[1]);
            String imgName = line[2];
            String destName = line[3];
            this.model.execute(new BrightenMacro(this.model.getImage(imgName), increment));
          } catch (NoSuchElementException | IllegalArgumentException e) {
            throw new IllegalStateException();
          }
        }
        break;
      case "horizontal-flip":
        if (line.length == 3) {
          try {
            String imgName = line[1];
            String destName = line[2];
            this.model.execute(new HorizontalFlipMacro(this.model.getImage(imgName)));
          } catch (NoSuchElementException | IllegalArgumentException e) {
            throw new IllegalStateException();
          }
        }
        break;
      case "vertical-flip":
        if (line.length == 4) {
          try {
            int increment = Integer.parseInt(line[1]);
            String imgName = line[2];
            String destName = line[3];
            this.model.execute(new VerticalFlipMacro(this.model.getImage(imgName)));
          } catch (NoSuchElementException | IllegalArgumentException e) {
            throw new IllegalStateException();
          }
        }
        break;
    }
  }

  private void welcomeMessage() throws IllegalStateException {
    writeMessage("Welcome to the spreadsheet program!" + System.lineSeparator());
    printMenu();
  }

  private void printMenu() throws IllegalStateException {
    writeMessage("Supported user instructions are: " + System.lineSeparator());
    writeMessage("load [image-path] [image-name]" + System.lineSeparator());
    writeMessage("save [image-path] [image-name]" + System.lineSeparator());
    writeMessage("red-component [image-name] [dest-image-name]" + System.lineSeparator());
    writeMessage("green-component [image-name] [dest-image-name]" + System.lineSeparator());
    writeMessage("blue-component [image-name] [dest-image-name]" + System.lineSeparator());
    writeMessage("value [image-name] [dest-image-name]" + System.lineSeparator());
    writeMessage("luma [image-name] [dest-image-name]" + System.lineSeparator());
    writeMessage("intensity [image-name] [dest-image-name]" + System.lineSeparator());
    writeMessage("horizontal-flip [image-name] [dest-image-name]" + System.lineSeparator());
    writeMessage("vertical-flip [image-name] [dest-image-name]" + System.lineSeparator());
    writeMessage("brighten [increment] [image-name] [dest-image-name]"
            + System.lineSeparator());
    writeMessage("q or quit (quit the program) " + System.lineSeparator());

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
