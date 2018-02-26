/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        
        if(head==null || head.next==null)
        return head;
            
        ListNode current=head;
        
        int c=0;
        int c1=0;
        
        ListNode nxt=null;
        ListNode p=null;
        ListNode c2=head;
        
        while(c1<k && c2!=null)
        {
            c2=c2.next;
            c1++;
        }
        
        if(c1<k && c2==null)
        return head;
            
            
        while(current!=null && c<k)
        {
           nxt=current.next;
           current.next=p;
           p=current; 
            
           current=nxt; 
            c++;
            
            
        }
       
            
        if(nxt!=null)
        head.next=reverseKGroup(nxt,k);
        
        
        return p;
        
    }
}
