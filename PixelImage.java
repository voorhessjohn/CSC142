import java.awt.image.*;

/**
 * Provides an interface to a picture as an array of Pixels
 */
public class PixelImage
{
  private BufferedImage myImage;
  private int width;
  private int height;

  /**
   * Map this PixelImage to a real image
   * @param bi The image
   */
  public PixelImage(BufferedImage bi)
  {
    // initialize instance variables
    this.myImage = bi;
    this.width = bi.getWidth();
    this.height = bi.getHeight();
  }

  /**
   * Return the width of the image
   */
  public int getWidth()
  {
    return this.width;
  }

  /**
   * Return the height of the image
   */
  public int getHeight()
  {
    return this.height;
  }

  /**
   * Return the BufferedImage of this PixelImage
   */
  public BufferedImage getImage()
  {
    return this.myImage;
  }

  /**
   * Return the image's pixel data as an array of Pixels.  The
   * first coordinate is the x-coordinate, so the size of the
   * array is [width][height], where width and height are the
   * dimensions of the array
   * @return The array of pixels
   */
  public Pixel[][] getData()
  {
    Raster r = this.myImage.getRaster();
    Pixel[][] data = new Pixel[r.getHeight()][r.getWidth()];
    int[] samples = new int[3];

    for (int row = 0; row < r.getHeight(); row++)
    {
      for (int col = 0; col < r.getWidth(); col++)
      {
        samples = r.getPixel(col, row, samples);
        Pixel newPixel = new Pixel(samples[0], samples[1], samples[2]);
        data[row][col] = newPixel;
      }
    }

    return data;
  }

  /**
   * Set the image's pixel data from an array.  This array matches
   * that returned by getData().  It is an error to pass in an
   * array that does not match the image's dimensions or that
   * has pixels with invalid values (not 0-255)
   * @param data The array to pull from
   */
  public void setData(Pixel[][] data)
  {
    int[] pixelValues = new int[3];     // a temporary array to hold r,g,b values
    WritableRaster wr = this.myImage.getRaster();

    if (data.length != wr.getHeight())
    {
      throw new IllegalArgumentException("Array size does not match");
    }
    else if (data[0].length != wr.getWidth())
    {
      throw new IllegalArgumentException("Array size does not match");
    }

    for (int row = 0; row < wr.getHeight(); row++)
    {
      for (int col = 0; col < wr.getWidth(); col++)
      {
        pixelValues[0] = data[row][col].red;
        pixelValues[1] = data[row][col].green;
        pixelValues[2] = data[row][col].blue;
        wr.setPixel(col, row, pixelValues);
      }
    }
  }
  /**
   * Computes images from weighted average
   * @param data The array to pull from
   * @param input array
   * @param weighted sum
   */
  // add a method to compute a new image given weighted averages
  public void computeWeightedAverage(int[][] input, int weightedSum) 
  {
	  Pixel[][] oldimage = this.getData();
	  Pixel[][] image = this.getData();
	  for(int row=1; row<this.height-1; row++){
		  for(int col=1; col<this.width-1; col++)
		  {
			  Pixel[][] imageArray = new Pixel[3][3];
			  for(int i=-1; i<2; i++){
				  for(int j=-1; j<2; j++){
					  imageArray[i+1][j+1]=oldimage[row+i][col+j];
				  }
			  }
			  image[row][col] = multiplyArrays(input,imageArray,weightedSum);
		  }
		  this.setData(image);
	  }
  }
  
  /**
   * multiplies two square matrices of the same size (e.g. 3x3)
   * @param int[][] array matrix
   * @param Pixel[][] array matrix
   * @param Pixel weighted sum
   * @return Pixel averaged Pixed Value
   */
  public Pixel multiplyArrays(int[][] array, Pixel[][] imageArray, int weightedSum)
  {
	  int sumRed = 0;
	  int sumGreen = 0;
	  int sumBlue = 0;
	  
	  for(int i=0; i<3; i++)
	  {
		  for(int j=0; j<3; j++)
		  {
			  sumRed += array[i][j]*imageArray[i][j].red;
			  sumGreen += array[i][j]*imageArray[i][j].green;
			  sumBlue += array[i][j]*imageArray[i][j].blue;
		  }
	  }
	  sumRed /= weightedSum;
	  sumGreen /= weightedSum;
	  sumBlue /= weightedSum;
	  Pixel sum = new Pixel(sumRed,sumGreen,sumBlue);
	  return sum;
  }
}
