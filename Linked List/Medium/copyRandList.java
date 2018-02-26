/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        
        
        if(head==null)
        return null;
        
        if(head.next==null)
        {
           RandomListNode ne=new RandomListNode(head.label);
                
            if(head.random==head)
            ne.random=ne;
            else
            {
                
             ne.random=null;   
            }  
            
            ne.next=null;
            
            return ne;
            
            
        }
        
        
       RandomListNode temp=head;
        
       RandomListNode temp1=null;
 
        RandomListNode nxt=null;
        
        // insert dup list
       while(temp!=null) 
       {
         nxt=temp.next;
           
         temp1=new RandomListNode(temp.label);
           
         temp1.next=nxt;  
           
         temp.next=temp1;
           
           temp=nxt;
           
           temp1=null;
           
       }
        
        // set random pointers of dup lsit
        
        temp=head;
        temp1=head.next;
        
        
        while(temp!=null && temp1!=null)
        {
            
            if(temp.random!=null)
            temp1.random=temp.random.next;
            else
            temp1.random=null;
            
            
          temp=temp1.next;
          
          if(temp!=null)    
            temp1=temp.next;
             
              
        }
        
        RandomListNode nl=head.next;
        
        temp=head;
        temp1=head.next;
        
    
            
        RandomListNode n=null,nn=null;
        
        while(temp!=null && temp1!=null)
        {
            n=temp1.next;
            
            if(n!=null)
            nn=n.next;
            else
            nn=null;  
            
           temp.next=n;
           temp1.next=nn; 
            
           temp=n;
            temp1=nn;
            
    
        }
       
        return nl;
        
        
    }
}
