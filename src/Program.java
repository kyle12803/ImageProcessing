import java.io.InputStreamReader;

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
   * @param args arguments needed to run the program.
   */
  public static void main(String[] args) {
    Readable rd = new InputStreamReader(System.in);
    ImageProcessingModel model = new ImageProcessingModelImpl();
    ImageProcessingView view = new ImageProcessingViewImpl();
    ImageProcessingController controller = new ImageProcessingControllerImpl(rd, model, view);
    controller.runProgram();
  }
}
