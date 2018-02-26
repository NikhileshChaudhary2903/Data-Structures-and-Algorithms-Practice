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
    public List<Integer> postorderTraversal(TreeNode root) {
        
        
        if(root==null)
            return Collections.emptyList();
            
        Stack<TreeNode> s1=new Stack<>();
        
        List<Integer> list=new ArrayList<>();
        
        Stack<TreeNode> s2=new Stack<>();
        
        s1.push(root);
        
        TreeNode curr=root;
        
        while(!s1.empty())
        {
           curr=s1.peek();    
            s1.pop();
           s2.push(curr);
            
           if(curr.left!=null) 
            s1.push(curr.left);
            
            if(curr.right!=null)
               s1.push(curr.right);
            
            
        }
        
        while(!s2.empty())
        {
            list.add(s2.peek().val);
            s2.pop();
            
        }
     
        return list;
    }
}
