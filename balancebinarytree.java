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
    public boolean isBalanced(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        
        if(root == null) return true;
        int leftSubtreeHeight = height(root.left);
        int rightSubtreeHeight = height(root.right);
        return Math.abs(leftSubtreeHeight-rightSubtreeHeight)<=1 &&
            isBalanced(root.left) && isBalanced(root.right);    
    }
       
    public int height(TreeNode node){
        if(node ==null) return 0;
        
        return 1+Math.max(height(node.left),height(node.right));
    }
    
    
}