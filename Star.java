import uwcse.graphics.*; // access the graphics utilities in the uw library
import java.awt.Color; // access the Color class

/**
 * <p>Create a star  in a graphics window</p>
 * @author John Voorhess
 */   

public class Star {

	// Instance fields
	// The graphics window this star belongs to
	private GWindow window;
	
	// The location of this star
	private int x;
	private int y;
	
	// The scale used to draw this tree
	private double scale;
	private Triangle starUp;
	private Triangle starDown;

	/**
	 * Create a star
	 * @param x the x coordinate of the star location 
	 * @param y the y coordinate of the star location
	 * @param window the graphics window this star belongs to
	 * @param scale the scale of the drawing (all default dimensions are multiplied
	 * by scale)
	 */
	public Star(int x, int y, double scale, GWindow window)
	{
		// Initialize the instance fields (the use of this is required
		// since the instance fields have the same name as the
		// parameters of the constructor)
		this.x = x;
		this.y = y;
		this.scale = scale;
		this.window = window;
		this.starUp = new Triangle();
		this.starDown = new Triangle();

		// the details of the drawing are in written in the private method draw()
		this.draw();
		this.doAction();
	}

	public void doAction()
	{
		starUp.moveBy(-50,0);
		starDown.moveBy(-50,0);
	}
	private void draw()
	{
		Triangle starUp = new Triangle
				(x+(int)(22*scale),
				y+(int)(84*scale),
				x+(int)(14*scale),
				y+(int)(100*scale),
				x+(int)(33*scale),
				y+(int)(100*scale),
				Color.yellow,true);
		
		/*I tried to lay out the triangle code in a way that would allow me to reference the values of one triangle to place the
		 * vertex coordinates of the next.  This method worked well*/
		
		Triangle starDown = new Triangle
				(x+(int)(14*scale),
				y+(int)(90*scale),
				x+(int)(33*scale),
				y+(int)(90*scale),
				x+(int)(22*scale),
				y+(int)(106*scale),
				Color.yellow,true);
		
		this.window.add(starUp);
		this.window.add(starDown);


		
	}
}
