/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
void deleteNode(struct ListNode* node) {
   
    struct ListNode* ptr=node->next;
    node->val=ptr->val;
    node->next=ptr->next;
    ptr->next=NULL;
    
    free(ptr);
    

    
}
