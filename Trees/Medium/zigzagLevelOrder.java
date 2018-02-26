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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
   List<List<Integer>> lst=new ArrayList< List<Integer> >();
		 
        Stack<TreeNode> s1=new Stack<>();
        Stack<TreeNode> s2=new Stack<>();
        
        int ltr=1;
        
        List<Integer> list=new ArrayList<>();
        
        s1.push(root);
        
        TreeNode curr=root;
        
        int lev=0;
        
        while(curr!=null)
        {
           
            list=new ArrayList<>();
            if(ltr!=0)
           {
               
                while(!s1.empty())
                {     
                curr=s1.pop();
                   
                list.add(curr.val);
                    
                if(curr.left!=null) 
                s2.push(curr.left);
               
                if(curr.right!=null) 
                s2.push(curr.right);
             
                
                    
                }  
               
                ltr=0;
                lst.add(lev,list);
                
                lev++;
           
            }
            else
            {
  
               while(!s2.empty())
                {     
                curr=s2.pop();
                   
                list.add(curr.val);
                    
                if(curr.right!=null) 
                s1.push(curr.right);
               
                if(curr.left!=null) 
                s1.push(curr.left);
             
                
                    
                }  
               
                ltr=1;
                lst.add(lev,list);
                lev++;
                
        
            }
           
            if(s1.empty() && s2.empty())
                  break; 
        }
      return lst;  
        
    }
}
