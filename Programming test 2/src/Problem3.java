
public class Problem3 {
    private int n;
    private int [] a;
    private int m=-1;
    public Problem3(int size){
    	a = new int[size];
    	n=size;
    }
    
    public void push(int item){
    	a[m++]=item;
    	}
    public int pop(){
    	return a[m-1];
    }
    
    private boolean isEmpty() {
    	return (m==0);
    }

    public boolean hasSpace(){
    	return (m<n);
    }
    public static void main(String[] args) {
	
	Problem3 stack = new Problem3(5) ;
	
	//Push a few things onto it 
	if(stack.hasSpace())
	    stack.push(17);
	if(stack.hasSpace())
	    stack.push(29);
	if(stack.hasSpace())
	    stack.push(2001);
	if(stack.hasSpace())
	    stack.push(2010);
	if(stack.hasSpace())
	    stack.push(33);
	if(stack.hasSpace())
	    stack.push(18);
	if(stack.hasSpace())
	    stack.push(20);

	for (int x = 0 ; x<7 ; x++){
	    if(!stack.isEmpty())
		System.out.printf("Popping %d\n", stack.pop());
	}
	

    }

}
