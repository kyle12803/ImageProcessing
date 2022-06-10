We use a model view controller implementation to create our image processing program.

To use the program, run the program file and follow the instructions.

We have an Image interface which gets the values for an image.
we also implemented an Image class and a pixels class to fully represent an image.
An image is defined as a list of list of pixels and it has a max value, height, and width.
A pixel is defined as one pixel and has 3 values for red, green, and blue.

We followed the command design pattern to implement all the behaviors.
Our command folder has all the commands needed for the program to function.
The command interface runs a command on an the command.
Every class within the package command has the arithmetic to properly have the command behave as intended.
Our Blue Grey Scale Macro class is the class to run a Blue Grey Scale Macro.
Our Red Grey Scale Macro class is the class to run a Red Grey Scale Macro.
Our Green Grey Scale Macro class is the class to run a Green Grey Scale Macro.
Our Horizontal Flip macro class flips the image horizontally.
Our Vertical Flip macro class vertically flips the image.
Our Brighten Macro brightens the pixels in an image by the specified increment.
Our Luma Macro changes the pixels with the luma formula.
Our Value takes the max value and has it as the pixels.
Our Intensity takes the average value of pixel and sets it.

Our File folder saves and loads our files.
The load class loads an image.
The save class saves an image.

Our model folder has the interface for an imageProcessingModel.
This sets the contract to get an image, add an image, clone an image, and the model executes commands.

The model class implements a map of images where images are loaded, and saved into that map with a string key if needed by the user.
It also implements all the methods from the interface and uses the map.

Our controller interface runs the program.
The class for the controller has the menu, and all messages needed to print within the methods.

Our view interface renders the messages.
Our view renders the messages from the controller.