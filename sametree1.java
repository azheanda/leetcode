/*
	Note: Queue is simply an interface in Java.
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Queue<TreeNode> tree1 = new LinkedList<TreeNode>();
		Queue<TreeNode> tree2 = new LinkedList<TreeNode>();
		tree1.offer(p);
		tree2.offer(q);

		while(tree1.peek()!=null || tree2.peek()!=null){
			TreeNode t1 = tree1.poll();
			TreeNode t2 = tree2.poll();
			if(t1!=null && t2!=null && t1.val == t2.val && ((t1.left==null)==(t2.left==null)) &&((t1.right==null)==(t2.right==null))) {
				if(t1.left!=null){
					tree1.offer(t1.left);
					tree2.offer(t2.left);
				}
				if(t1.right!=null){
					tree1.offer(t1.right);
					tree2.offer(t2.right);
				}
			}else
				return false;
		}
		return true;
    }
}