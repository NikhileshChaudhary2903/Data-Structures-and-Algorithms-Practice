class Solution {
    public static double myPow(double x, int n) {
                    
                    if(n==0)
		            return 1;
		        
		        else if(n==1)
		            return x;
		        
		        else if(n==-1)
		            return (1/x);
		        
		        double val=myPow(x,n/2);
		        
		        if(n>0) {
		        if(n%2==0){
		            return (val*val);
		        }
		        else
		            return (val*val*x);
		        }
		        else {
		        	 if(n%2==0){
				            return (val*val);
				        }
				        else
				            return (val*val*(1/x));
		        	
		        }
		        
	        
        
	    }
 
}
