
	void dfs(int i) {
		
		// visited set
		Set<Integer> set =new HashSet<>();
		Stack<Integer> stack =new Stack<>();
		
		stack.push(i);
		
		while(!stack.isEmpty())
		{
		 int top = stack.pop();	
		 
		 if(!set.contains(top))
		 {
			 set.add(top);
			 System.out.println(top);
		 }
		
			 for(int u:this.adjList[top])
				{
					if(!set.contains(u))
					{	
					stack.push(u);
					}
				} 
			 
		 }
		 
		}
		
		
		
	}
