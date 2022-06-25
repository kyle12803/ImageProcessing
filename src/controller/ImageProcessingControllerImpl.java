package controller;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import command.BlueGreyScaleMacro;
import command.BlurMacro;
import command.BrightenMacro;
import command.Downscale;
import command.GreenGreyScaleMacro;
import command.HorizontalFlipMacro;
import command.IntensityMacro;
import command.LumaMacro;
import command.PartialImageMacro;
import command.RedGreyScaleMacro;
import command.SepiaMacro;
import command.SharpenMacro;
import command.ValueMacro;
import command.VerticalFlipMacro;
import file.LoadFile;
import file.SaveFile;
import image.Image;
import model.ImageProcessingModel;
import view.ImageProcessingView;

/**
 * This is the class for the controller which implements our interface and works
 * with the model.
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

    // print the welcome message
    this.welcomeMessage();

    while (!quit && sc.hasNext()) { // continue until the user quits
      writeMessage("Type instruction: "); // prompt for the instruction name
      String[] line = sc.nextLine().split(" ");
      if (line[0].equals("quit") || line[0].equalsIgnoreCase("q")) {
        quit = true;
      } else if (line[0].equals("menu") || line[0].equalsIgnoreCase("m")) {
        printMenu();
      } else {
        processCommand(line, model);
      }
    }

    // after the user has quit, print farewell message
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
            this.model.addImage(new LoadFile().load(path), name);
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
            new SaveFile(this.model.getImage(name)).save(path);
          } catch (NullPointerException | NoSuchElementException | IllegalArgumentException
                   | IOException e) {
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
        } else if (line.length == 4) {
          try {
            String imgName = line[1];
            String maskImg = line[2];
            String destName = line[3];
            this.model.execute(new RedGreyScaleMacro(this.model.clone(imgName, destName)));
            this.model.execute(new PartialImageMacro(this.model.getImage(maskImg),
                    this.model.getImage(destName), this.model.getImage(imgName)));
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
        } else if (line.length == 4) {
          try {
            String imgName = line[1];
            String maskImg = line[2];
            String destName = line[3];
            this.model.execute(new GreenGreyScaleMacro(this.model.clone(imgName, destName)));
            this.model.execute(new PartialImageMacro(this.model.getImage(maskImg),
                    this.model.getImage(destName), this.model.getImage(imgName)));
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
        } else if (line.length == 4) {
          try {
            String imgName = line[1];
            String maskImg = line[2];
            String destName = line[3];
            this.model.execute(new BlueGreyScaleMacro(this.model.clone(imgName, destName)));
            this.model.execute(new PartialImageMacro(this.model.getImage(maskImg),
                    this.model.getImage(destName), this.model.getImage(imgName)));
          } catch (NoSuchElementException | IllegalArgumentException e) {
            writeMessage("Invalid operation! Please try again.\n");
          }
        } else {
          writeMessage("Invalid operation! Please try again.\n");
        }
        break;
      case "value":
        if (line.length == 3) {
          try {
            String imgName = line[1];
            String destName = line[2];
            this.model.execute(new ValueMacro(this.model.clone(imgName, destName)));
          } catch (NoSuchElementException | IllegalArgumentException e) {
            writeMessage("Invalid operation! Please try again.\n");
          }
        } else if (line.length == 4) {
          try {
            String imgName = line[1];
            String maskImg = line[2];
            String destName = line[3];
            this.model.execute(new ValueMacro(this.model.clone(imgName, destName)));
            this.model.execute(new PartialImageMacro(this.model.getImage(maskImg),
                    this.model.getImage(destName), this.model.getImage(imgName)));
          } catch (NoSuchElementException | IllegalArgumentException e) {
            writeMessage("Invalid operation! Please try again.\n");
          }
        } else {
          writeMessage("Invalid operation! Please try again.\n");
        }
        break;
      case "intensity":
        if (line.length == 3) {
          try {
            String imgName = line[1];
            String destName = line[2];
            this.model.execute(new IntensityMacro(this.model.clone(imgName, destName)));
          } catch (NoSuchElementException | IllegalArgumentException e) {
            writeMessage("Invalid operation! Please try again.\n");
          }
        } else if (line.length == 4) {
          try {
            String imgName = line[1];
            String maskImg = line[2];
            String destName = line[3];
            this.model.execute(new IntensityMacro(this.model.clone(imgName, destName)));
            this.model.execute(new PartialImageMacro(this.model.getImage(maskImg),
                    this.model.getImage(destName), this.model.getImage(imgName)));
          } catch (NoSuchElementException | IllegalArgumentException e) {
            writeMessage("Invalid operation! Please try again.\n");
          }
        } else {
          writeMessage("Invalid operation! Please try again.\n");
        }
        break;
      case "luma":
        if (line.length == 3) {
          try {
            String imgName = line[1];
            String destName = line[2];
            this.model.execute(new LumaMacro(this.model.clone(imgName, destName)));
          } catch (NoSuchElementException | IllegalArgumentException e) {
            writeMessage("Invalid operation! Please try again.\n");
          }
        } else if (line.length == 4) {
          try {
            String imgName = line[1];
            String maskImg = line[2];
            String destName = line[3];
            this.model.execute(new LumaMacro(this.model.clone(imgName, destName)));
            this.model.execute(new PartialImageMacro(this.model.getImage(maskImg),
                    this.model.getImage(destName), this.model.getImage(imgName)));
          } catch (NoSuchElementException | IllegalArgumentException e) {
            writeMessage("Invalid operation! Please try again.\n");
          }
        } else {
          writeMessage("Invalid operation! Please try again.\n");
        }
        break;
      case "sepia":
        if (line.length == 3) {
          try {
            String imgName = line[1];
            String destName = line[2];
            this.model.execute(new SepiaMacro(this.model.clone(imgName, destName)));
          } catch (NoSuchElementException | IllegalArgumentException e) {
            writeMessage("Invalid operation! Please try again.\n");
          }
        } else if (line.length == 4) {
          try {
            String imgName = line[1];
            String maskImg = line[2];
            String destName = line[3];
            this.model.execute(new SepiaMacro(this.model.clone(imgName, destName)));
            this.model.execute(new PartialImageMacro(this.model.getImage(maskImg),
                    this.model.getImage(destName), this.model.getImage(imgName)));
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
      case "blur":
        if (line.length == 3) {
          try {
            String imgName = line[1];
            String destName = line[2];
            this.model.execute(new BlurMacro(this.model.clone(imgName, destName)));
          } catch (NoSuchElementException | IllegalArgumentException e) {
            writeMessage("Invalid operation! Please try again.\n");
          }
        } else if (line.length == 4) {
          try {
            String imgName = line[1];
            String maskImg = line[2];
            String destName = line[3];
            this.model.execute(new BlurMacro(this.model.clone(imgName, destName)));
            this.model.execute(new PartialImageMacro(this.model.getImage(maskImg),
                    this.model.getImage(destName), this.model.getImage(imgName)));
          } catch (NoSuchElementException | IllegalArgumentException e) {
            writeMessage("Invalid operation! Please try again.\n");
          }
        } else {
          writeMessage("Invalid operation! Please try again.\n");
        }
        break;
      case "sharpen":
        if (line.length == 3) {
          try {
            String imgName = line[1];
            String destName = line[2];
            this.model.execute(new SharpenMacro(this.model.clone(imgName, destName)));
          } catch (NoSuchElementException | IllegalArgumentException e) {
            writeMessage("Invalid operation! Please try again.\n");
          }
        } else if (line.length == 4) {
          try {
            String imgName = line[1];
            String maskImg = line[2];
            String destName = line[3];
            this.model.execute(new SharpenMacro(this.model.clone(imgName, destName)));
            this.model.execute(new PartialImageMacro(this.model.getImage(maskImg),
                    this.model.getImage(destName), this.model.getImage(imgName)));
          } catch (NoSuchElementException | IllegalArgumentException e) {
            writeMessage("Invalid operation! Please try again.\n");
          }
        } else {
          writeMessage("Invalid operation! Please try again.\n");
        }
        break;
      case "downscale":
        if (line.length == 4) {
          try {
            double scale = Double.parseDouble(line[1]);
            String imgName = line[2];
            String destName = line[3];
            Image newImage = new Downscale(this.model.getImage(imgName), scale).resize();
            this.model.addImage(newImage, destName);
          } catch (NoSuchElementException | IllegalArgumentException e) {
            writeMessage("Invalid operation! Please try again.\n");
          }
        } else {
          writeMessage("Invalid operation! Please try again.\n");
        }
        break;
      default:
        writeMessage("Invalid operation! Please try again.\n");
    }
  }

  /**
   * Prints welcome message.
   *
   * @throws IllegalStateException - thrown if anything is null.
   */
  private void welcomeMessage() throws IllegalStateException {
    writeMessage("Welcome to the image processing program!" + System.lineSeparator());
    printMenu();
  }

  /**
   * Prints the menu.
   *
   * @throws IllegalStateException - thrown if anything is null.
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
    writeMessage("blur [image-name] [dest-image-name]" + System.lineSeparator());
    writeMessage("sharpen [image-name] [dest-image-name]" + System.lineSeparator());
    writeMessage("sepia [image-name] [dest-image-name]" + System.lineSeparator());
    writeMessage("brighten [increment] [image-name] [dest-image-name]"
            + System.lineSeparator());
    writeMessage("downscale [percentage-scale] [image-name] [dest-image-name]"
            + System.lineSeparator());
    writeMessage("If you would like to partially manipulate an image please use: "
            + "[command] [image-name] [mask-image] [dest-name]" + System.lineSeparator());
    writeMessage("q or quit (quit the program) " + System.lineSeparator());
    writeMessage("m or menu (prints the supported instructions menu) "
            + System.lineSeparator());

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
