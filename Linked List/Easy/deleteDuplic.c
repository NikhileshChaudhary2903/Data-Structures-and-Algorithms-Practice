/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* deleteDuplicates(struct ListNode* head) {
    
  struct ListNode* ptr=head;
    
  struct ListNode* nptr=head;   
    
    while(ptr!=NULL && ptr->next)
    {
       
        if(ptr->val!=ptr->next->val) 
        ptr=ptr->next;
        
        else
        {
         nptr=ptr->next;
         ptr->next=nptr->next;
         nptr->next=NULL;
         free(nptr);  
        }
        
    }
    
  return head;  
    
}
