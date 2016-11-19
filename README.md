# CSC142
Assignment Four Parameters:

n this assignment, you will practice doing the following:

working with several classes (one class per file),
using loops and conditionals,
using the ArrayList class,
programming by contract.
 

Overview

The goal of this assignment is to display repetitive graphics patterns in a window.

The display part is complete and is in the class ViewWindow (The code in ViewWindow is beyond the scope of this course. You don't need to understand what it does). The window features 3 radio buttons to display 3 different patterns. It also has a command button to change the colors of the pattern which is displayed. By right clicking on a pattern, the user gets the color at the location of the click (in a popup window).

The patterns are created in the class GraphicsElements, which the class that you need to complete. The class has three methods to create three patterns: the top view of a pile of disks, a checkered board and a Sierpinski triangle (see below for more explanations). The class Graphics elements contains also other methods to modify the colors of these patterns, or to inquire about a color at a given location within a pattern.

 

Some details

The pile of disks

It is created in the method

 public 
ArrayList createAPileOfDisks()
The pile should appear as the top view of a pile of disks. The number of disks can be anywhere between 1 and NUMBER_OF_DISKS = 100. The number of disks is given by the user. To do the input, use a dialog box (method readIntDialog in uwcse.io.Input). If the user gives an invalid value, display an error message (use JOptionPane.showMessageDialog) and ask for the entry again.

The colors of the disks are randomly chosen. Make sure that the pile of disks is always as big as the window allows. Create the disks as Oval objects. Store these Ovals in an ArrayList (the larger disk at the beginning of the list) and return that list.

Below is an example

 diskpile.jpg

The method

 public ArrayList rotateColorsInPileOfDisks(ArrayList 
graphicsList)
should change the colors of the disks in the pile, so that any disk gets the color of the disk on top of it. The top disk gets the color of the bottom disk. Modify the colors of the elements of the pile of disks (available in graphicsList) and return the updated ArrayList.

The method

 public Color getColorInPileOfDisks(int x, int y, ArrayList 
graphicsList)
should return the color in the pile of disks (available in graphicsList) at location (x,y). If (x,y) is not in the pile of disks, the method should return null.

 

The checkered board

It is created in the method

 public ArrayList createACheckeredBoard()
The board has the shape of a square. The number of rows (=number of columns) can be anywhere between 1 and NUMBER_OF_ROWS = 50. The number of rows is given by the user. To do the input, use a dialog box (method readIntDialog in uwcse.io.Input). If the user gives an invalid value, display an error message (use JOptionPane.showMessageDialog) and ask for the entry again.

Adjacent squares on the board should have different colors (use only two colors). Make sure that the board is always as big as the window allows. Create the individual squares of the board as Rectangle objects. Store these Rectangles in an ArrayList and return that list.

Below is an example

checkeredboard.jpg

 

The method

 public ArrayList flipColorsInCheckeredBoard(ArrayList 
graphicsList)
should change the colors of the squares on the board to the other available color. For example, if the board is made of blue and yellow squares, a blue square should become yellow and vice versa. Update the squares of the board (available in graphicsList) and return the updated ArrayList.

The method

 public Color getColorInCheckeredBoard(int x, int y, 
ArrayList graphicsList)
should return the color on the checkered board (available in graphicsList) at location (x,y). If (x,y) is not on the board, the method should return null.

 

The Sierpinski triangle

It is created in the method

 public ArrayList createASierpinskiTriangle 
()
The triangle is created by selecting a number of points in the window. The number of points can be anywhere between 1 and NUMBER_OF_POINTS = 10000. The number of points is given by the user. To do the input, use a dialog box (method readIntDialog in uwcse.io.Input). If the user gives an invalid value, display an error message (use JOptionPane.showMessageDialog) and ask for the entry again.

The algorithm to create the triangle is the following.

Consider the three points, P1, P2 and P3 in the graphics window and a fourth point P (initially at the location of P1), as indicated in the drawing below

Step 1: Select randomly an integer equals to 1,2 or 3.
Step 2:
if that integer is1, store in the ArrayList the location of the point Q midpoint of P and P1 (in the form of a circle centered at Q of radius 1 (use the Oval class)).
if that integer is2, store in the ArrayList the location of the point Q midpoint of P and P2 (in the form of a circle centered at Q of radius 1 (use the Oval class)).
if that integer is3, store in the ArrayList the location of the point Q midpoint of P and P3 (in the form of a circle centered at Q of radius 1 (use the Oval class)).
Step 3: Select Q at the new location for P and restart from step 1 (until you have the number of points required by the user).
All of the Ovals should have the same color. When done finding all of the points, return the ArrayList

Below is an example

sierpinski_triangle.jpg 

The method

 public ArrayList changeColorsInSierpinskiTriangle (ArrayList 
graphicsList)
should change the colors of Sierpinski triangle. Switch between 3 colors (e.g. blue->red->green: if the triangle was blue, make it red, if it was red, make it green, if it was green make it blue). Update the circles of the triangle (available in graphicsList) and return the updated ArrayList.

The method

 public Color getColorInSierpinskiTriangle 
(int x, int y, ArrayList graphicsList)
should return the color of the triangle (available in graphicsList) at location (x,y). If (x,y) is not part of the triangle, the method should return null.

 

What you need to do

Complete the class GraphicsElements. You need to provide exactly the interface listed in that class.

 

Sample code

As it is, the sample code DOES compile. But code has been added so it DOES compile to get you started. Make sure you change all necessary code.

GraphicsElements.javaPreview the documentView in a new window

ViewWindow.javaPreview the documentView in a new windowView in a new window 
