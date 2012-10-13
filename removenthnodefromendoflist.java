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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;        
        ListNode q = dummy;
        for(int i=0;i<n+1;i++){   // With n+1, when q reaches the end of the list, q is at the one before the to-delete node.
            q = q.next;
        }
        while(q!=null){
            p = p.next;
            q = q.next;
        }
        p.next =p.next!=null?p.next.next:null;
        return dummy.next;       
    }
}