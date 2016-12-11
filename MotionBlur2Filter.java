/**
 * <p>applies a motion blur filter opposite of MotionBlurFilter</p>
 * @author John Voorhess
 *
 */

public class MotionBlur2Filter implements Filter
{
  public void filter(PixelImage pi)
  {
    int [][] motionBlur2 = {{0,0,2},{0,2,0},{2,0,0}};
    int weightedSum = 6;
    int strength = 12;
    String lens = "";
    for(int i=0;i<=strength;i++){
    pi.computeWeightedAverage(motionBlur2, weightedSum, lens);
    }
  }
}
/*If you double the blur factor, you must double the weight to divide.
 *Otherwise, the resulting image will be darker and subsequent
 *applications of the motion blur filter will result in an
 *increasingly darker image.  To achieve a noticeable transformation,
 *the filter is applied several times, determined by the value of int 
 *variable, strength.
 *
 */