import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Scanner;

import controller.ImageProcessingController;
import controller.ImageProcessingControllerImpl;
import model.ImageProcessingModel;
import model.ImageProcessingModelImpl;
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
    Readable rd = new InputStreamReader(System.in);
    if (args.length > 0) {
      try {
        Scanner sc = new Scanner(new FileReader(args[0]));
        StringBuilder builder = new StringBuilder();
        while (sc.hasNextLine()) {
          builder.append(sc.nextLine()).append(System.lineSeparator());
        }
        rd = new StringReader(builder.toString());
      } catch (IOException e) {
        throw new RuntimeException("File not found.");
      }
    }
    ImageProcessingModel model = new ImageProcessingModelImpl();
    ImageProcessingView view = new ImageProcessingViewImpl();
    ImageProcessingController controller = new ImageProcessingControllerImpl(rd, model, view);
    controller.runProgram();
  }
}
