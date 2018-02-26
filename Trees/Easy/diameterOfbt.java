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
    public int diameterOfBinaryTree(TreeNode root) {
        
        if(root==null)
        return 0;
    
        if(root.left==null && root.right==null)
        return 0;
            
        int lh=height(root.left);
        int rh=height(root.right);
        
        int ld=diameterOfBinaryTree(root.left);
        int rd=diameterOfBinaryTree(root.right);
        
        return (Math.max(lh+rh,Math.max(ld,rd)));
        
        
        
    }
    

    public int height(TreeNode root)
    {
        
        if(root==null)
        return 0;
        
        if(root.left==null && root.right==null)
          return 1;
        
        int lh=height(root.left);
        int rh=height(root.right);
        
        if(lh>rh)
        return (1+lh);
        
        else 
         return (1+rh);   
        
    }
}
