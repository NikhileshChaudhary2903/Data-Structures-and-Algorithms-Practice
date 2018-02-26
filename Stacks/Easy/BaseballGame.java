class Solution {
    public int calPoints(String[] ops) {
        
        
        int sum=0;
        int b=0;
        
        int ps=0;

    Stack<Integer>stk=new Stack<>();

       for(String s:ops) 
       {
        
           if(isNumeric(s))
        {
            stk.push(Integer.parseInt(s));
            
            if(stk.isEmpty())
            b=0;
            else
            b=stk.peek();    
            
            sum+=b;   
            
        }
          
        else if(s.equals("C"))   
        {
          int t=stk.peek();
           stk.pop();
            
           sum-=t; 
            
            
        }
        else if(s.equals("D"))
        {
           int x=stk.peek(); 
           x=x*2;
            
           stk.push(x); 
           
           sum+=x;
            
        }
         else
         {
            int a=stk.pop();
         b=stk.pop();
             
             ps=a+b;
             sum+=ps;
             
            stk.push(b);
             stk.push(a);
             
             stk.push(ps);
         }
           
           
       }

        return sum;
        
    }
    
    
    public static boolean isNumeric(String str)
{ 
  return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
} 
    
    
}
