public class Solution {
    public int[] searchRange(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] res = new int[2];
        res[0] = search(A, target-1)+1;
        res[1] = search(A, target);
        if(res[1] == -1 || A[res[1]] != target){
            res[0] = -1;
        	res[1] = -1;
        }
        return res;

    }

    // return the biggest index of the element that is <= target
    // if all the elements in A is > x, return -1;
    public int search(int [] A, int target){
 		int start = 0, end = A.length-1, mid = end/2;
 		int res = -1;

 		while(start<=end){
 			if(A[mid]>target)
 				end = mid-1;
 			else {
 				start = mid+1;
 				res = mid;
 			}
 			mid = (start+end)/2;
 		}
 		return res;

    }
}