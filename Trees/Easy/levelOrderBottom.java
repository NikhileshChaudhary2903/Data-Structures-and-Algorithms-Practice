/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public static final TreeNode nil=new TreeNode(-9999);
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        if(root==null)
            return Collections.emptyList();
            
           List<List<Integer>> lst=new ArrayList< List<Integer> >();

         List<Integer> list=new ArrayList<>();
    
        Queue<TreeNode>q= new LinkedList<>();
        
        Stack<TreeNode> s=new Stack<>();
        
        q.add(root);
        
        int count=0;
        
        TreeNode curr=null;
        
        while(true)
        {
            
            if(q.isEmpty())
               break;
            
          count=q.size();  
              
          while(count>0)  
          {
           curr=q.peek();
           q.remove();   
           
              count--;
           
              if(curr.right!=null)
              q.add(curr.right);
              
              if(curr.left!=null)
              q.add(curr.left);
              
                  
           s.push(curr);   
              
              
          }
            
           s.push(nil); 
           
            
        }
        
        int i=0;
        
        while(!s.empty())
        {
            s.pop();
        
            curr=s.peek(); 
            
           while(curr!=nil) 
           {
            list.add(curr.val);
            s.pop();  
               
               if(s.empty())
                   break;
                   
            curr=s.peek();   
           }
           lst.add(i++,list);
           list=new ArrayList<>();
            
        }
        
        return lst;
        
    }
}
