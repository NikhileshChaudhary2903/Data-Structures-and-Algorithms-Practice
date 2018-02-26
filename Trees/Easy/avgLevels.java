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
    
    public static final TreeNode nil=new TreeNode(Integer.MIN_VALUE);
    
    public List<Double> averageOfLevels(TreeNode root) {
        
        List<Double> vals=new ArrayList<>();
        
        Queue<TreeNode> q=new LinkedList<>();
        
        q.add(root);
        
        q.add(nil);
        
        int c=0;     
        vals.add((double)root.val);
        
        double s=0;
        
        while(!q.isEmpty())
        {
        
            TreeNode temp=q.remove();
            
            if(temp!=nil)
            {
                if(temp.left!=null)
                {
                    c++;
                    s+=temp.left.val;
                    q.add(temp.left);
                }
                if(temp.right!=null)
                {
                    c++;
                    s+=temp.right.val;
                    q.add(temp.right);
                }
            
            }
            else
            {
            if(q.isEmpty())
                break;
                
                
                vals.add(s/c);
                c=0;
                s=0;
                q.add(nil);  
            
            }

            
        }
        
        return vals;
        
        
        
    }
}
