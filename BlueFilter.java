/**
 * <p>applies blue filter</p>
 * @author John Voorhess
 *
 */

public class BlueFilter implements Filter
{
  public void filter(PixelImage pi)
  {
    int [][] blue = {{1,1,1},{1,1,1},{1,1,1}};
    int weightedSum = 10;
    String lens = "blue";
    pi.computeWeightedAverage(blue, weightedSum, lens);
  }
}