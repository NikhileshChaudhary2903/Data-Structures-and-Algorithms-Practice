/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

//1 2 3 4 
    
    
bool hasCycle(struct ListNode *head) {
    
    struct ListNode *fast=head;
    struct ListNode *slow=head;
    
    int flag=0;
    
    while(fast && slow && fast->next)
    {
        
          slow=slow->next;   
           fast=fast->next->next;  
             
         
       if(slow==fast) 
       {
           return true;
       }     
        
           
    }
    
    return false;
    
    
}
