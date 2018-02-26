class Solution {
    public int evalRPN(String[] tokens) {
        
        
        
        Stack<Integer> stk=new Stack<>(); 
        
        int a=0,b=0,r=0;
        
        for(String s:tokens)
        {
            if(isNumeric(s))
            stk.push(Integer.parseInt(s));
            
            else
            {
               a=stk.pop();
               b=stk.pop(); 
               
               if(s.equals("+")) 
               r=a+b;
                
               else if(s.equals("-")) 
               r=b-a;
                
               else if(s.equals("/"))
               r=b/a;    
               
               else
               r=b*a;    
               
               stk.push(r); 
            }
            
        }
        
        
       return stk.peek(); 
            
    }

public boolean isNumeric(String s) {  
    return s != null && s.matches("[-+]?\\d*\\.?\\d+");  
} 

}

