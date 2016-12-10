/**
 * <p>applies Unsharp filter</p>
 * @author johnglennvoorhess
 *
 */

public class UnsharpFilter implements Filter
{
  public void filter(PixelImage pi)
  {
    int [][] unsharp = {{-1,-2,-1},{-2,28,-2},{-1,-2,-1}};
    int weightedSum = 16;
    pi.computeWeightedAverage(unsharp, weightedSum);
  }
}