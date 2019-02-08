public static String getDiffString(String str) {
	
	StringBuilder res=new StringBuilder("");
	
	for(int i=1;i<str.length();i++)
	{
		int diff= str.charAt(i)-str.charAt(i-1);
		
		if(diff<0)
		res.append(String.valueOf(26+diff));
		else
		res.append(String.valueOf(diff));
		
	}
	
	return res.toString();
}

public static List<List<String>> groupStrings(String[] strings) {

Map<String,List<String>> map =new HashMap<>();
List<String> lst=new ArrayList<>();
for(String s:strings) {

	String str=getDiffString(s);
	
	if(!map.containsKey(str))
	{
	lst=new ArrayList<>();	
	lst.add(s);
	map.put(str, lst);
	}
	else {
		map.get(str).add(s);
	}
}

System.out.println(map);
List<List<String>> result = new ArrayList<List<String>>();

for(Map.Entry<String, List<String>> entry: map.entrySet()){
    Collections.sort(entry.getValue());
}

result.addAll(map.values());

//System.out.println(map);

return result;



}
