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
    public List<Integer> preorderTraversal(TreeNode root) {
        
        List<Integer> list =new ArrayList<>();
        
        TreeNode curr=root;
        
        Stack<TreeNode> s1=new Stack<>();
        
        if(curr!=null)
        s1.push(curr);
        
        
        while(!s1.empty() )
        {
        
            curr=s1.pop();   
        
            list.add(curr.val);
            
         if(curr.right!=null)   
         s1.push(curr.right);
             
         if(curr.left!=null)   
         s1.push(curr.left);
            
            
        }
        
        
        
        return list;
        
        
    }
}
