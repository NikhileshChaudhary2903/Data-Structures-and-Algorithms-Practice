
//lazy approach
public class QuickUnionApproach {
	
	private int ids[];
	public QuickUnionApproach(int n) {
		ids = new int[n];
		
		for(int i = 0; i < n;i++) {
			ids[i] = i;
		}
	}
	
	public int getRoot(int p) {
		int parentid = ids[p];
		
		while(parentid != ids[parentid]) {
			parentid = ids[parentid];
		}
		return parentid;
	}
	
	// find operation
	public boolean isConnected(int p,int q) {
		return this.getRoot(p) == this.getRoot(q);
	}
	
	public void union(int p,int q) {
		int parentidOfP = getRoot(p);
		int parentidOfQ = getRoot(q);
		
		ids[parentidOfP] = parentidOfQ;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuickUnionApproach quickFind = new QuickUnionApproach(10);
		quickFind.union(4, 3);
		quickFind.union(3, 8);
		quickFind.union(6, 5);
		quickFind.union(9, 4);
		quickFind.union(2, 1);
		
		System.out.println(quickFind.isConnected(0, 7));
		System.out.println(quickFind.isConnected(8, 9));
		
		quickFind.union(7, 2);
		quickFind.union(6, 1);
		quickFind.union(5, 0);
		System.out.println(quickFind.isConnected(0, 7));

	}

}
