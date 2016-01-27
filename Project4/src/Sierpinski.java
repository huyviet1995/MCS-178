public class Sierpinski {
	// draw the triangle in the base case. 
	public static void triangle(double x0, double y0,double x1,double y1,double x2,double y2) {
			double[] array1={x0,x1,x2};
			double[] array2={y0,y1,y2};
			StdDraw.filledPolygon(array1,array2);
		}
	public static void SierpinskiRecursive(double x0,double y0,double x1,double y1,double x2,double y2,int level)
	{
		//if level is 0, then draw the base case
		if (level==0) {
			triangle(x0,y0,x1,y1,x2,y2);
		}
		else { // else start the recursive functions
			//calculate the coordinates of all the points. 
			double x0x2m=(x0+x2)/2;
			double y0y2m=(y0+y2)/2;
			double x0x1m=(x0+x1)/2;
			double y0y1m=(y0+y1)/2;
			double x1x2m=(x1+x2)/2;
			double y1y2m=(y1+y2)/2;
			SierpinskiRecursive(x0,y0,x0x2m,y0y2m,x0x1m,y0y1m,level-1);
			SierpinskiRecursive(x2,y2,x0x2m,y0y2m,x1x2m,y1y2m,level-1);
			SierpinskiRecursive(x1,y1,x0x1m,y0y1m,x1x2m,y1y2m,level-1);
		}
	}
	public static void main(String[] args)
	{
		double x0=0;
		double y0=0;
		double x1=1;
		double y1=0;
		double x2=0.5;
		double y2=0.886;
		int level=10;
		SierpinskiRecursive(x0,y0,x1,y1,x2,y2,level);
		
		
	}
}