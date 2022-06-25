package view;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.swing.JPanel;

import image.Image;
import image.Pixel;

/**
 * Represents a histogram chart which measures the frequencies of RGB and intensity components.
 */
public class Histogram extends JPanel {

  Image img;
  Map<Color, Map<Integer, Integer>> data;
  Map<Color, Function<Pixel, Integer>> frequency;

  /**
   * Constructs a histogram chart.
   */
  public Histogram() {
    this.setSize(400, 400);
    this.img = null;
    this.data = new HashMap<>();
    this.frequency = new HashMap<>();
    this.frequency.put(Color.red, Pixel::getR);
    this.frequency.put(Color.green, Pixel::getG);
    this.frequency.put(Color.blue, Pixel::getB);
    this.frequency.put(Color.orange, p -> (p.getR() + p.getG() + p.getB()) / 3);
  }

  /**
   * Updates the data with the new image provided.
   *
   * @param img the image to be represented in the histogram
   */
  public void updateData(Image img) {
    this.img = img;
    this.data = new HashMap<>();
    for (Color c : this.frequency.keySet()) {
      Function<Pixel, Integer> func = this.frequency.get(c);
      this.data.put(c, this.getColorFrequency(func));
    }
    this.repaint();
  }

  @Override
  public void paint(Graphics g) {
    Graphics2D g2D = (Graphics2D) g;
    int xPrev = 0;
    int yPrev = 0;
    int max = 0;
    for (Map<Integer, Integer> freq : this.data.values()) {
      max = Math.max(max, Collections.max(freq.values()));
    }
    int min = max;
    for (Map<Integer, Integer> freq : this.data.values()) {
      min = Math.min(min, Collections.min(freq.values()));
    }

    for (Color c : this.data.keySet()) {
      g2D.setColor(c);
      for (Map.Entry<Integer, Integer> entry : this.data.get(c).entrySet()) {
        int rgb = entry.getKey(); // 0-255
        int freq = entry.getValue(); // frequency that rgb value occurs
        int normalizedFreq = (int) (((double) (freq - min) / (max - min)) * 400);
        g2D.drawLine(xPrev, yPrev, rgb, 400 - normalizedFreq);
        xPrev = rgb;
        yPrev = 400 - normalizedFreq;
      }
    }
  }

  private Map<Integer, Integer> getColorFrequency(Function<Pixel, Integer> func) {
    Map<Integer, Integer> colorFrequency = new HashMap<>();
    for (int i = 0; i < this.img.getHeight(); i++) {
      for (int j = 0; j < this.img.getWidth(); j++) {
        Pixel pix = this.img.getPixels().get(i).get(j);
        int value = func.apply(pix);
        if (colorFrequency.containsKey(value)) {
          colorFrequency.put(value, colorFrequency.get(value) + 1);
        } else {
          colorFrequency.put(value, 1);
        }
      }
    }
    for (int i = 0; i < 256; i++) {
      if (!colorFrequency.containsKey(i)) {
        colorFrequency.put(i, 0);
      }
    }
    return colorFrequency;
  }
}