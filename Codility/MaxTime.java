
public class CodilityTest {

	
	
	public String generate(int A, int B,int  C,int  D) {
	    int vals[] = {A, B, C, D};
	  int [] counts = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	    for (int i = 0; i < vals.length; i++) {
	        for (int j = vals[i]; j < counts.length; j++) counts[j]++;
	    }
	    for(int x:counts)
	    	System.out.print(x+ " ");
	    // counts is now populated with the number of values less than or equal to the index it belongs to
	    // so counts[2] is the total number of 0's, 1's and 2's
	    // all values greater than 2
	    if (counts[2] == 0) 
	    return new String("NOT POSSIBLE");	    
//	    

	    // if there are no 0's and 1's, then it must start with 2
	    boolean mustStartWith2 = (counts[1] == 0);
	 	System.out.println(mustStartWith2);
	 	
	 	
	 	// starts with 2 and rest all greater than 3
	 	if (mustStartWith2 && counts[3] == 1) return new String("NOT POSSIBLE");
	
// We want a count of the number of free digits that are 5 or less (for the minute digit)
    int numbersAvailableForMinute = counts[5] - (mustStartWith2 ? 2 : 1); 
    
    System.out.println(numbersAvailableForMinute);
    
	    if (numbersAvailableForMinute == 0) 
	    	return new String("NOT POSSIBLE");
	
	    
	    // we now know that it is a valid time
      int []time = new int[] {0, 0, 0, 0};
   

//	    // we also know if it starts with 2
	    boolean startsWith2 = (mustStartWith2) || (numbersAvailableForMinute >= 2 && counts[2] > counts[1]);
//	    // knowing the starting digit, we know the maximum value for each digit

	    int maxs[];
	    
	   	if(startsWith2==true)
	   	maxs= new int[]{2, 3, 5, 9};
	   	else 
	   	maxs= new int[]{1, 9, 5, 9};
		   		
	   	
	   	
	    for (int i = 0; i < maxs.length; i++) {
//	        // find the first occurrence in counts that has the same count as the maximum
	        int val=counts[maxs[i]];

	        int ind=0;
	       
	        for(int k=0;k<counts.length;k++)
	        {
	        	if(val==counts[k])
	        	{	
	    		 ind=k;
	        	 break;
	        	}
	        }	 
//	    	        time[i] = counts.indexOf(counts[maxs[i]]);
	         time[i]=ind;
//	        // update counts after the value was removed
        for (int j = time[i]; j < counts.length; j++) counts[j]--;
	    }
//	    // create the time
	    return new String(time[0]+""+time[1]+":"+time[2]+""+time[3]);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.out.println(new CodilityTest().generate(9, 3, 5, 1));
	}

}
