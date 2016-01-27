public class RandomWalker {
	/*Show the step taken for the random walker to move from 0 after n steps. Also, show the squared distance*/
	public static void main (String[] args)
	{
		int n = Integer.parseInt(args[0]);
		int x=0;
		int y=0;
		double random;
		
		for (int i=0;i<n;i++)
		{
			//The possibility of the random walker to move in each direction is all equal to 25%
			random=Math.random();
			if (random<=0.25) x=x+1;
			else if (random<=0.5) y=y+1;
			else if (random<=0.75) y=y-1;
			else if (random<=1) x=x-1;
			//print out each move taken
			System.out.println("("+x+","+y+")");
		}
		//calculate the squared distance. 
		int squaredDistance=x*x+y*y;
		//print out the squared distance 
		System.out.println("squared distance = "+squaredDistance);
	}
}