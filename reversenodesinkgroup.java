/*
	Basically my cousin's solution.
*/

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
    public ListNode reverseKGroup(ListNode head, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tail = dummy;
        ListNode kbegin = null;
        ListNode kend = null;

        ListNode node = head;
        int count =0;
        while(node!=null){
            if(count%k==0)
        		kbegin = node;
        	if(count%k==k-1)
        		kend = node;
        	node = node.next;
        	if(count%k==k-1){
        		kend.next = null;
        		ListNode prev = null;
        		ListNode t = kbegin;
        		while(t!=null){
        			ListNode temp = t.next;
        			t.next = prev;
        			prev = t;
        			t = temp;
        		}
        		tail.next = kend;
        		tail = kbegin;
        		tail.next = node;
        	}
        	count++;


        }
        return dummy.next;
    }
}