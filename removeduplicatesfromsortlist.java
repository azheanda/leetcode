/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null)    // we can otherwise use dummy node instead. But
            return null;    // be careful about the value you put in the dummy node.
        
        ListNode currentNode = head;
        while(currentNode.next!=null){
            ListNode p = currentNode.next;
            while(p!=null && p.val==currentNode.val)
                p = p.next;
            if(p == null){
                currentNode.next =null;
                break;
            }
            currentNode.next = p;
            currentNode = p;
        }
        return head;
    }
}