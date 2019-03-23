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
	
		// i to j
	public void addDirected(int i,int j) {
		this.adjList[i].add(j);
	}

	public void dfsRecursive(Map<Integer, Integer> map) {

		int[] flag= new int[this.V];

		// 0 means white and all vertices will be white
		// 1 means visted but all children not yet explored
		// 2 means done and dusted ie visited plus all children explored

		for(int i=0;i<this.V;i++)
		{
			// if it is not visited yet
			if(flag[i]==0)	
				dfsUtil(flag,i,map);
		}
	}

	public void dfsUtil(int []flag,int i,Map<Integer, Integer> map) {

		// visite the node
		flag[i] = 1;
		System.out.println(i);

		for(int u:this.adjList[i])
		{
			if(flag[u]==0) {
				dfsUtil(flag, u,map);
				map.put(u,i); // u got its label in dfs from i ie traversing adjacency list 
			}
		}

		flag[i] = 2; // done and dusted node
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



