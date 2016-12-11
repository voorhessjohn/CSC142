/**
 * <p>applies edgy filter</p>
 * @author John Voorhess
 *
 */

public class EdgyFilter implements Filter
{
  public void filter(PixelImage pi)
  {
    int [][] edgy = {{-1,-1,-1},{-1,9,-1},{-1,-1,-1}};
    int weightedSum = 1;
    String lens = "";
    pi.computeWeightedAverage(edgy, weightedSum, lens);
  }
}