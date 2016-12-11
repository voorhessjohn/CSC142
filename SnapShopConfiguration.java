/*REPORT---------
 *Additional Filters:
 *MotionBlurFilter
 *MotionBlurFilter2
 *
 *MotionBlurFilter applies a transformation matrix with positive numbers aligned from upper left to
 *lower right (when considering the matrix as a 3x3 cube shape). I initially did not apply a scaling factor
 *and the resulting image was far too bright. One interesting discovery was that the scaling factor must
 *increase with the values applied in the matrix.
 *
 *MotionBlur2Filter reverses the location of the larger values from the MotionBlurFilter matrix and
 *results in a blur from upper right to lower left.
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
    
    // add your other filters below
  }
}
