
public class Dragon {
	
	public static void DragonCurve(double x0, double y0, double x1, double y1, int level) {
		if (level == 0) {
			StdDraw.line(x0, y0, x1, y1);
		} else {
			double dx = x1 - x0;
			double dy = y1 - y0;
			double xm = (x0 + x1) / 2;
			double ym = (y0 + y1) / 2;
			double xNew = xm - dy/2;
			double yNew = ym + dx/2;
			// reverse the order of the fractal
			DragonCurve(x0, y0, xNew, yNew, level - 1);
			DragonCurve(x1,y1,xNew,yNew, level - 1);
		}
	}

	public static void main(String[] args) {
		int level = 12;
		double x0 = .5;
		double y0 = 0.25;
		double x1 = .5;
		double y1 = .75;
		
		DragonCurve(x0,y0,x1,y1,level);
	}
}
