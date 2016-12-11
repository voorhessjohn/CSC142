/**
 * <p>applies unsharp filter</p>
 * @author John Voorhess
 *
 */

public class UnsharpFilter implements Filter
{
  public void filter(PixelImage pi)
  {
    int [][] unsharp = {{-1,-2,-1},{-2,28,-2},{-1,-2,-1}};
    int weightedSum = 16;
    String lens = "";
    pi.computeWeightedAverage(unsharp, weightedSum, lens);
  }
}