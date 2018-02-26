/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
     
       if(head==null || head.next==null) 
        return head;
        
        ListNode ls=null,le=null,gs=null,ge=null;
        
        
        ListNode c=head;
        
        while(c!=null)
        {
            if(x>c.val)
            {
                if(ls==null)
                {
                    ls=c;
                    le=ls;
                }
                else
                {
                   le.next=c; 
                   le=c; 
                }
                
            }
            else
            {
                if(gs==null)
                {
                    gs=c;
                    ge=gs;
                }
                else
                {
                   ge.next=c; 
                   ge=c; 
                }
    
            }
            
            c=c.next;
        }
        
        if(le!=null)
       le.next=gs;
        
        if(ge!=null)
        ge.next=null;
        
        
        return (ls!=null?ls:gs);
        
        
    }
}
