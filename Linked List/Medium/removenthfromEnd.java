/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
       if(head==null || (head.next==null && n==1))
        return null;
         
       ListNode t1=head;
       ListNode t2=head;
          
       int c=0;
          
            while(c<n && t1!=null)   
          {
              t1=t1.next;
              c++;
          }
         
          // head case
          if(t1==null && c==n)
          {
              head=head.next;
              return head;
          }
         
        ListNode pn=null;  /// n-1 th node
          
         while(t1!=null) 
          {
              t1=t1.next;
              pn=t2;
              t2=t2.next;
              
              
          }
          
          pn.next=t2.next;
          
          t2.next=null;
        
          return head;
    }
}
