import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Scanner;

import controller.ImageGUIController;
import controller.ImageProcessingController;
import controller.ImageProcessingControllerImpl;
import model.ImageProcessingModel;
import model.ImageProcessingModelImpl;
import view.ImageGUIFrame;
import view.ImageProcessingView;
import view.ImageProcessingViewImpl;

/**
 * The main method to run the program.
 */
public class Program {
  /**
   * This is the simple main method to run our program.
   *
   * @param args arguments needed to run the program.
   */
  public static void main(String[] args) {
    ImageProcessingModel model = new ImageProcessingModelImpl();
    ImageProcessingView view = new ImageProcessingViewImpl();
    Readable rd = new InputStreamReader(System.in);
    if (args.length == 2 && args[0].equals("-file")) {
      try {
        Scanner sc = new Scanner(new FileReader(args[1]));
        StringBuilder builder = new StringBuilder();
        while (sc.hasNextLine()) {
          builder.append(sc.nextLine()).append(System.lineSeparator());
        }
        rd = new StringReader(builder.toString());
      } catch (IOException e) {
        throw new RuntimeException("File not found.");
      }
    } else if (args.length == 1 && args[0].equals("-text")) {
      ImageProcessingController controller = new ImageProcessingControllerImpl(rd, model, view);
      controller.runProgram();
    } else if (args.length == 0) {
      ImageGUIFrame view2 = new ImageGUIFrame();
      ImageGUIController controller2 = new ImageGUIController(model, view2);
      controller2.runProgram();
    } else {
      throw new IllegalArgumentException("Invalid command line arguments.");
    }
  }
}
