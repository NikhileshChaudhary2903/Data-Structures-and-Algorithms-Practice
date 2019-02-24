class Stack<E> {
	
	static class Node<E> {
		
		Node<E> next;
		E val;
		
		public Node(E x){
			this.val=x;
			this.next=null;
		}

	}	
	
Node<E> top = null;	
	
public void push(E x)
{
	
if(this.top == null )	
{
	this.top = new Node<E>(x);
	return;
}

Node<E> newNode = new Node<E> (x);
newNode.next = this.top ;
this.top = newNode;

}

public E pop()
{
if(this.top == null)	
{
 return null;
}

E v = (E) this.top.val;
this.top = this.top.next;

return v;
}

public String toString() {
	
	if(this.top==null){
		return null;
	}

	StringBuilder sb = new StringBuilder();
		
	for(Node<E> curr=this.top;curr!=null; curr=curr.next)
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
