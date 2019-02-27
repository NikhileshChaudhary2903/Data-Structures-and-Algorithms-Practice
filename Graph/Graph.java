import java.util.LinkedList;

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
	
	void bfs() {
		
	
		
		
	}
	
	
	
	
}
