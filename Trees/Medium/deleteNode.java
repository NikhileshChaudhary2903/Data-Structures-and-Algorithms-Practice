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
    public TreeNode deleteNode(TreeNode root, int key) {
        
            TreeNode temp;
        
        if(root==null)
        return null;
        
        else if(root.val>key)
         root.left= deleteNode(root.left,key);
        
        else if(root.val<key)
         root.right= deleteNode(root.right,key);
        
        else
        {

            // 2 child
           if(root.left!=null && root.right!=null) 
           {
              temp= findMax(root.left);
              root.val=temp.val; 
              root.left= deleteNode(root.left,root.val);
           }
           else 
           {
         
               
               if(root.left==null)
                root=root.right;
               
               else if(root.right==null)
                root=root.left;
               
              
               
           }
               
        }
        
        return root;
    }
    
    
    public TreeNode findMax(TreeNode root)
    {
        
        TreeNode current=root;
        
        while(current.right!=null)
         current=current.right;
        
        return current;
        
    }
    
    
    public TreeNode findMin(TreeNode root)
    {
        
        TreeNode current=root;
        while(current.left!=null)
         current=current.left;
        
        return current;
        
    }
   
    
}
