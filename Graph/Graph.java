package com.company;

import java.math.BigInteger;
import java.util.*;

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

    public int countConnectedComponents() {

        int cnt = 0;
        boolean visited[] = new boolean[this.V];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0;i < this.V;i++) {

            if(!visited[i]) {
                cnt++;
                stack.push(i);

                while (!stack.isEmpty()) {

                    int top = stack.pop();
                    visited[top] = true;
                    for(int u:adjList[top]) {
                        if(!visited[u]) stack.push(u);
                    }
                }
            }

        }

        return cnt;

    }

    // i to j
    public void addDirected(int i,int j) {
        this.adjList[i].add(j);
    }

    public void topologicalSort() {

        int deg[] = new int[this.V];

        for(int i = 0;i < this.V;i++)
        {
           for(int u:adjList[i]) {
            deg[u]++;
           }
        }

        Queue<Integer> queue = new LinkedList<>();
        int count = 0;

        for(int i = 0;i < this.V;i++) {
            if(deg[i] == 0) {
               count++;
               queue.add(i);
            }
        }
        List<Integer> list = new ArrayList<>();

        while (!queue.isEmpty()) {
            int front = queue.remove();
            list.add(front);

            for(int u:adjList[front]) {
                deg[u]--;

                if(deg[u] == 0)
                    queue.offer(u);
            }
            count++;
        }

        if(count != this.V) {
            System.out.println("cycle exists");
        }

        System.out.println(list);
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

    void bfswithColors(Map<Integer, Integer> map) {

        int[] flag= new int[this.V];

        for(int i=0;i<this.V;i++)
        {
            if(flag[i]==Color.WHITE.getValue())
                bfswithColors(flag,i,map);
        }

    }

    void bfswithColors(int[] flag, int i,Map<Integer, Integer> map) {
        // TODO Auto-generated method stub

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        flag[i] = Color.GREY.getValue();

        while(!queue.isEmpty()) {
            Integer front = queue.poll();
            System.out.println(front);
            for(int u:adjList[i])
            {
                if(flag[u] == Color.WHITE.getValue())
                {
                    queue.offer(u);
                    flag[u] = Color.GREY.getValue();
                    map.put(u, front);
                }
            }

            flag[front]= Color.BLACK.getValue();

        }

    }

    public boolean checkCycle() {

        int visited[] = new int[this.V];
        Arrays.fill(visited,Color.WHITE.getValue());
        Map<Integer,Integer> parentMap = new HashMap<>();

        for(int i = 0;i < this.V;i++) {

            if(visited[i]==Color.WHITE.getValue())
            {
                if(isCycle(visited,i,parentMap))
                    return true;
//                System.out.println(parentMap);
            }
        }

    return false;
    }

     boolean isCycle(int[] visited, int i, Map<Integer, Integer> parentMap) {

        visited[i] = Color.GREY.getValue();

        for(int v:adjList[i]) {
            if(visited[v] == Color.WHITE.getValue()) {
                parentMap.put(v,i);
                 if(isCycle(visited,v, parentMap))
                     return true;
            }
            else if(parentMap.containsKey(i) && parentMap.get(i)!=v){
                return true;
            }

            }

         visited[i] = Color.BLACK.getValue(); // done and dusted
         return false;

     }



    public static void main(String []args) {

        Graph g =new Graph(9);

        g.addUndirectedEdge(0,1);
        g.addUndirectedEdge(0,2);
        g.addUndirectedEdge(1,8);
        g.addUndirectedEdge(3,4);
//        g.addUndirectedEdge(1,4);
        g.addUndirectedEdge(5,6);
        g.addUndirectedEdge(5,7);



//        HashMap<Integer,Integer> hmap = new HashMap<>();


//        g.dfsRecursive(hmap);

//        System.out.println(hmap);
        g.topologicalSort();

        System.out.println(g.checkCycle());
        System.out.println(g.countConnectedComponents());
        BigInteger res  = BigInteger.valueOf(0);
        long a = res.longValue();
    }

}
