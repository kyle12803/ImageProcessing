package view;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ImageGUIFrame extends JFrame {

  private JPanel mainPanel;
  private JScrollPane mainScrollPane;
  private JLabel comboboxDisplay;
  private JLabel fileOpenDisplay;

  private JLabel fileSaveDisplay;
  private ActionListener actionListener;

  /**
   * The Frame for the GUI.
   */
  public ImageGUIFrame(){
  super();
  this.setTitle("Image Processor");
  this.setSize(900, 900);
  this.setVisible(true);
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  //this is the main panel
  mainPanel = new JPanel();
  mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
  //scroll bars around this main panel
  mainScrollPane = new JScrollPane(mainPanel);
  add(mainScrollPane);

  //Displaying an image (Needs help fixing)
  JPanel imagePanel = new JPanel();
  imagePanel.setBorder(BorderFactory.createTitledBorder("Images"));
  imagePanel.setLayout(new BoxLayout(imagePanel, BoxLayout.PAGE_AXIS));

  //dialog boxes
  JPanel dialogBoxesPanel = new JPanel();
  dialogBoxesPanel.setBorder(BorderFactory.createTitledBorder("Dialog boxes"));
  dialogBoxesPanel.setLayout(new BoxLayout(dialogBoxesPanel, BoxLayout.PAGE_AXIS));
  mainPanel.add(dialogBoxesPanel);

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
  comboboxPanel.setBorder(BorderFactory.createTitledBorder("Commands"));
  comboboxPanel.setLayout(new BoxLayout(comboboxPanel, BoxLayout.PAGE_AXIS));
  mainPanel.add(comboboxPanel);

  // need help checking brighten...
  comboboxDisplay = new JLabel("Commands");
  comboboxPanel.add(comboboxDisplay);
  String[] options = {"Load", "Save", "Red Component", "Green Component", "Blue Component",
  "Value", "Luma", "Intensity", "Horizontal Flip", "Blur", "Sharpen", "Sepia", "Brighten", "Quit",
          "Menu"};
  JComboBox<String> combobox = new JComboBox<String>();
    JTextField brightnessText = new JTextField();
    brightnessText.setBorder(BorderFactory.createTitledBorder("Enter the brightness increment:"));
  //the event listener when an option is selected
  combobox.setActionCommand("Apply");
  combobox.addActionListener(actionListener);
  for (int i = 0; i < options.length; i++) {
    combobox.addItem(options[i]);
  }
  comboboxPanel.add(combobox);


  this.pack();
}
}
