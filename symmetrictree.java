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
    public boolean isSymmetric(TreeNode root) {       
        if(root==null)
            return true;
        return isSymmetric(root.left,root.right);
    }
    
    public boolean isSymmetric(TreeNode left, TreeNode right){
        if(left!=null && right!=null)
            return left.val==right.val && isSymmetric(left.right,right.left) && 
                isSymmetric(left.left,right.right);
        return left ==null && right ==null;     
    }
}


/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
    iterative version. note: we can actually insert null into a queue
*/
import java.util.*;
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null)
            return true;
            
        Queue<TreeNode> left = new LinkedList<TreeNode>();
        Queue<TreeNode> right = new LinkedList<TreeNode>();
        
        left.add(root.left);
        right.add(root.right);
        
        while(left.peek()!=null || right.peek()!=null){
            if(left.peek()==null || right.peek()==null)
                return false;
            else{
                TreeNode l = left.poll();
                TreeNode r = right.poll();
                if(l.val==r.val && ((l.right==null)==(r.left==null)) && ((l.left==null)==(r.right==null)) ) {               
                    if(l.right!=null){
                        left.add(l.right);
                        right.add(r.left);
                    }
                    if(l.left!=null){
                        left.add(l.left);
                        right.add(r.right);
                    }
                }else
                    return false;
                                      
            }
                        
        }
        return true;
            
    }
    
}