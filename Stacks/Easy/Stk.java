class Stk <T> {

	private int top;	
	private int size;	

	private T[] arr=null;

	public Stk(int s)
	{
		this.top=-1;
		this.arr =  (T[]) new Object[s];
		this.size=0;
	}

	public void push(T element)
	{

		if(this.top == this.arr.length -1 )
		{
			System.out.println("Stack Overflow");
			return;
		}
		else
		{
			this.arr[++this.top] = element;	
			this.size++;
		}

	}

	public T pop() {

		if(this.top == -1)	
		{
			System.out.println("Stack Underflow");
			return null;
		}
		
		T temp = this.arr[this.top--];
		this.size--;
		return temp;
	}
	
	public T peek() {
		
		if(this.top == -1)	
		{
			System.out.println("Stack Overflow");
			return null;
		}
		
		return this.arr[this.top];
		
	}
	
	public String toString() {
		
		if(this.size==0){
			return null;
		}
 
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<this.size; i++){
			sb.append(this.arr[i] + ", ");
		}
 
		sb.setLength(sb.length()-2);
		return sb.toString();	
	}
	
} 
