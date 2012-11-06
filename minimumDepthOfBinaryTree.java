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
    public int minDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null)  
            return 0;
        else if(root.left!=null && root.right!=null)
            return 1+Math.min(minDepth(root.right),minDepth(root.left));
        else if(root.left!=null)
            return 1+minDepth(root.left);
        else
            return 1+minDepth(root.right);
            
    }
}