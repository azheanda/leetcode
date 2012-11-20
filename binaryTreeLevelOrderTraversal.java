/*
    It's not hard to come up with BFS and 2 queues.
    In fact, we can also do this with BFS and 1 queue. http://www.leetcode.com/2010/09/printing-binary-tree-in-level-order.html
    And even DFS http://www.leetcode.com/2010/09/binary-tree-level-order-traversal-using_17.html
                  or http://www.geeksforgeeks.org/archives/2686
*/

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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);         
        
        while(q.peek()!=null){
            Queue<TreeNode> p = new LinkedList<TreeNode>();
            ArrayList<Integer> clvl = new ArrayList<Integer>();
            
            while(q.peek()!=null){
                TreeNode node = q.poll();
                clvl.add(node.val);
                if(node.left!=null)
                    p.add(node.left);
                if(node.right!=null)
                    p.add(node.right);                
            }
            res.add(clvl);
            q = p;

        }
        
        return res;
    }
}