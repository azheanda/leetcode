/*
    At the beginning, I wrote something like pow(pow(x,n/2),2), which generates infinite loop and leads to stackoverflow error.

*/

public class Solution {
    public double pow(double x, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(x==0 && n==0)
            return 1;
            
        if(x==0)
            return 0;
    
        if(n>0){
            if(n%2==0){
                double t =pow(x,n/2); 
                return t*t;
            }
            else if(n%2>0)
        	    return pow(x,n-1)*x;
        }
        
        if(n<0){
        	if(n==Integer.MIN_VALUE)
        		return 1.0/(pow(x,Integer.MAX_VALUE)*x);
        	else
            	return 1.0/pow(x,-n); 
         }
        
        return 1;
        
    }
}