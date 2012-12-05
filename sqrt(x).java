    /*
	This one is tricky specially in dealing with very large int input.
*/



public class Solution {
    public int sqrt(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        long lo = 0;
        long hi = x;

        while(hi>=lo){     
            long mid = lo+(hi-lo)/2;
            if(x<mid*mid)
                hi = mid-1;      // not hi = mid
            else
                lo = mid+1;    
        }
        return (int)hi;
    }
}

// or

public class Solution {
    public int sqrt(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        long lo = 0;
    	long hi = x;

    	while(hi>lo){     
            long mid = lo+(hi-lo+1)/2;
    		if(x<mid*mid)
    			hi = mid-1;      // not hi = mid
    		else
    			lo = mid;    
    	}
    	return (int)lo;
    }
}	

/*
The following version also works, but it's not as elegant.

public class Solution {
    public int sqrt(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int lo = 0;
    	int hi = x+1;

    	while(hi-lo>1){     
            int mid = (lo+hi)/2;
    		if(x<(long)mid*mid)     // convert mid*mid to long
    			hi = mid;    // not mid-1
    		else
    			lo = mid;    // not mid+1
    	}
    	return x==1?1:lo;     // otherwise if x==1, lo==0, so I can't just return lo.
    }
}	
*/