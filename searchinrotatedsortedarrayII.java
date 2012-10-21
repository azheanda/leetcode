/*
    I vaguely remember this problem in the book, cracking code interview
*/

public class Solution {
    public boolean search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
     	int start = 0;
 		int end = A.length-1;

 		while(start<=end){
 			int mid = (start+end)/2;
 			if(A[mid] == target) 
                return true;
            else if(A[start] == A[mid])
                start++;
 			else if(A[start]<A[mid]){
 				if(A[mid]>target && A[start]<=target)
 					end = mid-1;
 				else
 					start = mid+1;
 			}else{
 				if(A[mid]<target && A[end]>=target)
 					start = mid+1;
 				else
 					end = mid-1;
 			}
 		}
 		return false;
    }


}