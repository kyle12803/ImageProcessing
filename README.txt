We use a model view controller implementation to create our image processing program.

To use the program, run the Program file and follow the instructions. A script file can 

We have an Image interface which gets the values for an image.
We also implemented an Image class and a Pixels class to fully represent an image.
An image is defined as a list of list of pixels and it has a max value, height, and width.
A pixel is defined as one pixel and has 3 values for red, green, and blue.

We followed the command design pattern to implement all the behaviors.
Our command folder has all the commands needed for the program to function.
The command interface runs a command on an image.
Every class within the package command has the arithmetic to properly have the command behave as intended.
In order to implement Downscale, we had to create an entirely new class similarly to how load and save are independent. This class is used in the controller which is just another added switch case checking for the "downscale" command. 
In order to implement Partial Image Manipulation, we created another CommandMacro which takes in three images; the mask, the image that has already applied the manipulation, and the original image. We then had to go through each color transformation command and check for four components which demonstrates a mask was passed in. Then we applied the original command and then the partial manipulation on this image.

Our File folder saves and loads our files.
The load class loads an image depending on the given type of format.
The save class saves an image depending on the type of wanted image format.

Our model folder has the interface for an image processing model.
This sets the contract to get an image, add an image, clone an image, and the model executes commands.
The model class implements a map of images where images are loaded, and saved into that map with a string key if needed by the user.
It also implements all the methods from the interface and uses the map.

Our controller interface runs the program.
The class for the controller has the menu, and all messages needed to print within the methods.

Our view interface renders the messages.
Our view renders the messages from the controller.

Image used in res folder is from https://www.dreamstime.com/photos-images/angry-grandma.html
This image is a free and royalty-free stock photo from Dreamstime.

For our new GUI implementation, we created several JComponents from the Swing class to tie in everything. We followed a top down design where there is the main panel at the top, the dialog boxes connected under the main panel, and all other panels are added to the dialog boxes panel. We represent an image at the top, then a histogram, then we have the load and save buttons. At the bottom, we have a combobox with all the commands. Once an option is selected, the image updates and so does the histogram.

Our GUI is represented in a class where there is a frame. The frame contains the initFrame, where the method call creates everything instead of creating everything in just the constructor. We also have render image and render histogram which both update the histogram and image respectively. 

To generate our histogram, we created a histogram class which computes everything and stores the colors as well as their frequencies to a map.
