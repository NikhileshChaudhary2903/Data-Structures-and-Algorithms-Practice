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
    public List<Integer> inorderTraversal(TreeNode root) {
        
        if(root==null)
        return Collections.emptyList();
        
        Stack<TreeNode> s=new Stack<>();
        
        List<Integer> list=new ArrayList<>();
        
        
        TreeNode curr=root;
        
        while(!s.empty() || curr!=null)
        {
            
            if(curr!=null)
            {
                s.push(curr);
                curr=curr.left;
                
            }
            else
            {
                curr=s.peek(); s.pop();
                
                list.add(curr.val);
                curr=curr.right;
            }
            
        }
     
        return list;
    }
}
