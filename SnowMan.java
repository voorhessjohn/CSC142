import uwcse.graphics.*; // access the graphics utilities in the uw library
import java.awt.Color; // access the Color class

/**
 * <p>Create a snow man in a graphics window</p>
 * @author John Voorhess
 */  

public class SnowMan {

	// Your instance fields go here
	private GWindow window;

	private int x;
	private int y;

	private double scale;
	private Rectangle bottomHat;
	private Rectangle topHat;
	private Line leftArm ;
	private Line leftTopFinger; 
	private Line leftBottomFinger; 
	private Line rightArm; 
	private Line rightTopFinger; 		
	private Line rightBottomFinger;
	private boolean isMovingUp;
	private int counter;

	/**
	 * Create a snow man in at location (x,y) in the GWindow window.
	 * @param x the x coordinate of the center of the head of the snow man
	 * @param y the y coordinate of the center of the head of the snow man
	 * @scale the factor that multiplies all default dimensions for this snow man
	 * (e.g. if the default head radius is 20, the head radius of this snow man is
	 * scale * 20)
	 * @window the graphics window this snow man belongs to
	 */
	//Defining the variables so that they can be used anywhere in this class.
	public SnowMan(int x, int y, double scale, GWindow window)
	{  
		// the details of the drawing are in written in the private method draw()
		// initialize the instance fields
		this.x = x;
		this.y = y;
		this.scale = scale;
		this.window = window;
		this.bottomHat = new Rectangle();
		this.topHat = new Rectangle();
		this.leftArm = new Line();
		this.leftTopFinger = new Line();
		this.leftBottomFinger = new Line();
		this.rightArm = new Line();
		this.rightTopFinger = new Line();	
		this.rightBottomFinger = new Line();
		this.isMovingUp = true;
		this.counter = 1;

		// Put the details of the drawing in a private method
		this.draw();
		this.moveArmsAndHat();

	}
	/*rotateAround is HARD! I used moveBy() since you mentioned that it would be an acceptable alternative to 
	 * rotateAround. I was able to create an animation with rotateAround, but the result was as if the arms and 
	 * fingers of the snowmen would fly off of their bodies randomly and reassemble, seemingly out of nowhere.  
	 * I'm sure that with more time I would be able to figure it out. */
	public void moveArmsAndHat()
	{
		
		if (isMovingUp && this.y>190){
			isMovingUp = false;
		}
		
		if (isMovingUp==false && this.y<190){
			isMovingUp = true;
		}
		//The counters below are not used anymore.  They are an artifact of an earlier attempt at a solution.
		if(isMovingUp){
			this.y += 20;
			bottomHat.moveBy(0,20);
			topHat.moveBy(0,20);
			leftArm.moveBy(0,20);
			leftTopFinger.moveBy(0,20); 
			leftBottomFinger.moveBy(0,20); 
			rightArm.moveBy(0,20); 
			rightTopFinger.moveBy(0,20); 		
			rightBottomFinger.moveBy(0,20);
//			counter -= 2;
		}
		
		else{
			this.y -= 20;
			bottomHat.moveBy(0,-20);
			topHat.moveBy(0,-20);
			leftArm.moveBy(0,-20);
			leftTopFinger.moveBy(0,-20); 
			leftBottomFinger.moveBy(0,-20); 
			rightArm.moveBy(0,-20); 
			rightTopFinger.moveBy(0,-20); 		
			rightBottomFinger.moveBy(0,-20);
//			counter +=1;
			
		}
		
		
		
	}

	/** Draw in the graphics window a snow man at location (x,y) */
	// drawing the details in a private method. 
	private void draw()
	{
		// Draw the objects
		
		/*I have created all of the Oval elements first. Doing so allowed me to align each based on the previous.*/
		
		Oval bottomBall = new Oval(x-(int)(10*scale),y+(int)(100*scale),(int)(50*scale),(int)(50*scale),Color.white,true);
		Oval middleBall = new Oval(x-(int)(0*scale),y+(int)(75*scale),(int)(30*scale),(int)(30*scale),Color.white,true);
		Oval topBall = new Oval(x+(int)(7*scale),y+(int)(61*scale),(int)(15*scale),(int)(15*scale),Color.white,true);
		Oval leftEye = new Oval(x+(int)(9*scale),y+(int)(65*scale),(int)(3*scale),(int)(3*scale),Color.black,true);
		Oval rightEye = new Oval(x+(int)(16*scale),y+(int)(65*scale),(int)(3*scale),(int)(3*scale),Color.black,true);
		Oval topMouth = new Oval(x+(int)(12*scale),y+(int)(68*scale),(int)(5*scale),(int)(5*scale),Color.white,true);
		Oval bottomMouth = new Oval(x+(int)(12*scale),y+(int)(70*scale),(int)(5*scale),(int)(5*scale),Color.black,true);
		Oval topButton = new Oval(x+(int)(12*scale),y+(int)(80*scale),(int)(5*scale),(int)(5*scale),Color.black,true);
		Oval middleButton = new Oval(x+(int)(12*scale),y+(int)(90*scale),(int)(5*scale),(int)(5*scale),Color.black,true);
		Oval bottomButton = new Oval(x+(int)(12*scale),y+(int)(100*scale),(int)(5*scale),(int)(5*scale),Color.black,true);
		
		/*Next, the lines for arms are drawn. 
		 * The naming convention makes it easier to align the finger points to the arms */
		this.leftArm = new Line(x+(int)(7*scale),y+(int)(80*scale),x+(int)(-13*scale),y+(int)(80*scale),Color.black);
		this.leftTopFinger = new Line(x+(int)(-7*scale),y+(int)(80*scale),x+(int)(-13*scale),y+(int)(76*scale),Color.black);
		this.leftBottomFinger = new Line(x+(int)(-7*scale),y+(int)(80*scale),x+(int)(-13*scale),y+(int)(84*scale),Color.black);
		this.rightArm = new Line(x+(int)(23*scale),y+(int)(80*scale),x+(int)(45*scale),y+(int)(80*scale),Color.black);
		this.rightTopFinger = new Line(x+(int)(37*scale),y+(int)(80*scale),x+(int)(45*scale),y+(int)(76*scale),Color.black);
		this.rightBottomFinger = new Line(x+(int)(37*scale),y+(int)(80*scale),x+(int)(45*scale),y+(int)(84*scale),Color.black);
		
		/*The rectangle elements of the hat are created next. 
		 * I initially used the parameters of the topBall to align the bottom rectangle of the hat*/
		this.bottomHat = new Rectangle(x+(int)(4*scale),y+(int)(61*scale),(int)(21*scale),(int)(3*scale),Color.black,true);
		this.topHat = new Rectangle(x+(int)(10*scale),y+(int)(51*scale),(int)(10*scale),(int)(10*scale),Color.black,true);
		
		/*The triangle nose was easiest aligned to the mouth in the Oval elements above. 
		 * From there, it was a matter of stretching one set of coordinates to stretch it into the shape of a carrot*/
		Triangle carrotNose = new Triangle(x+(int)(14*scale),
										y+(int)(68*scale),
										x+(int)(14*scale),
										y+(int)(70*scale),
										x+(int)(25*scale),
										y+(int)(68*scale),
										Color.orange,true);
		
		
		// add them to the window
		/*The elements are then added to the image 
		 * in the order that they must be layered, from bottom layer to top layer*/
		this.window.add(bottomBall);
		this.window.add(middleBall);
		this.window.add(topBall);
		this.window.add(leftEye);
		this.window.add(rightEye);
		
		this.window.add(bottomMouth);
		this.window.add(topMouth);
		this.window.add(topButton);
		this.window.add(middleButton);
		this.window.add(bottomButton);
		
		this.window.add(leftArm);
		this.window.add(leftTopFinger);
		this.window.add(leftBottomFinger);
		this.window.add(rightArm);
		this.window.add(rightTopFinger);
		this.window.add(rightBottomFinger);
		this.window.add(bottomHat);
		this.window.add(topHat);
		this.window.add(carrotNose);
		/*I think that if I knew a little better about what I was doing, I would try to write separate private methods for
		 * drawing the body, the arms, the hat, and the buttons, then adding those to the method that draws SnowMan.
		 * I would think that solution would be more elegant than what I've created, but maybe trying to make that 
		 * work this time would be too ambitious.*/

	}
}
