class Solution {
    public int findUnsortedSubarray(int[] a) {
         int i=0,j=a.length-1;
		 
		 while(i< a.length-1 && a[i]<=a[i+1])
			i++; 
		
		 // sorted array increasing
		 if(i==a.length-1)
			 return 0;
		 
		 while(j>0 && a[j]>=a[j-1])
				j--; 
		
		 if(i==0 && j==a.length-1)
		 return a.length;
			 
		 int min=a[i],max=a[i];
		 
		 for(int k=i;k<=j;k++) {
			 
			 if(a[k]<=min)
			 min=a[k];
			 
			 if(a[k]>=max)
				max=a[k]; 
		 }
		int minind=0,maxind=a.length-1;
		 
		while(minind<=i)
		{
			if(a[minind]<=min)
			{
				minind++;
			}
			else
				break;
		}
		
		while(maxind>=j)
		{
			if(a[maxind]>=max)
			{
				maxind--;
			}
			else
				break;
		}
		
//		System.out.println(minind);
//		System.out.println(maxind);
		
		 return maxind-minind+1;
    }
}
