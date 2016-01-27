import java.io.FileInputStream;

public class EditDistance {
	public static int n, m, p;
	public static String A;
	public static String B;
	public static char[] memoX;
	public static char[] memoY;
	public static int[][] opt;

	public static String newString(String x, int i) {
		return x.substring(0, i) + '-' + x.substring(i, x.length());
	}

	// using recursive programming
	public static int recursiveEditDistance(String x, String y, int i, int j) {
		// base case
		if (i == x.length())
			return 2 * (y.length() - j);
		else if (j == y.length())
			return 2 * (x.length() - i);
		//consider 3 different options
		else {
			int firstOption = recursiveEditDistance(x, y, i + 1, j + 1);//0 point if the same
			int secondOption = recursiveEditDistance(x, y, i, j + 1)+ 2;//skip, lost 2 points
			int thirdOption = recursiveEditDistance(x, y, i + 1, j)+ 2;//skip, lost 2 points 
			if (x.charAt(i) != y.charAt(j)) {
				firstOption++;
			}
			return Math.min(Math.min(firstOption, secondOption), thirdOption);
		}
	}

	// Using bottom up programming
	public static int editDistance(String x, String y) {

		opt = new int[x.length() + 1][y.length() + 1];
		int M = x.length();
		int N = y.length();

		memoX = new char[M];
		memoY = new char[M];

		for (int i = M; i >= 0; i--) {
			for (int j = N; j >= 0; j--) {
				if (i == M)
					opt[i][j] = 2 * (N - j);
				else if (j == N)
					opt[i][j] = 2 * (M - i);
				else {
					int firstOption = opt[i + 1][j + 1]; // if two characters match, then proceed
					int secondOption = opt[i][j + 1] + 2; // if you skip one, lose 2 points
															
					int thirdOption = opt[i + 1][j] + 2; // if you skip one, lose 2 points

					if (x.charAt(i) != y.charAt(j))
						firstOption++;
					opt[i][j] = Math.min(firstOption, Math.min(secondOption, thirdOption));
				}
			}
		}

		return opt[0][0];
	}
	
	//Trace back from the table
	public static void printEditDistance(String x, String y) {
		p = 0;
		int i = 0;
		int j = 0;
		memoX[i] = x.charAt(i);
		memoY[j] = y.charAt(j);
		while (p < x.length() - 1) {
			p = p + 1;
			if (x.charAt(i) == y.charAt(j)) {
				//if the next value is equal to the value plus 2, then add the character -
				if (opt[i + 1][j] + 2 == opt[i][j]) {
					i = i + 1;
					memoX[p] = x.charAt(i);
					memoY[p - 1] = '-';
					memoY[p] = y.charAt(j);
				//if the next value is equal to the value plus 2, then add the character -
				} else if (opt[i][j + 1] + 2 == opt[i][j]) {
					j = j + 1;
					memoX[p - 1] = '-';
					memoX[p] = x.charAt(i);
					memoY[p] = y.charAt(j);
				// if the diagonal value is equal to the value, then add nothing
				} else if (opt[i + 1][j + 1] == opt[i][j]) {
					i = i + 1;
					j = j + 1;

					memoX[p] = x.charAt(i);
					memoY[p] = y.charAt(j);
				}
			} else { //if two characters do not match, same arguments
				if (opt[i + 1][j] + 2 == opt[i][j]) {
					i = i + 1;
					memoX[p] = x.charAt(i);
					memoY[p - 1] = '-';
					memoY[p] = y.charAt(j);
				} else if (opt[i][j + 1] + 2 == opt[i][j]) {
					j = j + 1;
					memoX[p - 1] = '-';
					memoY[p] = y.charAt(j);
					memoX[p] = x.charAt(i);
				} else if (opt[i + 1][j + 1] + 1 == opt[i][j]) {
					i = i + 1;
					j = j + 1;
					memoX[p] = x.charAt(i);
					memoY[p] = y.charAt(j);
				}
			}

		}
		int cnt = 0;
		for (int k = 0; k <= p; k++) { //print out the characters.
			if (memoX[k] == memoY[k])
				cnt = 0;
			else if ((memoX[k] == '-') || (memoY[k] == '-'))
				cnt = 2;
			else if (memoX[k] != memoY[k])
				cnt = 1;

			System.out.println(memoX[k] + " " + memoY[k] + " " + Integer.toString(cnt));
		}
	}
	//print out the edit distance and the computed time for the recursive example
	public static void timeRecursiveEditDistance (String x, String y)
	{
		 Stopwatch sw2 = new Stopwatch();
		 StdOut.println("Edit distance "+recursiveEditDistance(x,y,0,0)); 
		 double time2 =sw2.elapsedTime(); 
		 StdOut.println("Recursive running time = "+time2);
	}
	//print out the edit distance and the computed time for the bottom up one 
	public static void timeEditDistance (String x,String y)
	{
		Stopwatch sw = new Stopwatch();
		StdOut.println("Edit distance =" + editDistance(x, y));
		double time = sw.elapsedTime();
		printEditDistance(x, y);
		StdOut.println("bottom up running time " + time);
	}
	
	//generate random DNA string 
	public static StringBuilder randomDNAString (int DNAlength)
	{
		StringBuilder sb = new StringBuilder();
		for (int i=0;i<= DNAlength;i++)
		{
			double a=Math.random();
			if ((a>=0) && (a<0.25))
				sb.append('A');
			else if (a<0.5)
				sb.append('G');
			else if (a<0.75)
				sb.append('T');
			else
				sb.append('C');
			
		}
		return sb;
	}

	//main function
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("resources/sequence/" + args[0]));
		} catch (Exception e) {
			System.err.printf("Exception caught: %s\n", e.toString());
			System.exit(0);
		}
		String x = StdIn.readLine();
		String y = StdIn.readLine();
		timeRecursiveEditDistance(x,y);
		timeEditDistance(x,y);
		
		
	}
}