public class RGBtoCMYK {
	/*Input values of the level of red, blue and green. Output the corresponding values of white
	 * cyan, magneta, yellow and black color based on the given formulae*/
	public static void main(String[] args) {
		double red=Integer.parseInt(args[0]);
		double green=Integer.parseInt(args[1]);
		double blue=Integer.parseInt(args[2]);
		double white,cyan,magneta,yellow,black;
		
		white=Math.max(red/255,Math.max(blue/255, green/255));
		//If white is not equal to 0, assign the values of CMYB based on the formulae. 
		if (white!=0)
		{
			cyan=(white-red/255)/white;
			magneta=(white-green/255)/white;
			yellow=(white-blue/255)/white;
			black=(1-white);
		}
		//if level of white is 0 then assign the values of cyan, magneta, yellow and black to be 0,0,0 and 1 respectively.
		else
		{
			cyan=0.0;
			magneta=0.0;
			yellow=0.0;
			black=1.0;
		}
		System.out.println("cyan = "+cyan+"\nmagneta = "+magneta+"\nyellow = "+yellow+"\nblack = "+black);
	}
}