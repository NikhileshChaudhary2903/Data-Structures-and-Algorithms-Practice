public static String urlify(String str,int truelength) {
	
	str=str.trim();
	int spaces=0;
	
	for(int i=0;i<str.length();i++)
	{
		if(str.charAt(i)==' ')
			spaces++;
	}
	
	int newLength=truelength + 2* ( spaces);
	char ch[]=new char[newLength];
	
	for(int i=newLength-1,j=truelength-1; i>=0 && j>=0 ;)
	{
		if(str.charAt(j)!=' ')
		{
			ch[i]=str.charAt(j);
			i--;
			j--;
		}
		else {
			
			ch[i]='0';
			ch[i-1]='2';
			ch[i-2]='%';
			
			i-=3;
			j--;
		}
		
	}
	
	
	return new String(ch);
	
	
}
