/**
 * <p>applies bright filter</p>
 * @author John Voorhess
 *
 */

public class BrightFilter implements Filter
{
  public void filter(PixelImage pi)
  {
    int [][] bright = {{2,2,2},{2,2,2},{2,2,2}};
    int weightedSum = 16;
    String lens = "";
    pi.computeWeightedAverage(bright, weightedSum, lens);
  }
}