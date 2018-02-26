class MinStack {

    /** initialize your data structure here. */
    
    Stack<Integer> s1;
    Stack<Integer> s2;
    
    public MinStack() {
        
        s1=new Stack<>();
        s2=new Stack<>();
        
    }
    
    public void push(int x) {
        
        s1.push(x);
        
        if(s2.empty()==true)
        s2.push(x);
        
        else if( !s2.empty() && x<=s2.peek() )
        s2.push(x);
            
            
    }
    
    public void pop() {
        
    if(s1.empty())    
        return;
     
    int y=s1.peek();
        
       if(y!=s2.peek()) 
       {
        s1.pop();
       }
       else
       {
           s1.pop();
           s2.pop();
          
       }
        
        
        
    }
    
    public int top() {
        
        return s1.peek();
        
    }
    
    public int getMin() {
     
        return s2.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
