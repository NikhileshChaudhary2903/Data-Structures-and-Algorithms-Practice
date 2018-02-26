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
    public boolean hasPathSum(TreeNode root, int sum) {
        
        if(root==null)
        return false;
        else
        {
        int s=sum-root.val; 
            
           if(root.left==null && root.right==null && s==0) 
            return true;
               
            
        return ( hasPathSum(root.left,s) || (hasPathSum(root.right,s)) );
        }
    }
}
