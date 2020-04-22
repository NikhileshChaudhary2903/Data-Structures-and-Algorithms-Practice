 
 // https://leetcode.com/problems/permutations
 
 public static List<List<Integer>> permute(int[] nums) {
	    
		  Arrays.sort(nums);
		  boolean visited[] = new boolean[nums.length];
		  List<List<Integer>> ans = new ArrayList<>();
		  
		  backtrackPermute(nums, ans, new ArrayList<>(), 0, visited);
		  return ans;
	    }
	  
	  private static void backtrackPermute(int[] nums, List<List<Integer>> ans, List<Integer> inner, int i, boolean[] visited) {
		
		  // goal
		  if(i == nums.length) {
			  ans.add(new ArrayList<>(inner));
			  return;
		  }
		
		  for(int j = 0; j < nums.length ;j++) {
			  
			  if(visited[j] == false) { // contrsaints
				  inner.add(nums[j]);
				  visited[j] = true;
				  backtrackPermute(nums, ans, inner, i + 1, visited);
				  visited[j] = false;
				  inner.remove(inner.size() - 1);
			  }
		  }
	}
