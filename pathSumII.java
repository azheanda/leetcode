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
   
    
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        pathSum(root,sum,path,res);
        return res;
    }
    
    public void pathSum(TreeNode root, int sum, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> res) {
        if(root==null) return;
        if(root.left==null && root.right==null && sum==root.val){
            ArrayList<Integer> p = new ArrayList<Integer>();
            p.addAll(path);
            p.add(root.val);
            res.add(p);
            return;
        }
        
        path.add(root.val);
        pathSum(root.left,sum-root.val,path,res);
        pathSum(root.right,sum-root.val,path,res);
        path.remove(path.size()-1);                 // path.remove((Integer)root.val) does not work for 2 cases in judge small. 
    }  
    
    
}