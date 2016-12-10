/**
 * <p>applies Gaussian filter</p>
 * @author johnglennvoorhess
 *
 */

public class GaussianFilter implements Filter
{
  public void filter(PixelImage pi)
  {
    int [][] gaussian = {{1,2,1},{2,4,2},{1,2,1}};
    int weightedSum = 16;
    pi.computeWeightedAverage(gaussian, weightedSum);
  }
}