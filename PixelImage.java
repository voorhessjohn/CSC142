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
   * @param input array
   * @param weighted sum
   */
  // add a method to compute a new image given weighted averages
  public void computeWeightedAverage(int[][] input, int weightedSum, String lens) 
  {
	  /*two Pixel arrays are initialized. Both are given the data from
	   * the loaded image to be sure that both are the same size
	  */
	  Pixel[][] oldimage = this.getData();
	  Pixel[][] image = this.getData();
	  /*The following nested loop creates a 3x3 array of values
	   * from oldimage to which the transformation will be applied
	   */
	  for(int row=1; row<this.height-1; row++){
		  for(int col=1; col<this.width-1; col++)
		  {
			  Pixel[][] imageArray = new Pixel[3][3];
			  for(int i=-1; i<2; i++){
				  for(int j=-1; j<2; j++){
					  imageArray[i+1][j+1]=oldimage[row+i][col+j];
				  }
			  }
			  /*Once imageArray is populated with the corresponding data from oldimage,
			   * imageArray is sent out to be transformed by the method, multiplyArrays,
			   * which takes the input array(the matrix of transformation values), the 
			   * new 3x3 imageArray created in the loop, and the weightedSum value that
			   * is used to scale the colors back from crazytown.*/
			  image[row][col] = multiplyArrays(input,imageArray,weightedSum, lens);
		  }
		  /*The resulting values from the transformation are stored in the 2d Pixel array
		   * called "image"
		   */
		  this.setData(image);
	  }
  }
  
  /**
   * multiplies two square matrices of the same size (e.g. 3x3)
   * @param int[][] array matrix
   * @param Pixel[][] array matrix
   * @param int weighted sum
   * @param String
   * @return Pixel averaged Pixel Value
   */
  public Pixel multiplyArrays(int[][] array, Pixel[][] imageArray, int weightedSum, String lens)
  {
	  //initialize integer variables for each color channel in Pixel
	  int sumRed = 0;
	  int sumGreen = 0;
	  int sumBlue = 0;
	  //The outer for loop iterates over the rows
	  for(int i=0; i<3; i++)
	  {
		  //the inner for loop iterates over each column in the row
		  for(int j=0; j<3; j++)
		  {
			  /*the values of the red, green, and blue channels of
			   * Pixel[][] imageArray are multiplied by the value
			   * of the int from "array" at [i][j]. These values
			   * are stored in corresponding int variables sumRed,
			   *sumGreen, and sumBlue
			   */
			  sumRed += array[i][j]*imageArray[i][j].red;
			  sumGreen += array[i][j]*imageArray[i][j].green;
			  sumBlue += array[i][j]*imageArray[i][j].blue;
		  }
	  }
	  /*this if block applies the weighted sum only if the resulting value is
	  *between 0 and 255. Otherwise, the value of sumRed is set to 0 or 255.
	  */
	  if((sumRed / weightedSum)>0 && (sumRed / weightedSum)<255){
		  sumRed /= weightedSum;
	  }else if((sumRed / weightedSum)<0){
		  sumRed = 0;
	  }else if((sumRed / weightedSum)>255){
		  sumRed = 255;
	  }
	  /*this if block applies the weighted sum only if the resulting value is
		  *between 0 and 255. Otherwise, the value of sumGreen is set to 0 or 255.
		  */
	  if((sumGreen / weightedSum)>0 && (sumGreen / weightedSum)<255){
		  sumGreen /= weightedSum;
	  }else if((sumGreen / weightedSum)<0){
		  sumGreen = 0;
	  }else if((sumGreen / weightedSum)>255){
		  sumGreen = 255;
	  }
	  /*this if block applies the weighted sum only if the resulting value is
		  *between 0 and 255. Otherwise, the value of sumBlue is set to 0 or 255.
		  */
	  if((sumBlue / weightedSum)>0 && (sumBlue / weightedSum)<255){
		  sumBlue /= weightedSum;
	  }else if((sumBlue / weightedSum)<0){
		  sumBlue = 0;
	  }else if((sumBlue / weightedSum)>255){
		  sumBlue = 255;
	  }
	  /*The following if block is my attempt at filtering out the red, green,
	   * and blue dots that appear after running UnsharpFilter
	   * */
	  if((sumRed > 220) && (sumGreen < 20)&&(sumBlue < 20)){
		  sumRed=0;
		  sumGreen=0;
		  sumBlue=0;
	  }else if((sumRed < 20) && (sumGreen > 220)&&(sumBlue < 20)){
		  sumRed=0;
		  sumGreen=0;
		  sumBlue=0;
	  }else if((sumRed < 20) && (sumGreen < 20)&&(sumBlue > 220)){
		  sumRed=0;
		  sumGreen=0;
		  sumBlue=0;
	  }
	  if(lens=="red"){
		  sumRed = 255;
		  Pixel sum = new Pixel(sumRed,sumGreen,sumBlue);
		  return sum;
	  }else if(lens=="green"){
		  sumGreen = 255;
		  Pixel sum = new Pixel(sumRed,sumGreen,sumBlue);
		  return sum;
	  }else if(lens=="blue"){
		  sumBlue = 255;
		  Pixel sum = new Pixel(sumRed,sumGreen,sumBlue);
		  return sum;
	  }else{
	  //the three color channels of a new Pixel, called sum are stored.
		  Pixel sum = new Pixel(sumRed,sumGreen,sumBlue);
		  return sum;
	  }
	  
	  
  }
}

