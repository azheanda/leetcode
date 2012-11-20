/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
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
    public ListNode list = null;
    public TreeNode sortedListToBST(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
           list = head;
           int len = 0;
           ListNode node = head;
           while(node!=null) {node=node.next;len++;}
           return sortedListToBST(0,len-1);

    }
    
    public TreeNode sortedListToBST(int start, int end){
    	if(start>end)	return null;

    	int mid = start+(end-start)/2;
    	TreeNode left = sortedListToBST(start,mid-1);
    	TreeNode parent = new TreeNode(list.val);
    	parent.left = left;
    	list=list.next;
    	parent.right = sortedListToBST(mid+1,end);
    	return parent;
    }
}