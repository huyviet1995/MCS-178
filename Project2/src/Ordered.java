public class Ordered {
/*Take three integers a,b,c as inputs. Print out true if a>b>c or a<b<c. Otherwise, print out false. */
	public static void main(String[] args) {
		int a=Integer.parseInt(args[0]);
		int b=Integer.parseInt(args[1]);
		int c=Integer.parseInt(args[2]);
		boolean isOrdered;
		//isOrdered = true when a>b>c or a<b<c.
		if (((a>b) && (b>c)) || ((a<b) && (b<c))) {
			isOrdered=true;
		}
		else //otherwise, isOrdered = false;
		{
			isOrdered=false;
		}
		//print out the result
		System.out.print(isOrdered);
	}
}