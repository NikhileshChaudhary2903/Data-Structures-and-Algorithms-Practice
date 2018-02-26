/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        
        if(head==null || head.next==null)
        return head;
        
        ListNode c=head;
        ListNode nxt=c.next;
        ListNode nn=nxt.next;
        
        nxt.next=c;
        c.next=nn;
        
        ListNode p=c;
        
        c=nn;
        
        head=nxt;
        
        
        
        while(c!=null)
        {
            nxt=c.next;
            
            if(nxt==null)
              break;  
                
            nn=nxt.next;
            
            nxt.next=c;
            c.next=nn;
            
            p.next=nxt;
            
            p=c;
            
            c=nn;
            
        }
        
        
        return head;
    }
}
