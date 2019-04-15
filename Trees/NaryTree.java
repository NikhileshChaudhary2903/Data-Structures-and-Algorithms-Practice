import java.util.*;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int val) {
        this.val = val;
        children = new ArrayList<>();
    } 
}

class TreeNode
{
    TreeNode left;
    TreeNode right;
    int value;
 
    public TreeNode(int value)
    {
        this.value = value;
    }
}

class QueueObj {
	TreeNode node;
	 int hd; 
	  
     QueueObj(TreeNode node, int hd) { 
         this.node = node; 
         this.hd = hd; 
     } 
}
public class NaryTree {

	public static void topView(TreeNode root)
	{
		
	Queue<QueueObj> queue = new LinkedList<>();	
	Map<Integer,Integer> map = new HashMap<>();
	queue.add(new QueueObj(root, 0));
	
	while(!queue.isEmpty())
	{		
		QueueObj temp = queue.poll();	
		TreeNode front = temp.node;
		
		if(!map.containsKey(temp.hd))
		{
			map.put(temp.hd, front.value);
		}
		
		if(front.left!=null)
			queue.add(new QueueObj(front.left, temp.hd - 1));
		
		if(front.right!=null)
			queue.add(new QueueObj(front.right, temp.hd + 1));
		
	}
	
		System.out.println(map.values());
	}
	
	public static void diagSum(TreeNode root)
	{
	
		HashMap<Integer,Integer> map = new HashMap<>();	
		diagonalSum(root,map,0);
		System.out.println(map);
		
	}
	
	
	 static void diagonalSum(TreeNode root, HashMap<Integer, Integer> map, int diag) {
		// TODO Auto-generated method stub
		
		 if(root==null)
			 return;
		 
		 diagonalSum(root.left,map,diag + 1);
		 
		 if(!map.containsKey(diag))
		 map.put(diag, root.value);
		 else
		 map.put(diag, map.get(diag) + root.value); 
		 
		 diagonalSum(root.right,map,diag);

		 
	}


	public static List<List<Integer>> rootToLeaf(Node root) {
        List<List<Integer>> list=new ArrayList< List<Integer> >();
        HashMap<Integer, Integer> map =new HashMap<>();
        rootToLeaf(root,list,new ArrayList<>()); 
        
        return list;
		
	}
	
	
	private static void rootToLeaf(Node root, List<List<Integer>> list,List<Integer> inner) {
		// TODO Auto-generated method stub
		
	 if(root == null)
		 return;
		
	 if(root.children.size() == 0)
	 {
		 inner.add(root.val);
		 list.add(new ArrayList<>(inner));
		 inner.remove(inner.size() - 1);
		 return;
	 }
	 
	 inner.add(root.val);
	 
	 for(Node c:root.children) {
		 rootToLeaf(c,list,inner);
	 }
	 inner.remove(inner.size() - 1);
	 	
	}
	public static  List<Integer> preorder(Node root) {
	    
	      if(root == null)
	        return Collections.emptyList();  
	     
	        List<Integer> list = new ArrayList<Integer>();
	        preorder(root,list); 
	        
	        return list;
	        
	        
	    }
	
	public static void populateMap(Map<Node,Node> map,Node root,Node parent) {
		
		if(root == null)
			return;
		
		map.put(root, parent);
		
		for(Node c:root.children)
		populateMap(map, c, root);
		
		
	}
	    
	public static void levelOrder(Node root) {
		
		if(root == null)
	        return ;  
	     
	        Queue<Node> queue = new LinkedList<Node>();    
	        queue.offer(root);
	        int level = 0;
	        
	        while(!queue.isEmpty())
	        {
	         int size = queue.size();	
	        
	         for(int i=0;i<size;i++)
	         {
	        	Node top = queue.poll(); 
	        	System.out.println(top.val);
	        	for(Node c:top.children)
	        	 queue.offer(c);
	         }

	         System.out.println("level " + level + " ends");
	         level++;
	        }
	        
	       
		
		
	}
	
	
	    
		public static void preorder(Node root,List<Integer> list)
	    {
	        if(root == null)
	            return;
	        
	        else
	        {
	           list.add(root.val);
	            
	           for(Node c:root.children)
	               preorder(c,list);
	            
	        }
	        
	        
	    }
	public static void main(String []args) {
		
//		Node root = new Node(1);
//		
//		root.children.add(new Node(3));
//		root.children.add(new Node(2));
//		root.children.add(new Node(4));
//		
//		root.children.get(0).children.add(new Node(5));
//		root.children.get(0).children.add(new Node(6));
//		
//		System.out.println(preorder(root));
//		levelOrder(root);
//		System.out.println(rootToLeaf(root));
//		
//		TreeMap<Integer,List<Integer>> map = new TreeMap<>();
//		
//		for(Integer i:map.keySet()) {
//			Collections.sort(map.get(i));
//		}
		
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(1);
		root.right = new TreeNode(2);
		
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		
		root.left.right.left = new TreeNode(7);
		
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(6);
		
//		diagSum(root);
		topView(root);
	}
	
}
