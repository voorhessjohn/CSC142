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
		int N = in.readIntDialog("Num of Disks?");
		
		Random r = new Random();
		
		

		ArrayList<Oval> pileOfDisks = new ArrayList<Oval>();
		
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
		int nr = in.readIntDialog("Enter desired number of rows (up to fifty)");
		while (nr>MAXIMUM_NUMBER_OF_ROWS||nr<=0){
			JOptionPane.showMessageDialog(null,"Enter a number between zero and "+MAXIMUM_NUMBER_OF_ROWS+".");	
			nr = in.readIntDialog("Num of Rows?");
		}
		
		
			
		ArrayList<Rectangle> squares = new ArrayList<Rectangle>();
		
		
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

		// Add your own code here
		ArrayList<Oval> points = new ArrayList<Oval>();
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

		// Add your own code here
		return graphicsList;
	}

	/**
	 * Flip the 2 colors of the checkboard<br>
	 * Precondition: graphicsList describes a checkered board
	 */
	public ArrayList<Rectangle> flipColorsInCheckeredBoard(ArrayList<Rectangle> graphicsList) {
		
		// Add your own code here
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

		// Add your own code here
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
