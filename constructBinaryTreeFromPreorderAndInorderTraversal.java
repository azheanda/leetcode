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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return buildTree(inorder,0,inorder.length-1,preorder,0,preorder.length-1);
    }

    public TreeNode buildTree(int[] inorder, int i, int j, int[] preorder, int p, int q){
        if(i>j)
            return null;
        
        if(i==j && p==q)
    		return new TreeNode(preorder[p]);

    	TreeNode root = new TreeNode(preorder[p]);

    	int idx =-1;
    	for(int x=i;x<=j;x++)
    		if(inorder[x]==preorder[p]){
    			idx = x;
    			break;
    		}

    	TreeNode leftChild = buildTree(inorder,i,idx-1,preorder,p+1,p+idx-i);
    	TreeNode rightChild = buildTree(inorder,idx+1,j,preorder,p+idx-i+1,q);

    	root.left = leftChild;
    	root.right = rightChild;
    	return root;
    }
}