/*
	Note: In Arrays.binarySearch(array,target), if it can't find the target, it won't simply return -1.

	Another interesting solution from my cousin:https://github.com/azheanda/leetcode-1/blob/master/search_a_2d_matrix.cpp
*/

import java.util.Arrays;
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int level = matrix.length-1;
        for(int i=0;i<matrix.length;i++){
    		if(target<matrix[i][0]){
    			level = i-1; 
    			break;
    		}
        }

    	if(level>=0)
    		return Arrays.binarySearch(matrix[level],target)<0?false:true;
    	else 
    		return false;
    }

}