/**
 * <p>applies Laplacian filter</p>
 * @author johnglennvoorhess
 *
 */

public class LaplacianFilter implements Filter
{
  public void filter(PixelImage pi)
  {
    int [][] laplacian = {{-1,-1,-1},{-1,8,-1},{-1,-1,-1}};
    int weightedSum = 1;
    pi.computeWeightedAverage(laplacian, weightedSum);
  }
}