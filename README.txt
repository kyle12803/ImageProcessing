We use a model view controller implementation to create our image processing program.

To use the program, run the Program file and follow the instructions.

We have an Image interface which gets the values for an image.
We also implemented an Image class and a Pixels class to fully represent an image.
An image is defined as a list of list of pixels and it has a max value, height, and width.
A pixel is defined as one pixel and has 3 values for red, green, and blue.

We followed the command design pattern to implement all the behaviors.
Our command folder has all the commands needed for the program to function.
The command interface runs a command on an image.
Every class within the package command has the arithmetic to properly have the command behave as intended.

Our File folder saves and loads our files.
The load class loads an image.
The save class saves an image.

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
