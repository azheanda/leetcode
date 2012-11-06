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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }


    public TreeNode buildTree(int[] inorder, int i, int j, int[] postorder, int p, int q){
        if(i>j)
            return null;
        
        if(i==j && p==q)
    		return new TreeNode(postorder[q]);

    	TreeNode root = new TreeNode(postorder[q]);

    	int idx =-1;
    	for(int x=i;x<=j;x++)
    		if(inorder[x]==postorder[q]){
    			idx = x;
    			break;
    		}

    	TreeNode leftChild = buildTree(inorder,i,idx-1,postorder,p,p+idx-i-1);
    	TreeNode rightChild = buildTree(inorder,idx+1,j,postorder,p+idx-i,q-1);

    	root.left = leftChild;
    	root.right = rightChild;
    	return root;
    }
}