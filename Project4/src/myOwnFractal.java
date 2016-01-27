public class myOwnFractal {
	//create the repetitive pattern
	public static void squareShape (double xcenter, double ycenter, double sizeLength)
	{
		StdDraw.filledSquare(xcenter, ycenter, sizeLength*2);
		StdDraw.line(xcenter-sizeLength, ycenter+sizeLength, xcenter+sizeLength, ycenter+sizeLength);
		StdDraw.line(xcenter+sizeLength, ycenter+sizeLength, xcenter+sizeLength, ycenter-sizeLength);
		StdDraw.line(xcenter+sizeLength, ycenter-sizeLength, xcenter-sizeLength, ycenter-sizeLength);
		StdDraw.line(xcenter-sizeLength, ycenter-sizeLength, xcenter-sizeLength, ycenter+sizeLength);
	}
	//the main recursive function
	public static void myFractal(double xcenter, double ycenter, double sizeLength, int level)
	{
		//if level =0, draw the base case
		if (level==0)
			squareShape(xcenter, ycenter, sizeLength);
		else //else use recursive function for the 12 small square surrounding the center square
		{
			double fragmentedSize=sizeLength/4;
			//draw the 12 small squares surrounding the center sqaure. 
			myFractal(xcenter - 3*fragmentedSize,ycenter+3*fragmentedSize,fragmentedSize,level-1);
			myFractal(xcenter - fragmentedSize,ycenter+3*fragmentedSize,fragmentedSize,level-1);
			myFractal(xcenter + fragmentedSize,ycenter+3*fragmentedSize,fragmentedSize,level-1);
			myFractal(xcenter + 3*fragmentedSize,ycenter+3*fragmentedSize,fragmentedSize,level-1);
			myFractal(xcenter + 3*fragmentedSize,ycenter+fragmentedSize,fragmentedSize,level-1);
			myFractal(xcenter + 3*fragmentedSize,ycenter-fragmentedSize,fragmentedSize,level-1);
			myFractal(xcenter + 3*fragmentedSize,ycenter-3*fragmentedSize,fragmentedSize,level-1);
			myFractal(xcenter + fragmentedSize,ycenter-3*fragmentedSize,fragmentedSize,level-1);
			myFractal(xcenter - fragmentedSize,ycenter-3*fragmentedSize,fragmentedSize,level-1);
			myFractal(xcenter - 3*fragmentedSize,ycenter-3*fragmentedSize,fragmentedSize,level-1);
			myFractal(xcenter - 3*fragmentedSize,ycenter-fragmentedSize,fragmentedSize,level-1);
			myFractal(xcenter - 3*fragmentedSize,ycenter+fragmentedSize,fragmentedSize,level-1);
			
		}
	}
	
	public static void main(String[] args)
	{
		StdDraw.setXscale(-5,+5);
		StdDraw.setYscale(-5,+5);
		//set the recursice level 
		int level=4;
		myFractal(0,0,5,level);
		StdDraw.show(0);
	}
}