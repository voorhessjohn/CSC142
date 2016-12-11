/**
 * <p>applies green filter</p>
 * @author John Voorhess
 *
 */

public class GreenFilter implements Filter
{
  public void filter(PixelImage pi)
  {
    int [][] green = {{1,1,1},{1,1,1},{1,1,1}};
    int weightedSum = 10;
    String lens = "green";
    pi.computeWeightedAverage(green, weightedSum, lens);
  }
}