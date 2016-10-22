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
	private Line leftDiagCable;
	private Line rightDiagCable;
	
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
		this.leftDiagCable = new Line();
		this.rightDiagCable = new Line();
		
		this.isMovingRight = true;
		
		
		

		// The details of the drawing are in a private method
		this.draw();
		//this.move();

	}
	
	

	public void move()
	{
		if (isMovingRight){
			car.moveBy(50,0);
			leftWindow.moveBy(-50,0);
			rightWindow.moveBy(-50,0);
			rightDiagCable.moveBy(-50,0);
			leftDiagCable.moveBy(-50,0);
				}
		else{
			car.moveBy(-5,0);
			leftWindow.moveBy(-5,0);
			rightWindow.moveBy(-5,0);
			rightDiagCable.moveBy(-5,0);
			leftDiagCable.moveBy(-5,0);
		}
			
	}

	/** Draw a cable car at location (x,y) */
	// To draw cable car, using private drawing method.
	private void draw()
	{ 
		//drawing cable car and its lines by using rectangles and lines from the library.
		
		/*I have found that aligning the parameters while laying out these visual elements allows
		 * me to reference values of similar elements to aid in placement.  I have used this system 
		 * with several parts of this project.*/
		//The cable element of CableCar.java is created with several rectangles from the uwcse graphics jar.
		//Rectangle car is the body of the car
		Rectangle car = new Rectangle(x+(int)(4*scale),
									  y+(int)(61*scale),
									  (int)(300*scale),
									  (int)(150*scale),
									  Color.blue,true);
		//Rectangle leftWindow is the left window of the car
		Rectangle leftWindow = new Rectangle(x+(int)(10*scale),
											 y+(int)(71*scale),
											 (int)(140*scale),
											 (int)(90*scale),
											 Color.white,true);
		//Rectangle rightWindow is the right window of the car
		Rectangle rightWindow = new Rectangle(x+(int)(160*scale),
											  y+(int)(71*scale),
											  (int)(140*scale),
											  (int)(90*scale),
											  Color.white,true);
		
		/*I have created the cable with the Line shape from the uwcse graphics jar*/
		//Line topCable is the line that stretches across the whole graphics window
		//Line leftDiagCable is the left side of the rigging that suspends the cable car
		//Line rightDiagCable is the right side of the rigging that suspends the cable car
		Line topCable = new Line(x-(int)(400*scale),y+(int)(10*scale),
								 x+(int)(800*scale),y+(int)(10*scale),Color.black);
		Line leftDiagCable = new Line(x+(int)(2*scale),y+(int)(61*scale),
									  x+(int)(150*scale),y+(int)(10*scale),Color.black);
		Line rightDiagCable = new Line(x+(int)(300*scale),y+(int)(60*scale),
									   x+(int)(150*scale),y+(int)(10*scale),Color.black);
		
		//adding the rectangles and lines on the window.
		window.add(car);
		window.add(leftWindow);
		window.add(rightWindow);
		window.add(topCable);
		window.add(leftDiagCable);
		window.add(rightDiagCable);

	}

}
