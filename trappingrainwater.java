/*
	http://www.leetcode.com/groups/google-interview/forum/topic/rain-water-trap/
*/

public class Solution {
    public int trap(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function

        int area = 0;
        int n = A.length;
        int[] R = new int[n];
        int[] L = new int[n];

           int rmax=0,lmax=0;

       	for(int i=0;i<n;i++){
       		L[i] = lmax;
       		if(lmax < A[i])
       			lmax = A[i];

       		R[n-i-1] = rmax;
       		if(rmax < A[n-i-1])
       			rmax = A[n-i-1];
       	}

       	for(int i=0;i<n;i++)
       		if(A[i]<Math.min(R[i],L[i]))
       			area += Math.min(R[i],L[i])-A[i];

       	return area;


    }

}