public static int lengthOfLongestSubstringTwoDistinct(String str) {

		Map<Character,Integer> map =new HashMap<Character,Integer>();

		int s=0,e=0,maxLen=Integer.MIN_VALUE;

		map.put(str.charAt(0), 1);

		for(int i=1;i<str.length();i++)
		{
			if(!map.containsKey(str.charAt(i)))	
			{
				map.put(str.charAt(i), 1);
			}
			else {
				map.put(str.charAt(i), map.get(str.charAt(i) ) +1);
			}
			
			if(map.size()<=2)
			{
				e=i;
				maxLen=Math.max(maxLen, e-s+1);	
				continue;
			}
			
			int cnt_unique=0;

			for(Character ch:map.keySet())
			{
				if(map.get(ch)!=0)
					cnt_unique++;
			}
			
			
			while(cnt_unique>2)
			{
			map.put(str.charAt(s), map.get(str.charAt(s) ) -1);
			cnt_unique=0;

			for(Character ch:map.keySet())
			{
				if(map.get(ch)!=0)
					cnt_unique++;
			}
			s++;
			}
			
			if(cnt_unique<=2)
			{
				e=i;
				maxLen=Math.max(maxLen, e-s+1);	
			}
			
			
			
		}
		
		return maxLen;

	}
