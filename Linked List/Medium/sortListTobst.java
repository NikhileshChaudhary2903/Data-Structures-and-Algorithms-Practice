/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        
        //case empty
        if(head==null)
          return null;
        
        // case 1 element
        
        else if(head.next==null)
        {
            
            TreeNode t=new TreeNode(head.val);
            t.left=null;
            t.right=null;
            
            return t;
        }
            
            
        TreeNode res=null;
        
        ListNode m=null,nm=null;
        
        
        ListNode pm=getMid(head);
        
        if(pm!=null)
        m=pm.next;
        else 
        m=head;    
        
        nm=m.next;
        
        if(pm!=null)
        pm.next=null;
        
        
        m.next=null;
        
        res=new TreeNode(m.val);
        
        if(pm!=null)
        res.left= sortedListToBST(head);  
        else
        res.left= sortedListToBST(pm);    
            
         
        res.right= sortedListToBST(nm);
        
        
        
        return res;
        
    }
    
    
    
     public ListNode getMid(ListNode head)
    {
        
    ListNode s=head;
        
    ListNode f=head;
    
         ListNode p=null;
        
      while(f.next!=null && f.next.next!=null)  
      {
          p=s;
          s=s.next;
          f=f.next.next;
          
      }
        
       return p; 
        
        
    }
    
}
