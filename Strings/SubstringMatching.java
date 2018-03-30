public static void findPatternInText(String t,String p)
	{
		
		int n=t.length();
		int m=p.length();
		
		int k=0;
		int shift=-1;
		
		for(int i=0;i<=n-m;i++)
		{
			k=0; 
			int j=0;
		   while(j<m && p.charAt(j)==t.charAt(i+k) )	
		   {
			   j++;
		       k++; 
 		   }   
		   if(j==m)
			 {
			   shift=i;
			   break;  
			 }
			   
		}
		
		System.out.println(shift);
		
	}
