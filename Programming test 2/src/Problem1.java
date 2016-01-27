public class Problem1 {
	private int hour0;
	public Problem1 (int hour) {
		hour0 = hour;
	}
	public int getHour() {
		return hour0;
	}
	public void nextHour() {
		if (hour0 == 12)
			hour0=1;
		else 
			hour0=hour0+1;
	}
	public static void main (String[] args) {
		Problem1 a= new Problem1(1);
		Problem1 b= new Problem1(2);
		System.out.println(a.getHour() + " " + b.getHour());
		
		a.nextHour();
		System.out.println(a.getHour() + " " + b.getHour());
		
		a.nextHour();
		b.nextHour();
		System.out.println(a.getHour() + " " + b.getHour());
		
		a.nextHour();
		b.nextHour();
		System.out.println(a.getHour() + " " + b.getHour());
	}
	
	
}