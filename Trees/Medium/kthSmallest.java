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
    
    static int count=0;
    static int kthSmall=0;
    
    
    public int kthSmallest(TreeNode root, int k) {
       
    
        Stack<TreeNode>S=new Stack<>();
        
        TreeNode curr=root;
        
        while(true)
        {
            
          while(curr!=null)  
          {
              S.push(curr);
              curr=curr.left;   
          }
                
               if(S.empty())
                   break;
                   
                curr=S.peek();
                S.pop();
                
                if(--k==0)
                {
                   kthSmall=curr.val; 
                    break;
                }
                
                curr=curr.right;
   
        }  
         return  kthSmall;  
            
        }
        
    
}
