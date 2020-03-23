import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuickFindUnion {
	
	private int ids[];
	public QuickFindUnion(int n) {
		ids = new int[n];
		
		for(int i = 0; i < n;i++) {
			ids[i] = i;
		}
	}
	
	//find operation O(1)
	public boolean isConnected(int p,int q) {
		return this.ids[p] == this.ids[q];
		
	}
	
	//union operation O(n)
	public void union(int p,int q) {
		
		int pid = ids[p];
		int qid = ids[q];
		
		for(int i = 0; i < ids.length;i++) {
			if(ids[i] == pid) ids[i] = qid;
		}
	}
	
	public List<List<Integer>> getAllConnectedComponents(){
		
		List<List<Integer>> list=new ArrayList<>();
		
		Map<Integer, List<Integer>> map = new HashMap<>();
		
		for(int i = 0; i < ids.length;i++) {
			int currentId = ids[i];
			
			if(!map.containsKey(currentId)) {
				map.put(currentId, new ArrayList<>());
			}
			map.get(currentId).add(i);
		}
		
		List<Integer> largestComponent = findLargestConnectedComponent(map);
		System.out.println("largest connected component is " + largestComponent);
		list.addAll(map.values());
		return list;
		
	}
	private List<Integer> findLargestConnectedComponent(Map<Integer, List<Integer>> map) {
		// TODO Auto-generated method stub
		List<Integer> ans = new ArrayList<>();
		
		int maxSize = Integer.MIN_VALUE;
		
		for(Map.Entry<Integer, List<Integer>> entry: map.entrySet()) {
			if(maxSize < entry.getValue().size()) {
				maxSize = entry.getValue().size();
				ans = entry.getValue();
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuickFindUnion quickFind = new QuickFindUnion(10);
		quickFind.union(4, 3);
		quickFind.union(3, 8);
		quickFind.union(6, 5);
		quickFind.union(9, 4);
		quickFind.union(2, 1);
		System.out.println(quickFind.getAllConnectedComponents());
	
		System.out.println(quickFind.isConnected(0, 7));
		System.out.println(quickFind.isConnected(8, 9));
		quickFind.union(7, 2);
		quickFind.union(6, 1);
		quickFind.union(6, 1);
		quickFind.union(5, 0);
		
		System.out.println(quickFind.isConnected(0, 7));
		System.out.println(quickFind.getAllConnectedComponents());
	  
	}

}
