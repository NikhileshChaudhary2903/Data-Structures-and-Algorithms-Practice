class Solution {
    
    	public static int lenNumber(int n) {
		int c=0;
		while(n!=0) {
			n=n/10;
			c++;
		}
		return c;
	}
    public int compress(char[] a) {
      
        
		 if(a.length==1)
			 return 1;
		 
		 int count=1,j=0;
		 
		 for(int i=0;i<a.length;i++)
		 {
			 count=1;
			 a[j]=a[i];
			 
			 while(i<a.length-1 && a[i]==a[i+1])
			 {
				 i++;
				 count++;
			 }
			 
				 
			 if(count>1) {
				 int r;
				 int len=lenNumber(count);
				 j+=len;
				 while(count!=0) {
					 r=count%10;
					a[j--]= (char) (r+ '0');
					count=count/10;
				 }
				 j+=len+1;
			 }
			 else 
				 j++;
		
		 }
		 
//		 System.out.println(s);
		 a=new String(a).substring(0,j).toCharArray();
		//System.out.println(a);		
		 return j;
    }
}
