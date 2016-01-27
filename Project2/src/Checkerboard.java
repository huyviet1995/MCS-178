public class Checkerboard {
	//Input the number of row, out put the checkerboard
	public static void main(String[] args) {
		int n =Integer.parseInt(args[0]);
		for (int i=0;i<n;i++)
		{
			for (int j=0;j<n;j++)
			{
				if (i%2==0) { //if i is divisible by 2, print out '* '
					System.out.print("* ");
				}
				else //otherwise print out ' *'
					System.out.print(" *");
			}
			//after one row, go down one line. 
			System.out.println();
			System.
			
		}
	}
}