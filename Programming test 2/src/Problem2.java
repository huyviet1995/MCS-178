
public class Problem2 {
	public static void fractal (double x, double y, double r, int level) {
		if (level ==0) {
			StdDraw.filledSquare(x, y, r);
        } else {
            double newR = r/2;
            double newX= x/2;
            double newY= y/2;
            fractal (x+newX,y+newY,newR, level-1);
            fractal (x-newX,y-newY,newR,level-1);
            fractal (x-newX,y+newY,newR,level-1);
		}
	}
	
	public static void main (String[] args) {
		fractal(0.5, 0.5, 0.5, 1);
	}
}