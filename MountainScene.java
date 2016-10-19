import uwcse.graphics.*; // access the graphics utilities in the uw library
import java.awt.Color; // access the Color class

/**
 * <p>
 * A MountainScene displays snow men, trees (with ornaments), a cable car and a
 * fourth element of your choice in a graphics window
 * </p>
 * 
 * @author John Voorhess
 */

public class MountainScene {

	/** The graphics window that displays the picture */
	private GWindow window;

	/**
	 * Create an image of a mountain scene
	 */
	public MountainScene() {

		// The graphics window
		// The window is by default 500 wide and 400 high
		this.window = new GWindow("Mountain scene",1000,700);
		this.window.setExitOnClose(); // so that a click on the close box of the
		// window terminates the application

		// Background (cyan here)
		Rectangle bgnd = new Rectangle(0, 0, window.getWindowWidth(), window.getWindowHeight(), Color.cyan, true);
		this.window.add(bgnd);

		// Create the scene elements
		// e.g. a tree in the lower left area 1.5 times the normal size
		
		Tree tree4 = new Tree(50,100,1,this.window);
		Tree tree3 = new Tree(700,200,3,this.window);
		Tree tree2 = new Tree(50,400,4,this.window);
		Tree tree1 = new Tree(300,600,4,this.window);
		
		CableCar cablecar = new CableCar(400,100,1,this.window);
		
		SnowMan snowman1 = new SnowMan(50,200,3,this.window);
		SnowMan snowman2 = new SnowMan(200,100,1,this.window);
		SnowMan snowman3 = new SnowMan(600,200,2.5,this.window);
		
		
		Star star = new Star(310,100,1,this.window);
		Star star2 = new Star(100,400,2,this.window);
		Star star3 = new Star(700,350,3,this.window);
		Star star4 = new Star(760,150,3,this.window);
		
			
	}

	/**
	 * Entry point of the program
	 */
	//Running the program.
	public static void main(String[] args) {
		new MountainScene();
	}

}
