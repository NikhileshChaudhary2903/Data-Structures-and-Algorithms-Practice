/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
     
        if(head==null || head.next==null || m==n)
        return head;
        
        ListNode curr=head,pm=null,nn=null;
        ListNode mth=null;
        
        int c=1;
        
        
        while(curr!=null && c<n)
        {
            
              if(c==m && curr==head)
              {    
              
                pm=null;
                mth=head;     
              } 
            
             else if(c==m-1)
             {
                 pm=curr; mth=curr.next;
             }
                 
                  
            curr=curr.next;
            c++;
            
        }
        
        nn=curr.next;
        
        curr.next=null;
        
        if(pm!=null)
        pm.next=revList(mth);
        
        else
        head=revList(mth);   
        
        
        mth.next=nn;
        
        
        
        return head;
        
        
    }
    
    
    
   public ListNode revList(ListNode head)
   {
       
         if(head==null || head.next==null)
    return head;
    
    ListNode prev=null;
    
    ListNode curr=head;
    
    ListNode nxt=curr;
    
    while(curr!=null)
    {
        nxt=curr.next;
        curr.next=prev;
        prev=curr;
        curr=nxt;
    }
    
    
    return prev;
    
       
   }
    
}
