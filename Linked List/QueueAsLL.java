class Queue<E> {

	static class Node<E> {

		Node<E> next;
		E val;

		public Node(E x){
			this.val=x;
			this.next=null;
		}

	}

	Node<E> front=null,rear=null;

	public void enqueue(E x)
	{
		if( this.front == null )
		{
			this.rear = new Node<E> (x);	
			this.front = this.rear;
			return;
		}

		this.rear.next = new Node<E> (x); 
		this.rear= this.rear.next;

	}

	public E dequeue()
	{

		if(front == null)
		{
			return null;
		}

		E v = this.front.val;
		this.front = this.front.next;

		return v;
	}
	
	public String toString() {

		if(this.front==null){
			return null;
		}

		StringBuilder sb = new StringBuilder();

		for(Node<E> curr=this.front;curr!=null; curr=curr.next)
		{
			sb.append(curr.val + "->");
		}
		//	for(int i=0; i<this.size; i++){
		//		sb.append(this.arr[i] + ", ");
		//	}
		sb.setLength(sb.length()-2);
		return sb.toString();	
	}

}
