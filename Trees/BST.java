
class Node {

	Node left,right;
	int val;

	public Node(int v) {
		this.val=v;
		this.left=null;
		this.right=null;		
	}
}

	class BinarySearchTree{
		
		Node root=null;
		
	public Node minNode(Node root)
	{
		if(root==null)
			return null;

		Node curr=root;
		while(curr.left!=null)
			curr=curr.left;

		return curr;

	}


	public Node maxNode(Node root)
	{
		if(root==null)
			return null;

		Node curr=root;
		while(curr.right!=null)
			curr=curr.right;

		return curr;

	}
	public Node insert(Node root,int key)
	{

		if(root==null)
		{
			root = new Node(key);
			return root;	
		}	

		if(root.val > key)
			root.left = insert(root.left,key);
		else
			root.right = insert(root.right,key);

		return root;

	}

	public Node search(Node root,int key)
	{

		if(root==null)
			return null;

		Node curr=root;

		while(curr!=null && curr.val !=key )
		{
			if(curr.val > key)	
				curr=curr.left;
			else
				curr=curr.right;	
		}

		return curr;
	}
	
	public void inorder(Node root)
	{
		
	 if(root!=null)	
	 {
		inorder(root.left); 
		System.out.println(root.val);
		inorder(root.right); 
	 }
		
	}

	public void preorder(Node root)
	{	
	 if(root!=null)	
	 {
		System.out.println(root.val);
		preorder(root.left); 
		preorder(root.right); 
	 }	
	}
	
	public void postOrder(Node root)
	{
	 if(root!=null)	
	 {
		postOrder(root.left); 
		postOrder(root.right);
		System.out.println(root.val);
	 }
		
	}

}
