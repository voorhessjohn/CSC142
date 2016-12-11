/**
 * <p>applies Emboss filter</p>
 * @author johnglennvoorhess
 *
 */

public class EmbossFilter implements Filter
{
  public void filter(PixelImage pi)
  {
    int [][] emboss = {{-1,-1,0},{-1,0,1},{0,1,1}};
    int weightedSum = 1;
    pi.computeWeightedAverage(emboss, weightedSum);
  }
}