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
    public int minDepth(TreeNode root) {
        
        if(root==null)
        return 0;
        
        if(root.left==null && root.right==null)
        return 1;
        
        int lh=minDepth(root.left);
        int rh=minDepth(root.right);
        
        if(rh==0)
            rh=lh;
        
        if(lh==0)
        lh=rh;
            
        return (1+Math.min(lh,rh));
            }
}
