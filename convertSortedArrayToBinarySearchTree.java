/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return sortedArrayToBST(num,0,num.length-1);
    }

    public TreeNode sortedArrayToBST(int[] num, int lo, int hi){
        if(lo<hi){
    		int mid = (lo+hi)/2;
    		TreeNode root = new TreeNode(num[mid]);
    		TreeNode left = sortedArrayToBST(num,lo,mid-1);
    		TreeNode right = sortedArrayToBST(num,mid+1,hi);
    		root.left = left;
    		root.right = right;
    		return root;
    	}else if(lo==hi)
    		return new TreeNode(num[lo]);
    	else
    		return null;
    }
}
