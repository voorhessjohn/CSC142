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
	
	private boolean isMovingUp;
	private boolean isMovingRight;

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
		this.isMovingUp = true;
		this.isMovingRight = true;

		// the details of the drawing are in written in the private method draw()
		this.draw();
		this.doAction();
	}
	/*The code below is a separate animation intended to be different from the other ones implemented and tidy at the 
	 * same time.  I chose to combine x- and y- movement to make a "squiggly"- motioned star which is also limited so as
	 * to travel roughly within the bounds of the GWindow.*/
	public void doAction()
	{
		/*I have used -200 as the boundary for the y variable so that the star does not stray too far above or below
		this particular spot*/
		if (isMovingUp && this.y>-200) {
			isMovingUp = false;
		}
		
		if (isMovingUp==false && this.y<-200) {
			isMovingUp = true;
		}
		/*Implementation for the x boundary is similar to the method that moves the cable car*/
		if (isMovingRight && this.x>this.window.getWindowWidth()) {
			isMovingRight = false;
		}
		
		if (isMovingRight==false && this.x<0) {
			isMovingRight = true;
		}
		
		/*I have left some garbage artifacts below to show how the solution has evolved. 
		 * I wrote this method immediately after Tuesday's class when I got help from my instructor.*/
		if(isMovingUp){
			this.y+=20;
			//this.x+=20;
			starUp.moveBy(0,20);
			starDown.moveBy(0,20);
		}
		if(isMovingUp==false){
			this.y-=20;
			//this.x+=20;
			starUp.moveBy(0,-20);
			starDown.moveBy(0,-20);
		}
		if(isMovingRight){
			//this.y+=20;
			this.x+=30;
			starUp.moveBy(30,0);
			starDown.moveBy(30,0);
		}
		if(isMovingRight==false){
			//this.y+=20;
			this.x-=30;
			starUp.moveBy(-30,0);
			starDown.moveBy(-30,0);
		}
	}
	private void draw()
	{
		this.starUp = new Triangle
				(x+(int)(22*scale),
				y+(int)(84*scale),
				x+(int)(14*scale),
				y+(int)(100*scale),
				x+(int)(33*scale),
				y+(int)(100*scale),
				Color.yellow,true);
		
		/*I tried to lay out the triangle code in a way that would allow me to reference the values of one triangle to place the
		 * vertex coordinates of the next.  This method worked well*/
		
		this.starDown = new Triangle
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
