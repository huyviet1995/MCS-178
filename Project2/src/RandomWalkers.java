public class RandomWalkers {
	/*Input the number of steps taken n and number of trials t. Output the mean squared distance*/
	public static void main (String[] args)
	{
		int n = Integer.parseInt(args[0]);
		int t = Integer.parseInt(args[1]);
		int x=0;
		int y=0;
		double random;
		double sum=0;
		double squaredDistance;
		for (int j=0;j<t;j++)
		{
			x=0;
			y=0;
			squaredDistance=0;
			for (int i=0;i<n;i++)
			// the possibility of moving North, West, South, East is all equal to 0.25. 
			{
				random=Math.random();
				if (random<=0.25) x=x+1;
				else if (random<=0.5) y=y+1;
				else if (random<=0.75) y=y-1;
				else x=x-1;
				
			}
			// after each trial, adding up the squared distance to sum and restore x,y,squared distance variables to 0
			squaredDistance=x*x+y*y;
			sum+=squaredDistance;
			
			
		}
		// print out the squared distance. 
		//Hypothesis: As the number of trials t increases, the result is closer to n.
		System.out.println(sum/t);
	}
}