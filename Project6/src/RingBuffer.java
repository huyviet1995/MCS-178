public class RingBuffer {
	private int max;
	private int N=0;
	public double[] a;
	public int first;
	public int last=0;
	
	//initiate the ringbuffer object
	public RingBuffer (int capacity) {
		max=capacity;
		a= new double[max];
		for (int i=0;i<a.length;i++) a[i]=0; 
	}
	//find the current size of the stack
	public int size() {
		return N;
	}
	
	//check if the stack is empty 
	public boolean isEmpty () {
		return (N==0);
	}
	
	//check if the stack is full
	public boolean isFull () {
		return (N==max);
	}
	
	//enqueue an element into the stack
	public void enqueue (double x) {
		a[last++]=x;
		if (last==a.length) last = 0;
		N++;
			
		
	}
	//dequeue an element from the stack
	public double dequeue() {
		//if (isEmpty()) throw new RuntimeException("Queue underflows");
		double item = a[first];
		N--;
		first++;
		if (first==a.length) first=0;
		return item;
		
		
	}
	//peek through an element in the stack
	public double peek() {
		return a[first];
	}
	
	//unit testing 
	public static void main (String[] args ) {
		RingBuffer object1= new RingBuffer (8);
		object1.enqueue(3.5);
		object1.enqueue(4.5);
		object1.enqueue(5.5);
		object1.enqueue(5.5);
		object1.enqueue(5.5);
		object1.enqueue(5.5);
		object1.enqueue(5.5);
		object1.enqueue(40);
		
		//object1.enqueue(5.5);
		
		System.out.println(object1.size());
		
		System.out.println(object1.dequeue());
		
		System.out.println(object1.first);
		
		System.out.println(object1.dequeue());
		System.out.println(object1.last);
		System.out.println(object1.peek());

		
		for (int i=0;i<object1.a.length;i++) {
			System.out.print(object1.a[i]);
			System.out.print(" ");
		}
		/*for (int i = object1.first; i<object1.last;i++) {
			System.out.println(object1.dequeue());
		}*/
		
	}
	
	
}