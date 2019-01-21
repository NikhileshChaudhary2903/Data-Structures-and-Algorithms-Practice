public static boolean checkOneAway(String s,String t) {
		
		if(Math.abs(s.length()-t.length()) > 1)
		return false;	
		
		boolean flag=false;
		// assume s is the longer string
		if(s.length()<t.length())
		return checkOneAway(t,s); 
		
		boolean isSame= (s.length()==t.length() );
		int i=0,j=0;
		
		for(;i<s.length() && j<t.length();)
		{
		if(s.charAt(i)==t.charAt(j))
		{
			i++;
			j++;
		}
		else {
			
		if(flag)	
			return false;
		
		// same length
		if(isSame) {
			i++;
			j++;
		}	
		else {
			i++;
		}	
		flag=true;	
		}	
			
		}
		
	return true;
		
	}
