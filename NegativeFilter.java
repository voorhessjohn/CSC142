/**
 * Filter that flips the image horizontally.
 * This class is COMPLETE. Don't change it. But model your other classes (such
 * as FlipVerticalFilter) after it.
 */
public class NegativeFilter implements Filter
{
  public void filter(PixelImage pi)
  {
    Pixel[][] data = pi.getData();

    for (int row = 0; row < pi.getHeight(); row++) {
        for (int col = 0; col < pi.getWidth(); col++) {
            Pixel temp = data[row][col];
            temp.red = 255-temp.red;
            temp.green = 255-temp.green;
            temp.blue = 255-temp.blue;
        }
    }

    pi.setData(data);
  }
}
