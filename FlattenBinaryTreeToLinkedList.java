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
    public void flatten(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null)
            return;
        
        TreeNode left  = root.left;
        TreeNode right = root.right;
        root.left = null;
        if(left != null){
            root.right = left;      	  
            TreeNode rightmost = left;
            while(rightmost.right!=null)
                rightmost = rightmost.right;
            rightmost.right =  right;
        }else
            root.right = right;
       
        flatten(left);
        flatten(right);
        
    }
}