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
    public boolean isSymmetric(TreeNode root) {
        
        if(root==null)
        return true;
        
        if( (root.left==null && root.right!=null) || (root.right==null && root.left!=null) )
            return false;
        
        boolean res=isSymmetr(root.left,root.right);
        
        return res;
        
    }
    
    public boolean isSymmetr(TreeNode a,TreeNode b){
        
        if(a==null && b==null)
        return true;
        
        if(a==null || b==null)
        return false;
        
        else
        {
            if( (a.left==null && b.right!=null) || (a.right==null && b.left!=null) )
            return false;
            
          return ( a.val==b.val && isSymmetr(a.left,b.right) && isSymmetr(a.right,b.left));      }
    }
    
    
}
