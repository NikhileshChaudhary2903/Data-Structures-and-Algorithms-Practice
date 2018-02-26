/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        
        
        if(head==null || head.next==null)
            return head;
            
        ListNode es=null,ee=null,os=null,oe=null;
        
        int c=1;
        
        ListNode curr=head;
        
        
        while(curr!=null)
        {
           if(c%2==1) // odd
           {
              if(os==null)
              {
                 os=head; 
                 oe=os; 
                  
              }
               else
               {
                 oe.next=curr;  
                 oe=oe.next;  
               }
                 
               
           }
          else            // even
            {
                
              if(es==null)
              {
                 es=curr; 
                 ee=es; 
                  
              }
               else
               {
                 ee.next=curr;  
                 ee=ee.next;  
               }

            }
            
            curr=curr.next;
            c++;
        }
        
        oe.next=es;
        
        ee.next=null;
        
        head=os;
        
        
        return head;
        
        
    }
}
