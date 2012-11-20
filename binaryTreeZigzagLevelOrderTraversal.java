/*
    It's similar to binaryTreeLevelOrderTraversal except we use stack and do some 
    minor change. 
/*
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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root==null)  return res;
        Stack<TreeNode> q = new Stack<TreeNode>();
        q.push(root);
        boolean leftToRight = true;
            
        while(!q.empty()){
            Stack<TreeNode> p = new Stack<TreeNode>();
            ArrayList<Integer> clvl = new ArrayList<Integer>();
            
            while(!q.empty()){
                TreeNode node = q.pop();
                clvl.add(node.val);
                if(leftToRight){
                    if(node.left!=null)
                        p.push(node.left);
                    if(node.right!=null)
                        p.push(node.right); }  
                else{
                    if(node.right!=null)
                        p.push(node.right);
                     if(node.left!=null)
                        p.push(node.left); }                        
            }
            leftToRight=!leftToRight;
            res.add(clvl);
            q = p;

        }
        
        return res;
    }
}