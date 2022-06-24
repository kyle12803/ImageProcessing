package view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.swing.*;

import controller.ImageGUIController;
import image.Image;
import image.Pixel;

public class ImageGUIFrame extends JFrame implements IView {

  private JPanel mainPanel;
  private JScrollPane mainScrollPane;
  private JLabel comboboxDisplay;
  private JLabel fileOpenDisplay;
  private JPanel imagePanel;
  private JLabel imageLabel;

  private JLabel fileSaveDisplay;
  private ImageGUIController controller;
  private ActionListener actionListener;


  /**
   * The Frame for the GUI.
   */
  public ImageGUIFrame(ImageGUIController controller) {
    super();
    this.controller = controller;
    this.imageLabel=new JLabel();
  }

  public void initFrame(ActionListener actionListener) {
    this.setTitle("Image Processor");
    this.setSize(700, 700);
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //this is the main panel
    mainPanel = new JPanel();
    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
    //scroll bars around this main panel
    mainScrollPane = new JScrollPane(mainPanel);
    add(mainScrollPane);

    //dialog boxes
    JPanel dialogBoxesPanel = new JPanel();
    dialogBoxesPanel.setBorder(BorderFactory.createTitledBorder("Dialog boxes"));
    mainPanel.add(dialogBoxesPanel);
    dialogBoxesPanel.setLayout(new BoxLayout(dialogBoxesPanel, BoxLayout.PAGE_AXIS));


    //Displaying an image (Needs help fixing)
    this.imagePanel = new JPanel();
    this.imagePanel.setBorder(BorderFactory.createTitledBorder("Images"));
    dialogBoxesPanel.add(imagePanel);

    JScrollPane imageScrollPane = new JScrollPane(imageLabel);
     imageScrollPane.setPreferredSize(new Dimension(300, 300));
     imagePanel.add(imageScrollPane);

//    //Displaying an histogram (Needs help finishing)
//    JPanel histogramPanel = new JPanel();
//    histogramPanel.setBorder(BorderFactory.createTitledBorder("Histogram"));
//    histogramPanel.setLayout(new BoxLayout(histogramPanel, BoxLayout.PAGE_AXIS));
//    dialogBoxesPanel.add(histogramPanel);
//    this.mainPanel.add(imagePanel);

    //file open
    JPanel fileopenPanel = new JPanel();
    fileopenPanel.setLayout(new FlowLayout());
    dialogBoxesPanel.add(fileopenPanel);
    JButton fileOpenButton = new JButton("Load a file");
    fileOpenButton.setActionCommand("Load");
    fileOpenButton.addActionListener(actionListener);
    fileopenPanel.add(fileOpenButton);
    fileOpenDisplay = new JLabel("File path will appear here");
    fileopenPanel.add(fileOpenDisplay);



    //file save
    JPanel filesavePanel = new JPanel();
    filesavePanel.setLayout(new FlowLayout());
    dialogBoxesPanel.add(filesavePanel);
    JButton fileSaveButton = new JButton("Save a file");
    fileSaveButton.setActionCommand("Save");
    fileSaveButton.addActionListener(actionListener);
    filesavePanel.add(fileSaveButton);
    fileSaveDisplay = new JLabel("File path will appear here");
    filesavePanel.add(fileSaveDisplay);

    // THIS IS THE DROPDOWN MENU
    JPanel comboboxPanel = new JPanel();
    comboboxPanel.setLayout(new BoxLayout(comboboxPanel, BoxLayout.PAGE_AXIS));
    mainPanel.add(comboboxPanel);


    comboboxDisplay = new JLabel("Commands");
    comboboxPanel.add(comboboxDisplay);
   // JButton apply = new JButton("Apply");
    //apply.setActionCommand("Apply");
    //apply.addActionListener(actionListener);
    //comboboxPanel.add(apply);
    String[] options = {"Red Component", "Green Component", "Blue Component",
            "Value", "Luma", "Intensity", "Horizontal Flip", "Vertical Flip",
            "Blur", "Sharpen", "Sepia", "Brighten", "Downscale"};
    JComboBox<String> comboBox = new JComboBox<String>();
    //the event listener when an option is selected
    for (int i = 0; i < options.length; i++) {
      comboBox.addItem(options[i]);
    }
    comboBox.setEditable(false);
    comboBox.addActionListener(actionListener);
    comboboxPanel.add(comboBox);



    this.pack();
  }

  @Override
  public void makeVisible(ActionListener actionListener) {
    this.setDefaultLookAndFeelDecorated(false);
    this.initFrame(actionListener);
    this.setVisible(true);
  }

  @Override
  public void showErrorMessage(String error) {

  }

  public void renderImage(Image image){
          BufferedImage output;
            output = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);

            for(int i=0; i<image.getHeight();i++){
              for(int j=0;j<image.getWidth();j++){
                Pixel pixel = image.getPixels().get(i).get(j);
                Color color=new Color(pixel.getR(), pixel.getG(), pixel.getB());
                output.setRGB(j,i,color.getRGB());
              }
            }

    imageLabel.setIcon(new ImageIcon(output));
    imagePanel.validate();
  }
}
