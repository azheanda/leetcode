public class Solution {
    public int searchInsert(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int lo = 0, hi = A.length-1, mid = hi/2;

        while(lo<=hi){
            mid = (lo+hi)/2;
            if(target == A[mid])
        		return mid;
        	else if(target > A[mid]){
        		if(lo==hi)
        			return mid+1;
        		lo = mid+1;
        	}
        	else{
        		if(lo==hi)
        			return mid;
        		hi = mid-1;
        	}
        }
        return mid;

    }
}