/**
 * <p>applies Edgy filter</p>
 * @author johnglennvoorhess
 *
 */

public class EdgyFilter implements Filter
{
  public void filter(PixelImage pi)
  {
    int [][] edgy = {{-1,-1,-1},{-1,9,-1},{-1,-1,-1}};
    int weightedSum = 1;
    pi.computeWeightedAverage(edgy, weightedSum);
  }
}