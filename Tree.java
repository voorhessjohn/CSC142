import uwcse.graphics.*; // access the graphics utilities in the uw library
import java.awt.Color; // access the Color class

/**
 * <p>Create a tree with ornaments in a graphics window</p>
 * @author John Voorhess
 */   

public class Tree {

	// Instance fields
	// The graphics window this tree belongs to
	private GWindow window;
	// The location of this tree
	// (precisely (as done in the draw method), (x,y) is
	// the upper left corner of the tree trunk)
	private int x;
	private int y;
	
	// The scale used to draw this tree
	private double scale;
	
	private Triangle foliage;
	private Triangle foliageMiddle;
	private Triangle foliageTop;
	private Rectangle trunk;

	/**
	 * Create a tree
	 * @param x the x coordinate of the tree location (upper left corner of the tree trunk)
	 * @param y the y coordinate of the tree location
	 * @param window the graphics window this Tree belongs to
	 * @param scale the scale of the drawing (all default dimensions are multiplied
	 * by scale)
	 */
	public Tree(int x, int y, double scale, GWindow window)
	{
		// Initialize the instance fields (the use of this is required
		// since the instance fields have the same name as the
		// parameters of the constructor)
		this.x = x;
		this.y = y;
		this.scale = scale;
		this.window = window;
		
		this.foliage = new Triangle();
		this.foliageMiddle = new Triangle();
		this.foliageTop = new Triangle();
		this.trunk = new Rectangle();
		

		// the details of the drawing are in written in the private method draw()
		this.draw();
		//this.flashOrnaments();
	}

	public void flashOrnaments()
	{
		while(true){
		foliage.moveBy(50,-70);
		foliageMiddle.moveBy(500,0);
		foliageTop.moveBy(-20,0);
		trunk.moveBy(300,0);
		}
	}
	private void draw()
	{
		// trunk of the tree: a brown rectangle
		// (int) converts to an int 20*this scale (etc...), which is a double
		// For instance, (int)23.8 is 23
		// This is necessary since the Rectangle constructor takes integers
		Rectangle trunk = new Rectangle(x,y,(int)(20*this.scale),(int)(60*this.scale),Color.black,true);
		this.window.add(trunk);

		// Foliage (improve the drawing!)
		// a green triangle
		
		// all parameters are scaled to allow for scaling and placement in MountainScene.
		Triangle foliage = new Triangle(this.x-(int)(35*this.scale),this.y+(int)(30*this.scale),
				this.x+(int)(10*this.scale),this.y-(int)(10*this.scale),
				this.x+(int)(50*this.scale),this.y+(int)(30*this.scale),
				Color.green,true);
		
		Triangle foliageMiddle = new Triangle(this.x-(int)(35*this.scale),this.y+(int)(10*this.scale),
				this.x+(int)(10*this.scale),this.y-(int)(30*this.scale),
				this.x+(int)(50*this.scale),this.y+(int)(10*this.scale),
				Color.green,true);
		/*I have changed the shape of the triangles that comprise the tree to create a slightly more natural shape*/
		Triangle foliageTop = new Triangle(this.x-(int)(25*this.scale),this.y-(int)(10*this.scale),
				this.x+(int)(10*this.scale),this.y-(int)(50*this.scale),
				this.x+(int)(40*this.scale),this.y-(int)(10*this.scale),
				Color.green,true);
		/*The triangles above are ordered by the way that they were created, bottom first, followed by the middle and top to 
		 * make overlapping and alignment easier*/
		
		/*Small oval ornaments are created and oriented to resemble a string of lights*/
		Oval ornamentWhite = new Oval(this.x+(int)(20*scale),this.y-(int)(20*scale),(int)(5*scale),(int)(5*scale),Color.white,true);
		Oval ornamentBlue = new Oval(this.x+(int)(10*scale),this.y-(int)(10*scale),(int)(5*scale),(int)(5*scale),Color.blue,true);
		Oval ornamentRed = new Oval(x-(int)(10*scale),y+(int)(10*scale),(int)(5*scale),(int)(5*scale),Color.red,true);
		Oval ornamentYellow = new Oval(x,y,(int)(5*scale),(int)(5*scale),Color.yellow,true);
		
		
		
		
		this.window.add(foliageTop);
		this.window.add(foliageMiddle);
		this.window.add(foliage);
		//Ornament elements are added last so that they appear layered on top of the foliage triangles.
		this.window.add(ornamentBlue);
		this.window.add(ornamentRed);
		this.window.add(ornamentYellow);
		this.window.add(ornamentWhite);


		// Improve the drawing of the foliage and add the ornaments...
	}
}
