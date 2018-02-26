class MyQueue {

    
    Stack<Integer> stk1;
    Stack<Integer> stk2;
    
    /** Initialize your data structure here. */
    public MyQueue() {
        
        stk1=new Stack<>();
        stk2=new Stack<>();
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
    
        stk1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        
        int x;
        
       if(stk2.isEmpty())  
       {
           while(!stk1.isEmpty())
           {
               int t=stk1.pop();
               stk2.push(t);
           }
           
       }
        
        x=stk2.pop();
        
        return x;
    }
    
    /** Get the front element. */
    public int peek() {

         int x;
        
       if(stk2.isEmpty())  
       {
           while(!stk1.isEmpty())
           {
               int t=stk1.pop();
               stk2.push(t);
           }
           
       }
        
        x=stk2.peek();
        
        return x;
        

    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        
        if(stk1.isEmpty() && stk2.isEmpty())
        return true;
        else
            return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
