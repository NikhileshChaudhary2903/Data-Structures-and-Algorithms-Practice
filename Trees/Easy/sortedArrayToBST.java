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
    public TreeNode sortedArrayToBST(int[] nums) {
        
        if(nums.length==0)
            return null;
        
        
        TreeNode root=ArraytoBST(nums,0,nums.length-1);
        
        return root;
    }
    
    public TreeNode ArraytoBST(int[] nums,int l,int h)
    {
        
        if(l>h)
        return null;
        
        int m=(l+h)/2;
        
        TreeNode node=new TreeNode(nums[m]);
        
        if(l==h)
        return node;
        
        node.left=ArraytoBST(nums,l,m-1);
        node.right=ArraytoBST(nums,m+1,h);
        
        return node;    
    }
    
    
}
