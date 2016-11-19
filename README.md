# CSC142
Assignment One

Parameters:
Winter is here. This is the time to head for the mountains and have some fun making snow men, taking walks among trees, or riding a cable car up a mountain. Unfortunately, this class doesn't incluce such a field trip! But we can still get a taste of the mountains by drawing a mountain scene with a Java program.

Overview
In this project, you will complete several classes to draw a picture in a graphics window. The purpose of this assignment is to give you experience writing classes in Java and using Eclipse.

To do
Download the four files CableCar.javaPreview the documentView in a new window, MountainScene.javaPreview the documentView in a new window, SnowMan.javaPreview the documentView in a new window and Tree.javaPreview the documentView in a new window include them in an Eclipse project (as we did in class). Run the program by clicking the Run button with the class MountainScene selected. You should get a window with a triangle and a rectangle in the lower left area (this is the beginning of the drawing of a tree with ornaments). Read through the code of MountainScene and Tree. You will see that when MountainScene is instantiated, a graphics window is created. Then a Tree object is created. As it is, the draw method of the Tree class puts a rectangle and a triangle in the graphics window. Make sure that you understand how this is happening within the code.

None of the classes given to you are complete. Your assignment is to complete the four classes and create a fith class so that an instance of MountainScene appears as a picture containing four different moutain elements. Here is a list of the requirements of the assignment :

Your picture should have 4 types of elements. 3 of them must be a cable car on a cable running across the picture, a snow man with a hat and arms, and a tree with ornaments. The fourth one is up to you.
Create a class for each type of element. The class should at least contain a constructor and a private draw method. Don't change the signature of the constructor. Keep it as 
public ClassName(int x, int y, double scale, GWindow window)
to mean create an object of type ClassName at location (x,y) in the GWindow window with size given by the default size times scale (e.g. you can set the radius of the snow man head by default to 20. Then a scale of 1.5 would draw a snow man with a head of radius 20*1.5 = 30).
Don't do the drawing within the constructor. Instead call the private method draw. We will see the advantage of using a draw method in our next homework assignment. Read through the Tree class. It contains code to give you a better idea of what to do.
Complete the class MountainScene to create a picture with all of the elements in a graphics window. In the picture, each type of element should appear several times at different locations with different sizes (except for the cable car that you can only draw once).
The graphics elements should show some complexity. A single oval is not a good drawing for a snow man.
The program should be correctly documented (use the same format as in the sample (javadoc comments /** and */)).
To create the graphics elements, draw them first on a piece of graph paper. It will make it easy for you to locate each point of your drawing with respect to some reference point (x,y).

If you want to create your own colors, use the Color constructor. It reads Color(r,g,b) where r,g and b are integers between 0 and 255. The color is a mixture of red, green and blue as specified by r, g and b. For example

Color myColor = new Color(100,150,210); // a blueish color
Good luck!

Here is a possible picture.
