/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        
        if(head==null || head.next==null)
        return head;
        
        ListNode current=head;
        
        ListNode nxt=null;
        
        
        ListNode sorted=null;
        
        
        while(current!=null)
        {
          nxt=current.next;
            
         sorted=insertSorted(sorted,current);
            
           current=nxt; 
            
            
        }

     return sorted;   
        
    }
    
    
    public ListNode insertSorted(ListNode sorted,ListNode current)
    {
        
        // head case always deal with this first
       if(sorted==null || sorted.val>=current.val) 
       {
           ListNode temp=new ListNode(current.val);
           temp.next=sorted;
           sorted=temp;  
           return sorted;
       }
        
       else {
       
            ListNode t=sorted;
            ListNode p=null;   
               
            while(t!=null && t.val<=current.val)   
            {
               p=t; 
               t=t.next; 
                
            }
               p.next=new ListNode(current.val);
               
               p.next.next=t;
               
             
           }
           
          
       
       return sorted;
        
        
        
        
        
        
    }
    
    
    
    
    
    
    
    
}
