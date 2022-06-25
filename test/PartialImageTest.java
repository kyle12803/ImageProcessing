import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import command.BlueGreyScaleMacro;
import command.BlurMacro;
import command.CommandMacro;
import command.GreenGreyScaleMacro;
import command.IntensityMacro;
import command.LumaMacro;
import command.PartialImageMacro;
import command.RedGreyScaleMacro;
import command.SepiaMacro;
import command.SharpenMacro;
import command.ValueMacro;
import image.Image;
import image.ImageImpl;
import image.Pixel;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * Example class for partial image macro used for testing purposes.
 */
public class PartialImageTest {
  Pixel exampleTest1 = new Pixel(50, 60, 70);
  Pixel exampleTest2 = new Pixel(0, 0, 0);
  Pixel exampleTest3 = new Pixel(60, 60, 60);
  Pixel exampleTest4 = new Pixel(255, 255, 255);
  Pixel exampleTest5 = new Pixel(200, 25, 25);
  Pixel exampleTest6 = new Pixel(55, 25, 55);

  List<List<Pixel>> lop1 = new ArrayList<>(asList(
          new ArrayList<>(asList(exampleTest1, exampleTest2, exampleTest3)),
          new ArrayList<>(asList(exampleTest4, exampleTest5, exampleTest6))));

  Image image1 = new ImageImpl(255, 3, 2, lop1);
  Image copy = new ImageImpl(255, 3, 2, lop1);

  Pixel black = new Pixel(0, 0, 0);
  List<List<Pixel>> maskLop = new ArrayList<>(asList(
          new ArrayList<>(asList(black, black, black)),
          new ArrayList<>(asList(exampleTest4, exampleTest5, exampleTest6))));
  Image mask = new ImageImpl(255, 3, 2, maskLop);

  @Test
  public void testRed() {
    CommandMacro redGreyScale = new RedGreyScaleMacro(image1);
    redGreyScale.command();
    CommandMacro partialImage = new PartialImageMacro(mask, image1, copy);
    partialImage.command();
    for (int i = 0; i < this.copy.getHeight(); i++) {
      for (int j = 0; j < this.copy.getWidth(); j++) {
        Pixel maskPix = this.mask.getPixels().get(i).get(j);
        if (maskPix.getR() != 0 || maskPix.getG() != 0 || maskPix.getB() != 0) {
          Pixel copyPix = this.copy.getPixels().get(i).get(j);
          Pixel imagePix = this.image1.getPixels().get(i).get(j);
          assertEquals(copyPix.getR(), imagePix.getR());
          assertEquals(copyPix.getG(), imagePix.getG());
          assertEquals(copyPix.getB(), imagePix.getB());
        }
      }
    }
  }

  @Test
  public void testGreen() {
    CommandMacro greenGreyScale = new GreenGreyScaleMacro(image1);
    greenGreyScale.command();
    CommandMacro partialImage = new PartialImageMacro(mask, image1, copy);
    partialImage.command();
    for (int i = 0; i < this.copy.getHeight(); i++) {
      for (int j = 0; j < this.copy.getWidth(); j++) {
        Pixel maskPix = this.mask.getPixels().get(i).get(j);
        if (maskPix.getR() != 0 || maskPix.getG() != 0 || maskPix.getB() != 0) {
          Pixel copyPix = this.copy.getPixels().get(i).get(j);
          Pixel imagePix = this.image1.getPixels().get(i).get(j);
          assertEquals(copyPix.getR(), imagePix.getR());
          assertEquals(copyPix.getG(), imagePix.getG());
          assertEquals(copyPix.getB(), imagePix.getB());
        }
      }
    }
  }

  @Test
  public void testBlue() {
    CommandMacro blueGreyScale = new BlueGreyScaleMacro(image1);
    blueGreyScale.command();
    CommandMacro partialImage = new PartialImageMacro(mask, image1, copy);
    partialImage.command();
    for (int i = 0; i < this.copy.getHeight(); i++) {
      for (int j = 0; j < this.copy.getWidth(); j++) {
        Pixel maskPix = this.mask.getPixels().get(i).get(j);
        if (maskPix.getR() != 0 || maskPix.getG() != 0 || maskPix.getB() != 0) {
          Pixel copyPix = this.copy.getPixels().get(i).get(j);
          Pixel imagePix = this.image1.getPixels().get(i).get(j);
          assertEquals(copyPix.getR(), imagePix.getR());
          assertEquals(copyPix.getG(), imagePix.getG());
          assertEquals(copyPix.getB(), imagePix.getB());
        }
      }
    }
  }

  @Test
  public void testValue() {
    CommandMacro valueMacro = new ValueMacro(image1);
    valueMacro.command();
    CommandMacro partialImage = new PartialImageMacro(mask, image1, copy);
    partialImage.command();
    for (int i = 0; i < this.copy.getHeight(); i++) {
      for (int j = 0; j < this.copy.getWidth(); j++) {
        Pixel maskPix = this.mask.getPixels().get(i).get(j);
        if (maskPix.getR() != 0 || maskPix.getG() != 0 || maskPix.getB() != 0) {
          Pixel copyPix = this.copy.getPixels().get(i).get(j);
          Pixel imagePix = this.image1.getPixels().get(i).get(j);
          assertEquals(copyPix.getR(), imagePix.getR());
          assertEquals(copyPix.getG(), imagePix.getG());
          assertEquals(copyPix.getB(), imagePix.getB());
        }
      }
    }
  }

  @Test
  public void testIntensity() {
    CommandMacro intensityMacro = new IntensityMacro(image1);
    intensityMacro.command();
    CommandMacro partialImage = new PartialImageMacro(mask, image1, copy);
    partialImage.command();
    for (int i = 0; i < this.copy.getHeight(); i++) {
      for (int j = 0; j < this.copy.getWidth(); j++) {
        Pixel maskPix = this.mask.getPixels().get(i).get(j);
        if (maskPix.getR() != 0 || maskPix.getG() != 0 || maskPix.getB() != 0) {
          Pixel copyPix = this.copy.getPixels().get(i).get(j);
          Pixel imagePix = this.image1.getPixels().get(i).get(j);
          assertEquals(copyPix.getR(), imagePix.getR());
          assertEquals(copyPix.getG(), imagePix.getG());
          assertEquals(copyPix.getB(), imagePix.getB());
        }
      }
    }
  }

  @Test
  public void testLuma() {
    CommandMacro lumaMacro = new LumaMacro(image1);
    lumaMacro.command();
    CommandMacro partialImage = new PartialImageMacro(mask, image1, copy);
    partialImage.command();
    for (int i = 0; i < this.copy.getHeight(); i++) {
      for (int j = 0; j < this.copy.getWidth(); j++) {
        Pixel maskPix = this.mask.getPixels().get(i).get(j);
        if (maskPix.getR() != 0 || maskPix.getG() != 0 || maskPix.getB() != 0) {
          Pixel copyPix = this.copy.getPixels().get(i).get(j);
          Pixel imagePix = this.image1.getPixels().get(i).get(j);
          assertEquals(copyPix.getR(), imagePix.getR());
          assertEquals(copyPix.getG(), imagePix.getG());
          assertEquals(copyPix.getB(), imagePix.getB());
        }
      }
    }
  }

  @Test
  public void testSepia() {
    CommandMacro sepiaMacro = new SepiaMacro(image1);
    sepiaMacro.command();
    CommandMacro partialImage = new PartialImageMacro(mask, image1, copy);
    partialImage.command();
    for (int i = 0; i < this.copy.getHeight(); i++) {
      for (int j = 0; j < this.copy.getWidth(); j++) {
        Pixel maskPix = this.mask.getPixels().get(i).get(j);
        if (maskPix.getR() != 0 || maskPix.getG() != 0 || maskPix.getB() != 0) {
          Pixel copyPix = this.copy.getPixels().get(i).get(j);
          Pixel imagePix = this.image1.getPixels().get(i).get(j);
          assertEquals(copyPix.getR(), imagePix.getR());
          assertEquals(copyPix.getG(), imagePix.getG());
          assertEquals(copyPix.getB(), imagePix.getB());
        }
      }
    }
  }

  @Test
  public void testBlur() {
    CommandMacro blurMacro = new BlurMacro(image1);
    blurMacro.command();
    CommandMacro partialImage = new PartialImageMacro(mask, image1, copy);
    partialImage.command();
    for (int i = 0; i < this.copy.getHeight(); i++) {
      for (int j = 0; j < this.copy.getWidth(); j++) {
        Pixel maskPix = this.mask.getPixels().get(i).get(j);
        if (maskPix.getR() != 0 || maskPix.getG() != 0 || maskPix.getB() != 0) {
          Pixel copyPix = this.copy.getPixels().get(i).get(j);
          Pixel imagePix = this.image1.getPixels().get(i).get(j);
          assertEquals(copyPix.getR(), imagePix.getR());
          assertEquals(copyPix.getG(), imagePix.getG());
          assertEquals(copyPix.getB(), imagePix.getB());
        }
      }
    }
  }

  @Test
  public void testSharpen() {
    CommandMacro sharpenMacro = new SharpenMacro(image1);
    sharpenMacro.command();
    CommandMacro partialImage = new PartialImageMacro(mask, image1, copy);
    partialImage.command();
    for (int i = 0; i < this.copy.getHeight(); i++) {
      for (int j = 0; j < this.copy.getWidth(); j++) {
        Pixel maskPix = this.mask.getPixels().get(i).get(j);
        if (maskPix.getR() != 0 || maskPix.getG() != 0 || maskPix.getB() != 0) {
          Pixel copyPix = this.copy.getPixels().get(i).get(j);
          Pixel imagePix = this.image1.getPixels().get(i).get(j);
          assertEquals(copyPix.getR(), imagePix.getR());
          assertEquals(copyPix.getG(), imagePix.getG());
          assertEquals(copyPix.getB(), imagePix.getB());
        }
      }
    }
  }
}
