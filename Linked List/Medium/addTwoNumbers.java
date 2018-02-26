/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode l3=null;
        
        ListNode a=l1,b=l2;
        
        ListNode temp=null;
        
        int carry=0;
        int a1=0,b1=0;
        
        while(a!=null || b!=null)
        {
              if(a!=null)
               a1=a.val;
              else
                 a1=0;
            
               if(b!=null)
                b1=b.val;
                else
                b1=0;    
            
            
            int s=a1+b1+carry;
            
            
            if(s>=10)
            {
                carry=s/10;
                s=s%10;
            } 
            else
            {
                carry=0;    
            }  
                
            
            if(l3==null)
            {
                l3=new ListNode(s);
                l3.next=null;
                temp=l3;
            }
            else
            {
               temp.next=new ListNode(s); 
               temp=temp.next; 
                
               temp.next=null;
                
            }
            
            if(a!=null)
            a=a.next;
            
            if(b!=null)
            b=b.next;
            
            
        }
        
        if(carry!=0)
        {
              temp.next=new ListNode(carry); 
               temp=temp.next; 
                
               temp.next=null;
            
        }
            
            
        return l3;
        
        
    }
}
