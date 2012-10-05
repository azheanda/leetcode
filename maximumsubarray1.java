/*
	This is a little different from the classic maximum subarray problem,which
	we can solve by Kadane's algorithm. In that problem, the subarray is allowed to contain none element whereas in this one, the subarray contains
	a least one element. But it only requires a minor modification of the kadane's algorithm to solve this one.

*/


public class Solution {
    public int maxSubArray(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function

    	int max_ending_here = 0;
		int max_so_far =Integer.MIN_VALUE;  // modification here

        for(int i = 0; i < A.length; i++) {
			max_ending_here =Math.max(A[i],max_ending_here+A[i]);// and here
			max_so_far = Math.max(max_so_far,max_ending_here);
		}

		return max_so_far;
        
        
    } 
}