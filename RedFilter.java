/**
 * <p>applies red filter</p>
 * @author John Voorhess
 *
 */

public class RedFilter implements Filter
{
  public void filter(PixelImage pi)
  {
    int [][] red = {{1,1,1},{1,1,1},{1,1,1}};
    int weightedSum = 10;
    String lens = "red";
    pi.computeWeightedAverage(red, weightedSum, lens);
  }
}