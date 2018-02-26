
class Solution {
    
    private static final int[] no = {};

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
     
        if(nums1.length==0 && nums2.length==0)
         return no;
        
        
            
        int res[]=new int[nums1.length];
        
 	      Map<Integer,Integer> m=new HashMap<>();
	        
	      Stack<Integer> stk=new Stack<>();
	        
	      stk.push(nums2[0]);
	        
	      for(int i=1;i<nums2.length;i++)  
	      {
	        int next=nums2[i];  
	         
	       while(!stk.empty() && next>stk.peek() )   
	       {
	         m.put(stk.peek(),next);  
	         stk.pop();    
	       }
	          
	    
	          stk.push(next);
	         
	      }
	      
	      
	      while(!stk.empty())
	      {
	    	m.put(stk.peek(),-1);  
	    	stk.pop();  
	      }
	      
       
        for(int i=0;i<nums1.length;i++)
        {
         res[i]=m.get(nums1[i]);
        }
            
          return res;
        
    }
    
  
  
    
    
}
