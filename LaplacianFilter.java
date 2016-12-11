/**
 * <p>applies laplacian filter</p>
 * @author John Voorhess
 *
 */

public class LaplacianFilter implements Filter
{
  public void filter(PixelImage pi)
  {
    int [][] laplacian = {{-1,-1,-1},{-1,8,-1},{-1,-1,-1}};
    int weightedSum = 1;
    String lens = "";
    pi.computeWeightedAverage(laplacian, weightedSum, lens);
  }
}