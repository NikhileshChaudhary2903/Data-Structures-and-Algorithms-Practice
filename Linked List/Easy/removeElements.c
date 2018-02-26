/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* removeElements(struct ListNode* head, int val) {
    
   
    struct ListNode* curr=head;
    struct ListNode* prev=NULL;
    struct ListNode* node=NULL;
  
    while(curr!=NULL)
    {
      if(head->val==val)  
      {
          node=curr;
          curr=curr->next;
          head=curr;
          node->next=NULL;
          free(node);
      }
       else
       {
         if(curr->val!=val)  
         {
             prev=curr;
             curr=curr->next;
         }
          else{
             node=curr; 
             prev->next=curr->next; 
             curr=curr->next; 
             node->next=NULL;
             free(node); 
              
          } 
           
           
       }    
        
    }
    
    
    return head;
    
}
