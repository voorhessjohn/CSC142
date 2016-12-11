/**
 * <p>applies emboss filter</p>
 * @author John Voorhess
 *
 */

public class EmbossFilter implements Filter
{
  public void filter(PixelImage pi)
  {
    int [][] emboss = {{-1,-1,0},{-1,0,1},{0,1,1}};
    int weightedSum = 1;
    String lens = "";
    pi.computeWeightedAverage(emboss, weightedSum, lens);
  }
}