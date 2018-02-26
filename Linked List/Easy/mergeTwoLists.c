/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */


//  5 6 7
struct ListNode* mergeTwoLists(struct ListNode* l1, struct ListNode* l2) {
    
    
    struct ListNode* res=NULL;
    
    if(l1==NULL)
    return l2;
    
    else if(l2==NULL)
    return l1;
    
    if(l1->val <=l2->val)
    {
    res=l1;    
    res->next= mergeTwoLists(l1->next,l2);   
    }
    else
    {
    res=l2;    
    res->next= mergeTwoLists(l1,l2->next);   
    }     
    
    return res;
}
