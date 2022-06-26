package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;


import image.Image;
import image.Pixel;

/**
 * The class for the view of our frame for our program.
 */
public class ImageGUIFrame extends JFrame implements IView {


  private JPanel imagePanel;
  private JLabel imageLabel;
  private Histogram histogramPanel;
  private JLabel histogramLabel;


  /**
   * The frame for our GUI is constructed here with a controller.
   */
  public ImageGUIFrame() {
    super();
    this.imageLabel = new JLabel();
  }

  /**
   * The method initFrame initializes the frame of our gui with all the components.
   *
   * @param actionListener the action listener delegates the command of what happens.
   */
  public void initFrame(ActionListener actionListener) {
    this.setTitle("Image Processor");
    this.setSize(800, 800);
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel mainPanel;
    JScrollPane mainScrollPane;
    JLabel comboboxDisplay;
    JLabel fileOpenDisplay;
    JLabel fileSaveDisplay;


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


    //Displaying an image
    this.imagePanel = new JPanel();
    this.imagePanel.setBorder(BorderFactory.createTitledBorder("Images"));
    dialogBoxesPanel.add(imagePanel);

    JScrollPane imageScrollPane = new JScrollPane(imageLabel);
    imageScrollPane.setPreferredSize(new Dimension(400, 400));
    imagePanel.add(imageScrollPane);

    //Displaying an histogram (Needs help finishing)
    this.histogramPanel = new Histogram();
    histogramPanel.setBorder(BorderFactory.createTitledBorder("Histogram"));
    dialogBoxesPanel.add(histogramPanel);
    JScrollPane histogramScrollPane = new JScrollPane(histogramLabel);
    histogramScrollPane.setPreferredSize(new Dimension(400, 400));
    histogramPanel.add(histogramScrollPane);

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

  /**
   * The make visible method allows the view to come to fruition.
   *
   * @param actionListener the actionlistener is passed into the view to get behavior.
   */
  @Override
  public void makeVisible(ActionListener actionListener) {
    this.setDefaultLookAndFeelDecorated(false);
    this.initFrame(actionListener);
    this.setVisible(true);
  }


  @Override
  public void renderImage(Image image) {
    BufferedImage output;
    output = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);

    for (int i = 0; i < image.getHeight(); i++) {
      for (int j = 0; j < image.getWidth(); j++) {
        Pixel pixel = image.getPixels().get(i).get(j);
        Color color = new Color(pixel.getR(), pixel.getG(), pixel.getB());
        output.setRGB(j, i, color.getRGB());
      }
    }

    imageLabel.setIcon(new ImageIcon(output));
    imagePanel.validate();
  }

  @Override
  public void renderHistogram(Image image) {

    this.histogramPanel.updateData(image);
    this.histogramPanel.validate();
  }
}
