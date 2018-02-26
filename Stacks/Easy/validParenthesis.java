class Solution {
    public boolean isValid(String s) {
        
        char []str=s.toCharArray();
    
    Stack<Character>stk=new Stack<>();
    
    for(int i=0;i<str.length;i++)
    {
    
    	if(str[i]=='(' || str[i]=='[' || str[i]=='{' )
    	stk.push(str[i]);
    	
    	else if( ( str[i]==')' || str[i]==']'  || str[i]=='}') && stk.isEmpty())
    	{
    		return false;
    	}


    	else if((str[i]==')' && stk.peek()=='(') ||( str[i]==']' && stk.peek()=='[' )|| (str[i]=='}' && stk.peek()=='{' ))
    	{
    		stk.pop();
    	}
    	
    	else 
    		return false;
    }
    		
    if(stk.isEmpty())
    return true;
    
    else 
   return false; 	
    
        
        
        
    }
}
