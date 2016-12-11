/**
 * <p>applies gaussian filter</p>
 * @author John Voorhess
 *
 */

public class GaussianFilter implements Filter
{
  public void filter(PixelImage pi)
  {
    int [][] gaussian = {{1,2,1},{2,4,2},{1,2,1}};
    int weightedSum = 16;
    String lens = "";
    pi.computeWeightedAverage(gaussian, weightedSum, lens);
  }
}