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
        
        
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Stack<Integer> s3 = new Stack<>();
        
        
        

        ListNode a=l1,b=l2;
        
        while(a!=null)
        {
            s1.push(a.val);
            a=a.next;
        }
        
        while(b!=null)
        {
            s2.push(b.val);
            b=b.next;
        }
        
        int a1=0,b1=0,carry=0;
        
        
        while(!s1.empty() || !s2.empty())
        {
           if(s1.empty()==true) 
            a1=0;
            else
            a1=s1.pop();    
            
           if(s2.empty()==true) 
            b1=0;
            else
            b1=s2.pop();    
                        
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
                
           s3.push(s);   
                   
            
        }
        
        if(carry!=0)
        s3.push(carry);
            
            
         ListNode l3=null;
         ListNode temp=null;
        
        while(!s3.empty())
        {
            if(l3==null)
            {
                l3=new ListNode(s3.pop());
                l3.next=null;
                temp=l3;
            }
            else
            {
               temp.next=new ListNode(s3.pop()); 
               temp=temp.next; 
                
               temp.next=null;
                
            }            
        }
        
        return l3;
    }
}
