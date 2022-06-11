package view;

import java.io.IOException;


/**
 * Represents the text based view that a client will see when the image processor is run.
 */
public class ImageProcessingViewImpl implements ImageProcessingView {
  Appendable ap;

  /**
   * Constructs a default image processing view with an appendable as System.out.
   */
  public ImageProcessingViewImpl() {
    this(System.out);
  }

  /**
   * Constructs an image processing view with the given appendable.
   *
   * @param ap the appendable object
   * @throws IllegalArgumentException if the appendable is null
   */
  public ImageProcessingViewImpl(Appendable ap) throws IllegalArgumentException {
    if (ap == null) {
      throw new IllegalArgumentException("Appendable is null.");
    }
    this.ap = ap;
  }

  @Override
  public void renderMessage(String msg) throws IOException {
    this.ap.append(msg);
  }
}
