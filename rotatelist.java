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
    public ListNode rotateRight(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null || n ==0)
    		return head;

        ListNode p = head;
        ListNode q = p ;
        ListNode end = null;
        int i=0;
        while(i<n){
        	if(q.next==null){		// When q reach the tail of the list, make p.next = head to
        		end = q;			// enable the continuation of finding the breakpoint for the list
        		end.next = head;	// Unlike a similar problem whose input is an array, we cannot 
        	}						// do a module operation to avoid this since we don't know the length until traverse the list
        	q=q.next;
        	i++;
        }

        if(end!=null) end.next = null;

        while(q.next!=null){
        	p=p.next;
        	q=q.next;
        }

        q.next =head;
        ListNode newHead = p.next;
        p.next = null;
        return newHead;

    }
}