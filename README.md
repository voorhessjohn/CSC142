# CSC142 Assignment Two

Finished.  This version will be submitted.  Code was changed from a previous version mentioned below.

PREVIOUSLY:
I am supposed to adapt my code from Assignment One to incorporate movement into MountainScene with movement functions from the uwcse graphics library.  As of this commit, nothing moves and when the individual movement methods are initialized in the public constructor of each class, only a single tree appears on the screen.

There is a conditional set up on the move() function for CableCar.  This is semi-permanently set to true for testing.  This will eventually test whether cableCar is off the screen to the left or right and reverse the direction.

I have used moveBy() as a stand-in for each movement function for testing.  I was just trying to get something to work before adapting and implementing changes to bring it to the assignment standard.

Original assignment parameters:

You did a great job in homework 1. But you are not fully happy. The picture is static. Wouldn't be it better to animate the graphics elements within the picture? You could just bring up the picture on your computer, and have the cable car move back and forth, the snowmen wave and the tree ornaments flash. That would really add some zest to your program!

Overview

In this assignment, you will reuse and modify the four classes that you wrote in homework 1, namely CableCar, SnowMan, Tree, and the fourth one that you created. I give you a new version of MountainScene that contains the code to do the animation (You don't have to understand the animation part to do this assignment. We might look at some animation later in the quarter).

What you are aked to do is to add functionalities to your classes. For instance you will add a move method to the CableCar class to move the cable car in the graphics window.

 

The details

Download the new version of MountainScene.javaPreview the documentView in a new window. Create an Eclipse project that contains MountainScene and the four element classes that you created in homework 1.

Start by modifying the code within MountainScene. There is very little to do. At the beginning of the class, create an instance field named myElement of the type that you created in homework 1 (read through the code and modify the line "private classname myElement;"). Then scroll down to the last method named addGraphicsElements. Within that method, the instance field myElement is instantiated. The statement is not complete. It reads this.myElement = new ???. Complete it.

This is it for MountainScene. Of course, you can also modify the coordinates within the constructor calls if you don't like the positioning of the elements within the window.

What you have left to do is to add methods to the other four classes (these methods are called within MountainScene to perform the animation). Here is your contract for each of the class:

CableCar class

Add one method with the following signature

public void move()

This method should move the cable car left or right by a certain distance (the exact value is up to you). If the center of the cable car is past the right edge of the screen, the cable car should reverse its direction the next time move is called. If the center of the cable car is past the left edge of the screen, the cable car should also reverse its direction the next time move is called.

A few hints: keep track in a boolean instance field, e.g. isMovingRight, whether the cable car is moving right (isMovingRight is true) or left (isMovingRight is false). Whenever the cable car is moving (i.e. whenever move is called), check if the cable car is past the right edge or the left edge of the window and modify isMovingRight accordingly (i.e. set it to true or false). To know if the cable car is past the window's right or left edge, compare the x coordinate of the cable car to 0 for the left edge and to this.window.getWindowWidth() for the right edge. Then, move the cable car by changing its x coordinate. If isMovingRight is false, subtract the distance moved in one step from x. If isMovingRight is true, add the distance to x.

Of course, changing x doesn't move the cable car on the screen. What is left to do is to move the graphics elements making up the cable car. Use for this the moveBy method on each one of the graphics elements (rectangles...) of your cable car. Make sure that you have access to these elements within your move method. You will need to make these graphics elements instance fields, since most likely, you defined them as local variables within draw() for homework 1.

 

SnowMan class

Add one method with the following signature

public void moveArmsAndHat()


moveArmsAndHat should move the hat and the arms of the snowman up and down. If the hat and arms are up, moveArmsAndHat move them down. If they are down, moveArmsAndHat move them up. As for the CableCar class, you might want to use a boolean variable to know if the arms and hat are up or down. To move the graphics elements, you can use the methods moveBy (for the hat) and rotateAround (for the arms).


Tree class

Add one method with the following signature

public void flashOrnaments()

This method should change randomly the colors of the tree ornaments (use setColor). To generate random colors use the Color constructor Color(int r, int g, int b) with random integers for r, g and b (between 0 and 255). The class java.util.Random is helpful to generate random numbers . Check it out.

 

Your class (that is the class for the fourth type that you created in homework 1)

Add one method with the following signature

public void doAction()

What this method does is up to you. The only requirement is that it should do something different from what was done with the other elements. For instance, don't just change the color. But, it could spin, or open and close its mouth (if it has one), etc...
