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
    public ListNode swapPairs(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        ListNode node1 = null;
        ListNode node2 = null;
        
        while(curr.next!=null && curr.next.next!=null){
            node1 = curr.next;            
            node2 = node1.next;
            ListNode next =node2.next;            
            curr.next = node2;
            node2.next = node1;
            node1.next = next;            
            curr=node1;
        }
        return dummy.next;
    }
}