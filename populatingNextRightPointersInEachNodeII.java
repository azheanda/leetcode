/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null) return;
        
        TreeLinkNode dummyNode = new TreeLinkNode(0);
        TreeLinkNode lastNode = dummyNode;
        TreeLinkNode nextNode = root;
        while(nextNode!=null){            
           if(nextNode.left!=null || nextNode.right!=null)
                break;
            nextNode = nextNode.next;
        }
        
        while(nextNode!=null){
            if(nextNode.left!=null){ lastNode.next = nextNode.left; lastNode = lastNode.next;}
            if(nextNode.right!=null){ lastNode.next = nextNode.right; lastNode = lastNode.next;}            
            nextNode = nextNode.next;
            
        }
                
        connect(dummyNode.next);
    }
}