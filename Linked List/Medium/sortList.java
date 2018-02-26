/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode h) {
        
      // Base case : if head is null
        if (h == null || h.next == null)
        {
            return h;
        }
 
        // get the middle of the list
        ListNode middle = getMiddle(h);
        ListNode nextofmiddle = middle.next;
 
        // set the next of middle node to null
        middle.next = null;
 
        // Apply mergeSort on left list
        ListNode left = sortList(h);
 
        // Apply mergeSort on right list
        ListNode right = sortList(nextofmiddle);
 
        // Merge the left and right lists
        ListNode sortedlist = sortedMerge(left, right);
        return sortedlist;
        
        
    }
    
ListNode sortedMerge(ListNode headA, ListNode headB) 
    {
        
    if(headA==null)
     return headB;
    
    else if(headB==null)
       return headA; 
    
    
    if(headA.next==null && headB.next==null)
    {
        
     if(headA.val>headB.val)   
     {
         
         headB.next=headA;
         return headB;
     
     }
        else
        {
            
         headA.next=headB;
         return headA;
            
            
        }   
            
        
    }
    
    
    
    
    ListNode curr1=headA;
    ListNode curr2=headB;
    ListNode prev1=null;
    ListNode prev2=null;
    
    
    ListNode head=null;
    
   
    if(headA.val>=headB.val)
    {
        head=curr2;
         prev2=curr2;
            curr2=curr2.next;
            prev2.next=curr1;
            
            if(prev1!=null)
            prev1.next=prev2;
            
            prev1=prev2;
            
            prev2=null;  
        
    }
    else
    {
        head=curr1;
        prev1=curr1;
        curr1=curr1.next;
        
        
    }
    
    
    
    while(curr1!=null && curr2!=null)
    {
        if(curr1.val<curr2.val)
        {
            prev1=curr1;
            curr1=curr1.next;
        }
        else
        {
            prev2=curr2;
            curr2=curr2.next;
            prev2.next=curr1;
            
            if(prev1!=null)
            prev1.next=prev2;
            
            prev1=prev2;
            
            prev2=null;
        }
        
        
        
    }
    
    if(curr1==null && curr2!=null)
       prev1.next=curr2;
    
      
    return head;
    
    }
 
   
 
    // Utility function to get the middle of the linked list
    ListNode getMiddle(ListNode h) 
    {
        //Base case
        if (h == null)
            return h;
        ListNode fastptr = h.next;
        ListNode slowptr = h;
         
        // Move fastptr by two and slow ptr by one
        // Finally slowptr will point to middle node
        while (fastptr != null)
        {
            fastptr = fastptr.next;
            if(fastptr!=null)
            {
                slowptr = slowptr.next;
                fastptr=fastptr.next;
            }
        }
        return slowptr;
    }    
    

}
