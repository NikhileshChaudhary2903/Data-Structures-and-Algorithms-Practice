/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        
       if(head==null || head.next==null) 
        return ;
        
//        ListNode c=head; // current 
        
//        ListNode nxt=head.next;  // next
        
//        ListNode pl= findPenLast(head);  // penultimate
        
//        ListNode l=pl.next;  // last
        
//        while(c!=pl && nxt!=l) 
//        {
           
//           pl.next=null;
           
//           c.next=l;
//           l.next=nxt; 
           
//           c=nxt; 
           
//           pl=findPenLast(head);
//           l=pl.next; 
            
//        }
        
        
        ListNode mid=getMid(head);
        
        ListNode b=mid.next;
       
mid.next=null;        
        
        ListNode a=head;
        
        b=reverseList(b);
        
        ListNode an=null,bn=null;
        
        while(a!=null && b!=null)
        {
            an=a.next;
            bn=b.next;
            
            b.next=null;
            
        a.next=b;
            b.next=an;
            b=bn;
            a=an;
            
        }
        
        
        
        
        
    }
    
    
    
    public ListNode getMid(ListNode head)
    {
        
    ListNode s=head;
        
    ListNode f=head;
        
        
      while(f.next!=null && f.next.next!=null)  
      {
          s=s.next;
          f=f.next.next;
          
      }
        
       return s; 
        
        
    }
    
    
    
    public ListNode findPenLast(ListNode head)
    {
        
        ListNode t=head;
        
        while(t.next.next!=null)
        t=t.next;
        
        return t;
    }
    
    
    public ListNode reverseList(ListNode head)
    {
     
        if(head==null || head.next==null)   
        return head;
        
        ListNode c=head,p=null,nxt=null;    
        
        while(c!=null)
        {
            nxt=c.next;
            c.next=p;
            p=c;
            c=nxt;
                
        }
        
        return p;
        
    }
    
    
    
    
    
}
