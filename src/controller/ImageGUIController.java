package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.NoSuchElementException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.JSpinner;

import command.BlueGreyScaleMacro;
import command.BlurMacro;
import command.BrightenMacro;
import command.Downscale;
import command.GreenGreyScaleMacro;
import command.HorizontalFlipMacro;
import command.IntensityMacro;
import command.LumaMacro;
import command.RedGreyScaleMacro;
import command.SepiaMacro;
import command.SharpenMacro;
import command.ValueMacro;
import command.VerticalFlipMacro;
import file.LoadFile;
import file.SaveFile;
import model.ImageProcessingModel;
import view.IView;


/**
 * This is the Controller for the GUI.
 */
public class ImageGUIController implements ImageProcessingController, ActionListener {
  private final ImageProcessingModel model;
  private final IView view;

  private final StringBuilder fileName;


  /**
   * Constructs a gui controller which connects to the model and the view.
   *
   * @param model the image processing model
   * @param view  the image processing view
   * @throws IllegalArgumentException if the model or view is null
   */
  public ImageGUIController(ImageProcessingModel model, IView view)
          throws IllegalArgumentException {
    if (model == null || view == null) {
      throw new IllegalArgumentException("Invalid model, view or input");
    }
    this.model = model;
    this.view = view;
    this.fileName = new StringBuilder("Image");
  }


  @Override
  public void runProgram() throws IllegalStateException {
    this.view.makeVisible(this);
  }

  public String fileNameGet() {
    return fileName.toString();
  }


  @Override
  public void actionPerformed(ActionEvent e) {
    switch (e.getActionCommand()) {
      case "Load":
        JFileChooser chosen = new JFileChooser(FileSystemView.getFileSystemView()
                .getHomeDirectory());
        chosen.showOpenDialog(null);
        File selectedFile = chosen.getSelectedFile();
        if (selectedFile == null) {
          return;
        }

        String path = selectedFile.getPath();
        String name = selectedFile.getName();
        fileName.delete(0, fileName.length());
        fileName.append(name);
        try {
          this.model.addImage(new LoadFile().load(path), name);
          view.renderImage(this.model.getImage(name));
          view.renderHistogram(this.model.getImage(name));
        } catch (NoSuchElementException | IllegalArgumentException x) {
          throw new IllegalArgumentException();
        }
        break;

      case "Save":
        try {
          JTextArea textArea = new JTextArea(24, 80);
          JFileChooser fileChooser = new JFileChooser();
          int retval = fileChooser.showSaveDialog(null);
          if (retval == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            if (file == null) {
              return;
            }
            try {
              String filename = fileName.toString();
              String filepath = fileChooser.getSelectedFile().getPath();
              new SaveFile(this.model.getImage(filename)).save(filepath);
            } catch (Exception y) {
              y.printStackTrace();
            }
          }
        } catch (NullPointerException | NoSuchElementException | IllegalArgumentException y) {
          throw new IllegalArgumentException();
        }
        break;

      case "comboBoxChanged":
        JComboBox button = (JComboBox) e.getSource();
        String str = button.getSelectedItem().toString();
        switch (str) {
          case "Red Component":
            try {
              String imgName = fileName.toString();
              String destName = imgName + "Red Component";
              this.model.execute(new RedGreyScaleMacro(this.model.clone(imgName, destName)));
              view.renderImage(this.model.getImage(destName));
              view.renderHistogram(this.model.getImage(destName));
            } catch (NoSuchElementException | IllegalArgumentException x) {
              throw new IllegalArgumentException();
            }
            break;

          case "Green Component":
            try {
              String imgName = fileName.toString();
              String destName = imgName + "Green Component";
              this.model.execute(new GreenGreyScaleMacro(this.model.clone(imgName, destName)));
              view.renderImage(this.model.getImage(destName));
              view.renderHistogram(this.model.getImage(destName));
            } catch (NoSuchElementException | IllegalArgumentException x) {
              throw new IllegalArgumentException();
            }
            break;

          case "Blue Component":
            try {
              String imgName = fileName.toString();
              String destName = imgName + "Blue Component";
              this.model.execute(new BlueGreyScaleMacro(this.model.clone(imgName, destName)));
              view.renderImage(this.model.getImage(destName));
              view.renderHistogram(this.model.getImage(destName));
            } catch (NoSuchElementException | IllegalArgumentException x) {
              throw new IllegalArgumentException();
            }
            break;

          case "Value":
            try {
              String imgName = fileName.toString();
              String destName = imgName + "Value";
              this.model.execute(new ValueMacro(this.model.clone(imgName, destName)));
              view.renderImage(this.model.getImage(destName));
              view.renderHistogram(this.model.getImage(destName));
            } catch (NoSuchElementException | IllegalArgumentException x) {
              throw new IllegalArgumentException();
            }
            break;

          case "Luma":
            try {
              String imgName = fileName.toString();
              String destName = imgName + "Luma";
              this.model.execute(new LumaMacro(this.model.clone(imgName, destName)));
              view.renderImage(this.model.getImage(destName));
              view.renderHistogram(this.model.getImage(destName));
            } catch (NoSuchElementException | IllegalArgumentException x) {
              throw new IllegalArgumentException();
            }
            break;

          case "Intensity":
            try {
              String imgName = fileName.toString();
              String destName = imgName + "Intensity";
              this.model.execute(new IntensityMacro(this.model.clone(imgName, destName)));
              view.renderImage(this.model.getImage(destName));
              view.renderHistogram(this.model.getImage(destName));
            } catch (NoSuchElementException | IllegalArgumentException x) {
              throw new IllegalArgumentException();
            }
            break;

          case "Horizontal Flip":
            try {
              String imgName = fileName.toString();
              String destName = imgName + "Horizontal Flip";
              this.model.execute(new HorizontalFlipMacro(this.model.clone(imgName, destName)));
              view.renderImage(this.model.getImage(destName));
              view.renderHistogram(this.model.getImage(destName));
            } catch (NoSuchElementException | IllegalArgumentException x) {
              throw new IllegalArgumentException();
            }
            break;

          case "Vertical Flip":
            try {
              String imgName = fileName.toString();
              String destName = imgName + "Vertical Component";
              this.model.execute(new VerticalFlipMacro(this.model.clone(imgName, destName)));
              view.renderImage(this.model.getImage(destName));
              view.renderHistogram(this.model.getImage(destName));
            } catch (NoSuchElementException | IllegalArgumentException x) {
              throw new IllegalArgumentException();
            }
            break;

          case "Blur":
            try {
              String imgName = fileName.toString();
              String destName = imgName + "Blur";
              this.model.execute(new BlurMacro(this.model.clone(imgName, destName)));
              view.renderImage(this.model.getImage(destName));
              view.renderHistogram(this.model.getImage(destName));
            } catch (NoSuchElementException | IllegalArgumentException x) {
              throw new IllegalArgumentException();
            }
            break;

          case "Sharpen":
            try {
              String imgName = fileName.toString();
              String destName = imgName + "Sharpen";
              this.model.execute(new SharpenMacro(this.model.clone(imgName, destName)));
              view.renderImage(this.model.getImage(destName));
              view.renderHistogram(this.model.getImage(destName));
            } catch (NoSuchElementException | IllegalArgumentException x) {
              throw new IllegalArgumentException();
            }
            break;

          case "Sepia":
            try {
              String imgName = fileName.toString();
              String destName = imgName + "Sepia";
              this.model.execute(new SepiaMacro(this.model.clone(imgName, destName)));
              view.renderImage(this.model.getImage(destName));
              view.renderHistogram(this.model.getImage(destName));
            } catch (NoSuchElementException | IllegalArgumentException x) {
              throw new IllegalArgumentException();
            }
            break;

          case "Brighten":
            try {
              String imgName = fileName.toString();
              String destName = imgName + "Brighten";
              JTextField brightnessText = new JTextField();
              brightnessText.setBorder(BorderFactory.
                      createTitledBorder("Enter the brightness increment:"));
              JSpinner numInput = new JSpinner();
              int num = (Integer) numInput.getValue();
              this.model.execute(new BrightenMacro(this.model.clone(imgName, destName), num));
              view.renderImage(this.model.getImage(destName));
              view.renderHistogram(this.model.getImage(destName));
            } catch (NoSuchElementException | IllegalArgumentException x) {
              throw new IllegalArgumentException();
            }
            break;

          case "Downscale":
            try {
              JTextField nameJ = new JTextField();
              String nameOfImage = nameJ.getText();
              String imgName = nameOfImage;
              JTextField finalName = new JTextField();
              String destinationName = finalName.getText();
              String destName = destinationName;
              JTextField downScaleText = new JTextField();
              downScaleText.setBorder(BorderFactory.
                      createTitledBorder("Enter the downscale increment:"));
              double num = Double.parseDouble(downScaleText.getText());
              (new Downscale(this.model.clone(imgName, destName), num)).resize();
              view.renderImage(this.model.getImage(destName));
              view.renderHistogram(this.model.getImage(destName));
            } catch (NoSuchElementException | IllegalArgumentException x) {
              throw new IllegalArgumentException();
            }
            break;
          default:
        }
        break;
      default:
    }
  }
}
