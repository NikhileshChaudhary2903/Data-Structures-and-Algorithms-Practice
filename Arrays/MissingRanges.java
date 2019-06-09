public static List<String> findMissingRanges(int[] nums, int lower, int upper) {

        List<String> ans = new ArrayList<>();
        int start = 0;

        if(nums[start] > lower) {
          ans.add(addRange(lower,nums[start] - 1));
        }
        else {

        // lower is bigger/equal than nums[0]
        while(start < nums.length && nums[start] < lower)
        start++;

        if(nums[start] > lower) {
            ans.add(addRange(lower,nums[start] - 1));
        }
        }

        int i = start;

        while (i < nums.length && nums[i] < upper) {

        int j = 0;
        int current = nums[i];

        while (i + j < nums.length && nums[i + j] == current && nums[i + j] < upper && current < upper) {
            j++;
            current++;
        }

        if( i + j != nums.length && current < upper && nums[i + j] - 1 < upper)
        ans.add(addRange(current, nums[i + j] - 1));
        else
        {
           if(current < upper)
            ans.add(addRange(current,upper));
        }

        i += j;

        }

        return ans;
    }
