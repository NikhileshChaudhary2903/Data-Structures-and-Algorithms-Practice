 // https://leetcode.com/problems/permutations/
 
 public static List<List<Integer>> permute(int[] nums) {
	    
		  Arrays.sort(nums);
		  List<List<Integer>> ans = new ArrayList<>();
		  
		  backtrackPermute(nums, ans, new ArrayList<>(), 0);
		  return ans;
	    }
	  
	  private static void backtrackPermute(int[] nums, List<List<Integer>> ans, List<Integer> inner, int i) {
		
		  // goal
		  if(i == nums.length) {
			  ans.add(new ArrayList<>(inner));
			  return;
		  }
		
		  for(int j = 0; j < nums.length ;j++) {
			  
			  if(!inner.contains(nums[j])) { // contrsaints
				  inner.add(nums[j]);
				  backtrackPermute(nums, ans, inner, i + 1);
				  inner.remove(inner.size() - 1);
			  }
		  }
	}
