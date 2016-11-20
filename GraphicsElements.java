import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.util.*;
import uwcse.io.*;
import uwcse.graphics.*;
import javax.swing.*;

/**
 * A class to create and manipulate graphics elements stored in an ArrayList
 * 
 * @author John Voorhess
 */

public class GraphicsElements {

	/** Maximum number of disks in a pile of disks */
	public static final int MAXIMUM_NUMBER_OF_DISKS = 100;

	/** Maximum number of rows (or columns) in a square checkered board */
	public static final int MAXIMUM_NUMBER_OF_ROWS = 50;

	/** Maximum number of points in a Sierpinski triangle */
	public static final int MAXIMUM_NUMBER_OF_POINTS = 10000;

	/** Width of the window (from ViewWindow) */
	public static final int WIDTH = ViewWindow.WINDOW_WIDTH;

	/** Height of the window (from ViewWindow) */
	public static final int HEIGHT = ViewWindow.WINDOW_HEIGHT;

	// Put your other instance fields here (if you need any)
	int hmax = HEIGHT;

	private int nr;
	
	ArrayList<Rectangle> squares = new ArrayList<Rectangle>();
	
	ArrayList<Oval> pileOfDisks = new ArrayList<Oval>();
	
	ArrayList<Oval> points = new ArrayList<Oval>();
	
	
	
	

	/**
	 * Create a top view of a pile of disks of decreasing diameters (from bottom
	 * to top). Use filled circles. The color of each disk is random. The pile
	 * should fill the window. <br>
	 * Store the circles in an ArrayList and return that ArrayList (the disk at
	 * the bottom should be the first element of the ArrayList)<br>
	 * The number of disks is given by the user (use a dialog box). If that
	 * number is less than or equal to 0 or greater than
	 * MAXIMUM_NUMBER_OF_DISKS, display an error message (use
	 * JOptionPane.showMessageDialog)and ask for it again.
	 */
	public ArrayList<Oval> createAPileOfDisks() {
		Input in = new Input();
		int N = in.readIntDialog("Enter desired number of disks (up to "+ MAXIMUM_NUMBER_OF_DISKS+")");
		while (N>MAXIMUM_NUMBER_OF_DISKS||N<=0){
			JOptionPane.showMessageDialog(null,"Enter a number between zero and "+MAXIMUM_NUMBER_OF_DISKS+".");	
			N = in.readIntDialog("Num of Rows?");
		}
		
		Random r = new Random();

		
		
		for (int i=N; i>0; i--){
			double h = ((double)hmax/(double)N*((double)i+1));
			int x = (int)((double)WIDTH/2.0-.5*((double)hmax/(double)N)*(double)(i+1));
			int y = (int)((double)HEIGHT/2.0-.5*((double)hmax/(double)N)*(double)(i+1));
			Color c= new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255));
			Oval tmp = new Oval(x,y,(int)h,(int)h,c,true);
			pileOfDisks.add(tmp);
			System.out.println(i);
			
		}
		return pileOfDisks;
		
		
		
		
		
	}

	/**
	 * Create a square checkered board. Create a Rectangle for each square on
	 * the board. Store the Rectangles in an ArrayList and return that
	 * ArrayList. Use two colors only to paint the squares.<br>
	 * The board should cover most of the window. The number of rows (=number of
	 * columns) is given by the user (use a dialog box). If that number is less
	 * than or equal to 0 or greater than MAXIMUM_NUMBER_OF_ROWS, display an
	 * error message (use JOptionPane.showMessageDialog)and ask for it again.
	 */
	/*JOptionPane.showMessageDialog(frame, "Eggs are not supposed to be green.");*/
	public ArrayList<Rectangle> createACheckeredBoard() {
		Input in = new Input();
		int nr = in.readIntDialog("Enter desired number of rows (up to "+MAXIMUM_NUMBER_OF_ROWS+")");
		while (nr>MAXIMUM_NUMBER_OF_ROWS||nr<=0){
			JOptionPane.showMessageDialog(null,"Enter a number between zero and "+MAXIMUM_NUMBER_OF_ROWS+".");	
			nr = in.readIntDialog("Enter desired number of rows (up to "+MAXIMUM_NUMBER_OF_ROWS+")");
		}		
		
		
		for (int i=0; i<nr; i++){
			for (int j=0; j<nr; j++){
				int a = HEIGHT/nr;
				int b = HEIGHT/nr;
				int x = i*a+50;
				int y = j*b;
				if(j%2==0) {
					if(i%2==0){
						Rectangle tmp = new Rectangle(x,y,a,b,Color.red,true);
						squares.add(tmp);
					}else{
						Rectangle tmp = new Rectangle(x,y,a,b,Color.blue,true);
						squares.add(tmp);
					}
				} else {
					if(i%2==0){
						Rectangle tmp = new Rectangle(x,y,a,b,Color.blue,true);
						squares.add(tmp);
					}else{
						Rectangle tmp = new Rectangle(x,y,a,b,Color.red,true);
						squares.add(tmp);
					}
				}
			}
		}
		return squares;	
	}

	/**
	 * Create a Sierpinski triangle. Create a filled Oval (circle of radius 1)
	 * for each point of the triangle. Store the Ovals in an ArrayList and
	 * return that ArrayList. Use one color only to paint the Ovals.<br>
	 * The triangle should cover most of the window.<br>
	 * The number of points is given by the user (use a dialog box). If that
	 * number is less than or equal to 0 or greater than
	 * MAXIMUM_NUMBER_OF_POINTS, display an error message (use
	 * JOptionPane.showMessageDialog)and ask for it again.
	 */
	public ArrayList<Oval> createASierpinskiTriangle() {
		
		
		Input in = new Input();
		int numberOfPoints = in.readIntDialog("Enter desired number of points (up to "+MAXIMUM_NUMBER_OF_POINTS+")");
		while (numberOfPoints>MAXIMUM_NUMBER_OF_POINTS||numberOfPoints<=0){
			JOptionPane.showMessageDialog(null,"Enter a number between zero and "+MAXIMUM_NUMBER_OF_POINTS+".");	
			numberOfPoints = in.readIntDialog("Enter desired number of points (up to "+MAXIMUM_NUMBER_OF_POINTS+")");
		}
		
		/*A GARBAGE FIRST ATTEMPT IS LEFT AS AN ARTIFACT BELOW
		if(r==1){
			Oval tmp = p1;
			points.add(tmp);
			System.out.println(r);
		}else if(r==2){
			Oval tmp = p2;
			System.out.println(r);
			points.add(tmp);
		}else if(r==3){
			Oval tmp = p3;
			System.out.println(r);
			points.add(tmp);
		}else if(r==0){
			System.out.println("Should not be zero");
		}else{
			System.out.println("something's broken");
		};
		*/
		

       
		

		/*I have stored the x and y coordinates for each of 
		*the three ordinal Ovals that determine the original
		*triangle that will be subdivided to form the final shape*/
		int p1x = WIDTH/2;
		int p1y = 0;
		int p2x = 1;
		
		
		/*the y-value of Oval p2 is equal to the HEIGHT constant minus one, 
		 * which makes it visible in the window rather than plotting it on the 
		 * border.
		 */
		int p2y = HEIGHT-1;
		/*The x-value of p3 is established as the WIDTH constant minus one,
		 * allowing it to be plotted entirely visible in the graphics window*/
		int p3x = WIDTH-1;
		/*As is the odd nature of plotting these graphics, the y-value
		 * increases as a point moves downward. To keep p3 visible, one is
		 * subtracted from the integer value of the constant, HEIGHT. Otherwise,
		 * the y-value would be equivalent to the lower border of the window*/
		int p3y = HEIGHT-1;
		
		// Oval p1 is located at the top, middle of the graphics window
		Oval p1 = new Oval(p1x,p1y,2,2,Color.blue,true);
		// Oval p2 is located at the bottom, left corner of the graphics window
        Oval p2 = new Oval(p2x,p2y,2,2,Color.blue,true);
        // Oval p3 is located at the bottom, right corner of the graphics window
        Oval p3 = new Oval(p3x,p3y,2,2,Color.blue,true);

        //an instance of the Random class is instantiated below
        Random rand = new Random();
        //The first instance of Oval p is initialized with the values of p1
        Oval p = p1;

        for (int i = 0; i < numberOfPoints; i++) {
        	/**the method nextInt of Java's Random() class takes an 
        	 * integer as a parameter and return a random value between 
        	 * zero(inclusive) and the parameter(exclusive). To change the 
        	 * return to be exclusive of zero and inclusive of the parameter,
        	 * I've added 1 to the return value and stored it as the newly-initialized 
        	 * integer randInt.
        	 */
        	
            int randInt = rand.nextInt(3) + 1;
            //integers x and y must be initialized to a value.
            int x = 0;
            int y = 0;

            if (randInt == 1) {
            	 /*If the randInt value from this iteration
            	 * is 1, the location coordinates of initial Oval p1
            	 * are stored in x and y.*/              
            	x = p1x;
                y = p1y;

            } else if (randInt == 2) {
            	/*If the randInt value from this iteration
            	 * is 2, the location coordinates of initial Oval p2
            	 * are stored in x and y.*/
                x = p2x;
                y = p2y;

            } else if (randInt == 3) {
            	/*If the randInt value from this iteration
               	 * is 3, the location coordinates of initial Oval p3
               	 * are stored in x and y.*/
                x = p3x;
                y = p3y;
            } 
            /**halfX and halfY are the coordinates of the oval q whose location
             * is to be the halfway point the coordinates of the last Oval 
             * added to the list (or p1 in the first iteration) and the 
             * coordinates of the Oval determined by randInt*/
            
          /*the halfway point of the x values is determined 
           * by adding the values and dividing the sum by 2
           */
            /**The Oval class features the methods getX and getY, 
        	 * which return the x and y values of the Oval's parameters,
        	 * the coordinates of the upper left corner of the Oval's
        	 * rectangle boundary.*/
            int halfX = (p.getX() + x) / 2;
            /*the halfway point of the y values is determined 
             * by adding the values and dividing the sum by 2
             */
            int halfY = (p.getY() + y) / 2;

            Oval q = new Oval(halfX, halfY, 2, 2, Color.blue, true);
            //add the new Oval, q, to ArrayList points
            points.add(q);            
            p = q;
          //the value of p now equals the last Oval that was added to the ArrayList
        }
		return points;
	}

	/**
	 * Rotate the colors in the pile of disks. Set the color of each disk to the
	 * color of the disk just above it. For the top disk, set its color to the
	 * color of the bottom disk (e.g. with 3 disks, if the colors are from
	 * bottom to top, red, blue, yellow, the new colors of the disks are from
	 * bottom to top, blue, yellow, red).<br>
	 * Precondition: graphicsList describes a pile of disks
	 */
	public ArrayList<Oval> rotateColorsInPileOfDisks(ArrayList<Oval> graphicsList) {
		
		Color firstDiskColor = pileOfDisks.get(0).getColor();
		for (int i = 0; i < pileOfDisks.size(); i++){
			// current disk in loop
			Oval disk = pileOfDisks.get(i);
			// use the next disk, if last disk use first ones color
			if (i < pileOfDisks.size()-1){
				// replace the color with next disk
				disk.setColor(pileOfDisks.get(i + 1).getColor());
			} else {
				disk.setColor(firstDiskColor);
			}
		}
		return graphicsList;
	}

	/**
	 * Flip the 2 colors of the checker board<br>
	 * Precondition: graphicsList describes a checkered board
	 */
	public ArrayList<Rectangle> flipColorsInCheckeredBoard(ArrayList<Rectangle> graphicsList) {
		/*Since graphicsList is populated by the ArrayList squares, 
		 *the following loop acts on the ArrayList squares. This loop
		 *starts at i=0 and pulls each rectangle at position (i) out of the list.
		 *The conditional tests the value of the color. If the color of the rectangle
		 *at position(i) is blue, it is reassigned to have the color red.
		 *in the "else" portion of the loop which catches all other cases,
		 *the only other possibility is that the rectangle at position (i)
		 *was red, therefore every rectangle that makes it to the else block
		 *is set to be blue*/
		for (int i = 0; i < squares.size(); i++) {
			if(squares.get(i).getColor()==Color.blue){
				squares.get(i).setColor(Color.red);
			}else{
				squares.get(i).setColor(Color.blue);
			};
		}
		
		return graphicsList;

	}

	/**
	 * Change the color of the Sierpinski triangle (all circles should change to
	 * the same color). Switch between 3 colors (e.g. blue->red->green, if the
	 * triangle was blue, make it red, if it was red, make it green, if it was
	 * green make it blue).<br>
	 * Precondition: graphicsList describes a Sierpinski triangle
	 */
	public ArrayList<Oval> changeColorsInSierpinskiTriangle(ArrayList<Oval> graphicsList) {

		for (int i = 0; i < points.size(); i++) {
			if(points.get(i).getColor()==Color.blue){
				points.get(i).setColor(Color.red);
			}else if(points.get(i).getColor()==Color.red){
				points.get(i).setColor(Color.green);
			}else if(points.get(i).getColor()==Color.green){
				points.get(i).setColor(Color.blue);
			}
		}
		return graphicsList;

	}

	/**
	 * Return the color at location (x,y) in the pile of disks. If (x,y) is not
	 * part of the pile of disks, return null.<br>
	 * Precondition: graphicsList describes a pile of disks
	 */
	public Color getColorInPileOfDisks(int x, int y, ArrayList<Oval> graphicsList) {

		// Add your own code here
		Color color = null;
		return color;
		
	}

	/**
	 * Return the color at location (x,y) in the checkered board. If (x,y) is
	 * not part of the board, return null.<br>
	 * Precondition: graphicsList describes a checkered board
	 */
	public Color getColorInCheckeredBoard(int x, int y, ArrayList<Rectangle> graphicsList) {

		// Add your own code here
		Color color = null;
		return color;
		
	}

	/**
	 * Return the color at location (x,y) in the Sierpinski triangle. If (x,y)
	 * is not part of the pile of disks, return null.<br>
	 * Precondition: graphicsList describes a Sierpinski triangle
	 */
	public Color getColorInSierpinskiTriangle(int x, int y, ArrayList<Oval> graphicsList) {
		
		// Add your own code here
		Color color = null;
		return color;
		
	}
}
