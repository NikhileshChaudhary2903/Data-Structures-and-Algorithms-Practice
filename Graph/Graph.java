import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import javax.print.attribute.HashAttributeSet;

enum Color 
{ 
    WHITE(0), GREY(1), BLACK(2);

	private final int value;
    private Color(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
public class Graph {
	
	int V;
	LinkedList<Integer> adjList[];

	Graph(int v){
		this.V = v;
		this.adjList = new LinkedList[v+1];

		// init adjacency list for each node
		for(int i=0;i<v;i++)
			this.adjList[i] =new LinkedList<>();

	}

	public void addUndirectedEdge(int i,int j) {
		this.adjList[i].add(j);
		this.adjList[j].add(i);

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
			if(flag[i]==Color.WHITE.getValue())	
				dfsUtil(flag,i,map);
		}
	}

	public void dfsUtil(int []flag,int i,Map<Integer, Integer> map) {

		// visite the node
		flag[i] = Color.GREY.getValue();
		System.out.println(i);
		
		for(int u:this.adjList[i])
		{
			if(flag[u]==Color.WHITE.getValue()) {
				dfsUtil(flag, u,map);
				map.put(u,i); // u got its label in dfs from i ie traversing adjacency list 
			}
		}

		flag[i] = Color.BLACK.getValue() ; // done and dusted node
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

	void dfsrec(int v,Set<Integer> set) {

		set.add(v);
		System.out.println(v);

		for(int u:this.adjList[v])
		{
			if(!set.contains(u))
				dfsrec(u,set);
		}
	}

	public static void main(String []args) {

		Graph g =new Graph(5);

		g.addDirected(0, 1);
		g.addDirected(0, 3);
		g.addDirected(1, 2);
		g.addDirected(3, 2);
		g.addDirected(2, 4);

		HashMap<Integer,Integer> hmap = new HashMap<>();


		g.dfsRecursive(hmap);
		
		System.out.println(hmap);


	}

}



