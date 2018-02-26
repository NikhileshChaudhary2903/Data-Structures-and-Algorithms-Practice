/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

int absol(int a,int b)
{
    
    int diff=a-b;
    
    if(diff>0)
    return diff;
        
    else
    return (-diff);
        
    
}


struct ListNode *findDiff(struct ListNode *headA, struct ListNode *headB,int diff)
{
        

   struct ListNode *p1=headA;
    
    
   struct ListNode *p2=headB;
    
   int c=0;
    
    while(c!=diff)
    {
        c++;
        p2=p2->next;
    }
    
  struct node *intersection=NULL; 
    
    
    while(p1!=NULL && p2!=NULL)
    {
      if(p1==p2)  
      {
          intersection=p1;
          return intersection;
          break;
      }
      else
      {
           p1=p1->next; 
           p2=p2->next;
      }
        
    }
    
    
   return  intersection;
    
}



struct ListNode *getIntersectionNode(struct ListNode *headA, struct ListNode *headB) {
    
    
    
   int c1=0,c2=0;
    
   struct ListNode *curr1=headA;
   struct ListNode *curr2=headB;
    
   while(curr1!=NULL) 
   {
       c1++;
       curr1=curr1->next;
   }
    
   while(curr2!=NULL) 
   {
       c2++;
       curr2=curr2->next;
   }
    
   int diff=absol(c1,c2);
    
    struct ListNode *node=NULL;
    
    if(c1<c2)
    node=findDiff(headA,headB,diff);
    else
    node=findDiff(headB,headA,diff);
    
   
    return node;
    
    
}
