public static List<String> topKFreqWords(String reviews[],String keywords[], int k) {
		
		Map<String, Integer> freqMap = new HashMap<>();
		
		for(String keyword: keywords)
			freqMap.put(keyword.toLowerCase(), 0);
		Set<String> seen = new HashSet<>();
		
		for(String review: reviews) {
			seen = new HashSet<>();
			for(String word: review.split("\\W")) {
				if(freqMap.containsKey(word.toLowerCase()) && !seen.contains(word.toLowerCase())) {
					freqMap.put(word.toLowerCase(), freqMap.get(word.toLowerCase()) + 1);
					seen.add(word.toLowerCase());
				}	
			}
		}
//		System.out.println(freqMap);
		
		PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<String,Integer>>() {

			@Override
			public int compare(Entry<String, Integer> p1, Entry<String, Integer> p2) {
				// TODO Auto-generated method stub
				if(p1.getValue() == p2.getValue()) {
					return p1.getKey().compareTo(p2.getKey());
				} else
					return Integer.compare(p2.getValue(), p1.getValue());
			}
		});
		
		pq.addAll(freqMap.entrySet());
		
		List<String> res = new ArrayList<>();

		while(!pq.isEmpty() && k-- > 0) {
			res.add(pq.poll().getKey());
		}
		return res;
	}
