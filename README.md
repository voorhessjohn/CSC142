# CSC142 Assignment Two
I am supposed to adapt my code from Assignment One to incorporate movement into MountainScene with movement functions from the uwcse graphics library.  As of this commit, nothing moves and when the individual movement methods are initialized in the public constructor of each class, only a single tree appears on the screen.

There is a conditional set up on the move() function for CableCar.  This is semi-permanently set to true for testing.  This will eventually test whether cableCar is off the screen to the left or right and reverse the direction.

I have used moveBy() as a stand-in for each movement function for testing.  I was just trying to get something to work before adapting and implementing changes to bring it to the assignment standard.
