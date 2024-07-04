# Image Processing Program

This project implements an image processing program using the Model-View-Controller (MVC) architecture.

## Usage

To use the program:
- Run the `Program` file and follow the instructions provided.

## Components

### Model

- Implemented an Image interface to handle image data.
- Image class and Pixels class fully represent images with properties such as max value, height, and width.
- Pixel class defines individual pixel properties (red, green, blue).

### Commands

- Utilized the Command design pattern to implement various behaviors.
- Commands are stored in the `command` folder, each implementing specific image operations.
- Added support for new functionalities like Downscale and Partial Image Manipulation.

### File Handling

- `File` folder manages file operations (load and save) for different image formats.
- `Load` class loads images based on the specified format.
- `Save` class saves images in various formats.

### GUI Implementation

- Introduced GUI components using Swing for a user-friendly interface.
- Followed a structured top-down design with panels for image display, histogram, command selection, and file operations.
- Updates image and histogram dynamically based on user actions.

## Image Attribution

- The image used in the `res` folder is sourced from [Dreamstime](https://www.dreamstime.com/photos-images/angry-grandma.html).
- This image is royalty-free and used for demonstration purposes.

## Histogram Computation

- Implemented a `Histogram` class to compute color frequencies and display histograms.

## Getting Started

To get started with the project:
- Clone the repository.
- Compile and run the `Program` file to launch the application.

## License

This project is licensed under the [MIT License](LICENSE).
