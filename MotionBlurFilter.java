/**
 * <p>applies Motion Blur filter</p>
 * @author johnglennvoorhess
 *
 */

public class MotionBlurFilter implements Filter
{
  public void filter(PixelImage pi)
  {
    int [][] motionBlur = {{2,0,0},{0,2,0},{0,0,2}};
    int weightedSum = 6;
    int strength = 12;
    for(int i=0;i<=strength;i++){
    pi.computeWeightedAverage(motionBlur, weightedSum);
    }
  }
}
/*If you double the blur factor, you must double the weight to divide.
 *Otherwise, the resulting image will be darker and subsequent
 *applications of the motion blur filter will result in an
 *increasingly darker image.  To achieve a noticeable transformation,
 *the filter is applied several times 
 *
 */