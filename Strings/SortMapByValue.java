class ValueComparator implements Comparator<Character>{
 
	HashMap<Character, Integer> map = new HashMap<Character, Integer>();
 
	public ValueComparator(HashMap<Character, Integer> map){
		this.map.putAll(map);
	}
 
	@Override
	public int compare(Character c1, Character c2) {
		if(map.get(c1) >= map.get(c2)){
			return -1;
		}else{
			return 1;
		}	
	}
}

class Solution {
    
    public static TreeMap<Character, Integer> sortMapByValue(HashMap<Character, Integer> map){
		Comparator<Character> comparator = new ValueComparator(map);
		//TreeMap is a map sorted by its keys. 
		//The comparator is used to sort the TreeMap by keys. 
		TreeMap<Character, Integer> result = new TreeMap<Character, Integer>(comparator);
		result.putAll(map);
		return result;
	}
    
    
    
    public static String frequencySort(String s) {
        
        if(s.length() < 2)
            return s;
        
        HashMap<Character,Integer> hmap = new HashMap<>();
        
        for(char ch:s.toCharArray())
        {
           if(!hmap.containsKey(ch)) 
            hmap.put(ch,1);
           else
            hmap.put(ch,hmap.get(ch)+1);   
        }
        
        TreeMap<Character,Integer> tmap = sortMapByValue(hmap);
        
                System.out.println(tmap);

        StringBuilder sb = new StringBuilder();
        
       for(Map.Entry<Character, Integer> entry:tmap.entrySet())
	       {
	    	   Character ch = entry.getKey();
	    	   int val = entry.getValue();
	    	   for(int i=0;i<val;i++)
		    		  sb.append(ch);
	       }
        
        return sb.toString();
    }
}
