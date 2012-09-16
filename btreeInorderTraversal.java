/*
    Iterative Binary Tree Inorder Traversal.
    For Preoder and Postoerder, please refer to http://www.brilliantsheep.com/iterative-binary-tree-traversal-in-java/
*/


/*
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.*;
public class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node= root;
        
        while(!stack.isEmpty() || node!=null){
            if(node != null){
                stack.push(node);
                node = node.left;
            }else {
                node = stack.pop();
                result.add(node.val);            
                node = node.right;
            }
        }
        return result;
        
    }
}