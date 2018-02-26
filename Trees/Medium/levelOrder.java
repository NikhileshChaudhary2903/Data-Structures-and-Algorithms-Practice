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
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        
        if(root==null)
        return Collections.emptyList();
            
        List<List<Integer>> lst=new ArrayList< List<Integer> >();
        
        Queue<TreeNode> q=new LinkedList<>();
        
        q.add(root);
        
        List<Integer> list=new ArrayList<>();
         int i=0;
        
        int count=0;
        
        while(true) 
        {
           if(q.isEmpty())
               break;
            
            TreeNode curr=q.peek();
            count=q.size();
           
            while(count>0)
            {
                curr=q.peek();
                q.remove();
          
                list.add(curr.val);
            
                count--;
                
                if(curr.left!=null)
                  q.add(curr.left);
                
                  if(curr.right!=null)
                  q.add(curr.right);
            
            }
            
      
            lst.add(i++,list); 
          //  System.out.println(lst);
            list=new ArrayList<>();
            
            
        }
        
        return lst;
    }
}
