/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    
    public boolean isPalindrome(ListNode head) {
        
        if(head==null || head.next==null)
        return true;
        
        ListNode midprev=findMiddle(head);
        
        ListNode mid=midprev.next;
        
        if(mid.next==null)
         return (mid.val==midprev.val);
            
        int n=lengthList(head);
        
            
        ListNode revnode=null;
        
        if(n%2==0){
            
        midprev.next=null;

           revnode=Reverse(head); 
            
        while(mid!=null && revnode!=null)
        {
            if(mid.val==revnode.val)
            {
                mid=mid.next;
                revnode=revnode.next;
            }
            else
            return false;       
                
        }
            
        return true;    
            
    }
        else
        {
            
            midprev.next=null;

            ListNode t=mid;
        
            mid=mid.next;
            t.next=null;
            
            revnode=Reverse(head);
            
            
              while(mid!=null && revnode!=null)
        {
            if(mid.val==revnode.val)
            {
                mid=mid.next;
                revnode=revnode.next;
            }
            else
            return false;       
                
        }
            
        return true;  
            
            
        }
       
        
        
    }
    
    public int lengthList(ListNode head)
    {
            ListNode curr=head;
        
        int c=0;
        
        while(curr!=null)
        {
            curr=curr.next;    
            c++;
        }
        
        return c;
    }
    
    ListNode Reverse(ListNode head) {

    
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

    
    
    public ListNode findMiddle(ListNode head){
        
        
        ListNode slow=head;
        ListNode fast=head;
        
        ListNode midprev=head;
        
        while(slow!=null && fast!=null && fast.next!=null)
        {
            midprev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        
        
        return midprev;
    }
    
    
}
