import uwcse.graphics.*; // access the graphics utilities in the uw library
import java.awt.Color; // access the Color class


/**
 * <p>Create a cable car in a graphics window</p>  
 * @author John Voorhess
 */

public class CableCar {

	// Your instance fields go here
	private GWindow window;
	
	private int x;
	private int y;
	
	private double scale;
	private Rectangle car;
	private Rectangle leftWindow;
	private Rectangle rightWindow;
	private boolean isMovingRight;


	/**
	 * Create a cable car at location (x,y) in the GWindow window.
	 * @param x the x coordinate of the center of the cable car
	 * @param y the y coordinate of the center of the cable car
	 * @scale the factor that multiplies all default dimensions for this cable car
	 * (e.g. if the default size is 80, the size of this cable car is
	 * scale * 80)
	 * @window the graphics window this cable car belongs to
	 */
	public CableCar(int x, int y, double scale, GWindow window)
	{    
		// initialize the instance fields
		this.x = x;
		this.y = y;
		this.scale = scale;
		this.window = window;
		this.car = new Rectangle();
		this.leftWindow = new Rectangle();
		this.rightWindow = new Rectangle();
		this.isMovingRight = true;
		
		

		// The details of the drawing are in a private method
		this.draw();
		this.move();

	}
	
	

	public void move()
	{
		if (isMovingRight){
			car.moveBy(5,0);
			leftWindow.moveBy(5,0);
			rightWindow.moveBy(5,0);
				}
		else{
			car.moveBy(-5,0);
			leftWindow.moveBy(-5,0);
			rightWindow.moveBy(-5,0);
		}
			
	}
