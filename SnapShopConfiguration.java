/*REPORT---------
 *Additional Filters:
 *MotionBlurFilter
 *MotionBlurFilter2
 *EmbossFilter
 *BrightFilter
 *RedFilter (Rage Mode)
 *GreenFilter (Green is for the Money)
 *BlueFilter (Feeling Blue?)
 *
 *MotionBlurFilter applies a transformation matrix with positive numbers aligned from upper left to
 *lower right (when considering the matrix as a 3x3 cube shape). I initially did not apply a scaling factor
 *and the resulting image was far too bright. One interesting discovery was that the scaling factor must
 *increase with the values applied in the matrix.
 *
 *MotionBlur2Filter reverses the location of the larger values from the MotionBlurFilter matrix and
 *results in a blur from upper right to lower left.
 *
 *One interesting thing that popped up is that if you double the blur factor, you must double the weight to divide.
 *Otherwise, the resulting image will be darker and subsequent applications of the motion blur filter will result in an
 *increasingly darker image.  To achieve a noticeable transformation, the filter is applied several times 
 *
 *EmbossFilter applies negative values in the upper left corner of the matrix and positive values in the 
 *lower right corner.  One thing that surprised me at this point was that that values in the Emboss matrix
 *are roughly representative of the transformation that it will apply.  Similar to the MotionBlur effects,
 *you can get a mental image of what will happen based on the location of the values in the matrix.
 *
 *BrightFilter applies positive values to the entire matrix and dials the transformation back by dividing the resulting
 *int values by 16.  The effect can be increased by reducing the divisor, but the same effect is acheived by hitting the 
 *button twice
 *
 *RedFilter --- I modified the transformation methods in PixelImage.java to take an additional parameter, a String,
 *that is used to switch the red channel all the way up to 255 every time a new value is inserted into the 
 *Pixel[][] image. Originally, I used a boolean value for the same purpose but changed it to a string so it would be 
 *useful for more than a single transformation.  I called it Rage Mode to pay homage to my fond memories of getting
 *ten copied floppy disks from a friend to install Wolfenstein3D when I was ten years old.
 *
 *GreenFilter and BlueFilter--- Since I changed the way that I did the RedFilter to accommodate other string values, I figured that 
 *I should demonstrate the increased functionality.
 *
 *WHAT WORKS:
 *everything(*)
 *
 *Everything works, but there is a curious effect that happens with the UnsharpFilter. When applied,
 *the resulting image is dotted with pure red(something close to (255,0,0) pixels), pure green, and
 *pure blue dots.  
 *My theory was that while converting out-of-bounds values I had created some pixels
 *that were (0,0,255) or (255,0,0) or (0,255,0).
 *I attempted to filter these out with a series of if statements (please see lines ***
 *to *** in PixelImage.java), but it did not seem to make any difference. I left it in there because 
 *it didn't seem to be causing any problems.  I understand that if this was to be a finished product,
 *running every transformation through that if block would take too much time if it wasn't doing anything.
 **/

/**
 * A class to configure the SnapShop application
 *
 * @author John Voorhess
 * @version 12/10/2016
 */
public class SnapShopConfiguration
{
  /**
   * Method to configure the SnapShop.  Call methods like addFilter
   * and setDefaultFilename here.
   * @param theShop A pointer to the application
   */
  public static void configure(SnapShop theShop)
  {

    theShop.setDefaultFilename("/Users/johnglennvoorhess/Downloads/billg.jpg");
    theShop.addFilter(new FlipHorizontalFilter(), "Flip Horizontal");
    theShop.addFilter(new FlipVerticalFilter(), "Flip Vertical");
    theShop.addFilter(new NegativeFilter(), "Negative");
    theShop.addFilter(new GaussianFilter(), "Gaussian");
    theShop.addFilter(new LaplacianFilter(), "Laplacian");
    theShop.addFilter(new UnsharpFilter(), "Unsharp");
    theShop.addFilter(new EdgyFilter(), "Edgy");
    theShop.addFilter(new MotionBlurFilter(), "Motion Blur (wait for it...)");
    theShop.addFilter(new MotionBlur2Filter(), "Motion Blur (opposite direction)");
    theShop.addFilter(new EmbossFilter(), "Emboss");
    theShop.addFilter(new BrightFilter(), "Brighten");
    theShop.addFilter(new RedFilter(), "Rage Mode");
    theShop.addFilter(new GreenFilter(), "Green is for the Money");
    theShop.addFilter(new BlueFilter(), "Feeling Blue?");
    
    // add your other filters below
  }
}
