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
import image.Pixel;
import model.ImageProcessingModel;
import view.ImageProcessingView;

/**
 * This is the class for the controller which implements our interface and works with the model.
 */
public class ImageProcessingControllerImpl implements ImageProcessingController {
  private final Readable rd;
  private final ImageProcessingModel model;
  private final ImageProcessingView view;

  /**
   * This is the constructor for our controller.
   *
   * @param rd    - this is the readable our model needs.
   * @param model - this is the model the controller will work with.
   * @param view  - this is the view.
   * @throws IllegalArgumentException if any arguments are null.
   */
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
      if (line[0].equals("quit") || line[0].equalsIgnoreCase("q")) {
        quit = true;
      } else {
        processCommand(line, model);
      }
    }

    //after the user has quit, print farewell message
    this.farewellMessage();

  }

  /**
   * This processes all commands we have.
   *
   * @param line  - line of the appendable.
   * @param model - model being used.
   */
  private void processCommand(String[] line, ImageProcessingModel model) {
    switch (line[0]) {
      case "load":
        if (line.length == 3) {
          try {
            String path = line[1];
            String name = line[2];
            this.model.addImage(new LoadFIle().load(path), name);
          } catch (NoSuchElementException | IllegalArgumentException e) {
            writeMessage("Invalid operation! Please try again.\n");
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
            StringBuilder rgbs = new StringBuilder();
            for (int i = 0; i < img.getHeight(); i++) {
              for (int j = 0; j < img.getWidth(); j++) {
                Pixel pix = img.getPixels().get(i).get(j);
                rgbs.append(pix.getR())
                        .append(" ")
                        .append(pix.getB())
                        .append(" ")
                        .append(pix.getB()
                        ).append(" ");
              }
            }
            String contents = "P3\n" + img.getHeight() + " " + img.getWidth() + " "
                    + img.getMaxValue() + " " + rgbs.toString();
            new SaveFile().save(path, contents);
          } catch (NoSuchElementException | IllegalArgumentException | IOException e) {
            writeMessage("Invalid operation! Please try again.\n");
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
            this.model.execute(new RedGreyScaleMacro(this.model.clone(imgName, destName)));
          } catch (NoSuchElementException | IllegalArgumentException e) {
            writeMessage("Invalid operation! Please try again.\n");
          }
        } else {
          writeMessage("Invalid operation! Please try again.\n");
        }
        break;
      case "green-component":
        if (line.length == 3) {
          try {
            String imgName = line[1];
            String destName = line[2];
            this.model.execute(new GreenGreyScaleMacro(this.model.clone(imgName, destName)));
          } catch (NoSuchElementException | IllegalArgumentException e) {
            writeMessage("Invalid operation! Please try again.\n");
          }
        } else {
          writeMessage("Invalid operation! Please try again.\n");
        }
        break;
      case "blue-component":
        if (line.length == 3) {
          try {
            String imgName = line[1];
            String destName = line[2];
            this.model.execute(new BlueGreyScaleMacro(this.model.clone(imgName, destName)));
          } catch (NoSuchElementException | IllegalArgumentException e) {
            writeMessage("Invalid operation! Please try again.\n");
          }
        } else {
          writeMessage("Invalid operation! Please try again.\n");
        }
        break;
      case "value-component":
        if (line.length == 3) {
          try {
            String imgName = line[1];
            String destName = line[2];
            this.model.execute(new ValueMacro(this.model.clone(imgName, destName)));
          } catch (NoSuchElementException | IllegalArgumentException e) {
            writeMessage("Invalid operation! Please try again.\n");
          }
        } else {
          writeMessage("Invalid operation! Please try again.\n");
        }
        break;
      case "intensity-component":
        if (line.length == 3) {
          try {
            String imgName = line[1];
            String destName = line[2];
            this.model.execute(new IntensityMacro(this.model.clone(imgName, destName)));
          } catch (NoSuchElementException | IllegalArgumentException e) {
            writeMessage("Invalid operation! Please try again.\n");
          }
        } else {
          writeMessage("Invalid operation! Please try again.\n");
        }
        break;
      case "luma-component":
        if (line.length == 3) {
          try {
            String imgName = line[1];
            String destName = line[2];
            this.model.execute(new LumaMacro(this.model.clone(imgName, destName)));
          } catch (NoSuchElementException | IllegalArgumentException e) {
            writeMessage("Invalid operation! Please try again.\n");
          }
        } else {
          writeMessage("Invalid operation! Please try again.\n");
        }
        break;
      case "brighten":
        if (line.length == 4) {
          try {
            int increment = Integer.parseInt(line[1]);
            String imgName = line[2];
            String destName = line[3];
            this.model.execute(new BrightenMacro(this.model.clone(imgName, destName), increment));
          } catch (NoSuchElementException | IllegalArgumentException e) {
            writeMessage("Invalid operation! Please try again.\n");
          }
        } else {
          writeMessage("Invalid operation! Please try again.\n");
        }
        break;
      case "horizontal-flip":
        if (line.length == 3) {
          try {
            String imgName = line[1];
            String destName = line[2];
            this.model.execute(new HorizontalFlipMacro(this.model.clone(imgName, destName)));
          } catch (NoSuchElementException | IllegalArgumentException e) {
            writeMessage("Invalid operation! Please try again.\n");
          }
        } else {
          writeMessage("Invalid operation! Please try again.\n");
        }
        break;
      case "vertical-flip":
        if (line.length == 3) {
          try {
            String imgName = line[1];
            String destName = line[2];
            this.model.execute(new VerticalFlipMacro(this.model.clone(imgName, destName)));
          } catch (NoSuchElementException | IllegalArgumentException e) {
            writeMessage("Invalid operation! Please try again.\n");
          }
        } else {
          writeMessage("Invalid operation! Please try again.\n");
        }
        break;
      default:
    }
  }

  /**
   * Prints welcome message.
   *
   * @throws IllegalStateException - thrown if anything is null.
   */
  private void welcomeMessage() throws IllegalStateException {
    writeMessage("Welcome to the spreadsheet program!" + System.lineSeparator());
    printMenu();
  }

  /**
   * Prints the menu.
   *
   * @throws IllegalStateException - thrown if aanything is null.
   */
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

  /**
   * Writes the message.
   *
   * @param msg - input message put in.
   * @throws IllegalStateException - if msg is null.
   */
  private void writeMessage(String msg) throws IllegalStateException {
    try {
      this.view.renderMessage(msg);
    } catch (IOException e) {
      throw new IllegalStateException();
    }
  }

  /**
   * This is the farewell message.
   *
   * @throws IllegalStateException - thrown if anything is null.
   */
  private void farewellMessage() throws IllegalStateException {
    writeMessage("Thank you for using this program!");
  }
}
