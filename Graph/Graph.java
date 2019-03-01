import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import javax.print.attribute.HashAttributeSet;

public class Graph {

	int V;
	LinkedList<Integer> adjList[];

	Graph(int v){
		this.V = v;
		this.adjList = new LinkedList[v+1];

		// init adjacency list for each node
		for(int i=1;i<=v;i++)
			this.adjList[i] =new LinkedList<>();

	}

	public void addUndirectedEdge(int i,int j) {
		this.adjList[i].add(j);
		this.adjList[j].add(i);

	}

	void printGraph() {

		for(int i=1;i<=this.V;i++)
		{
			System.out.println("adjacency list for node "+i);	
			StringBuilder sb =new StringBuilder(String.valueOf(i));

			for(int u:this.adjList[i])
			{
				sb.append("->").append(u);
			}
			System.out.println(sb);

		}

	}

	//	public LinkedList<Integer> getAdjList(int i)
	//	{
	//	 return this.adjList[i];		
	//	}

	void bfs(int i) {

		// visited set
		Set<Integer> set =new HashSet<>();
		Queue<Integer> q = new LinkedList<>();	

		q.add(i);

		while(!q.isEmpty())
		{
			int f= q.poll();	

			if(!set.contains(f))
			{
				set.add(f);
				System.out.println(f);
			}

			for(int u:this.adjList[f])
			{
				if(!set.contains(u))
				{	
					q.add(u);
				}
			}

		}

	}

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



