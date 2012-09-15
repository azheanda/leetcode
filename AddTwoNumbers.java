/*
	The paradigm of this solution and that of AddBinary3.java are similar.
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode header = new ListNode(-1);
        ListNode prev = header;
        int sum=0;
        while(l1!=null || l2!=null || sum>0){
            if(l1!=null)
                sum+=l1.val;
            if(l2!=null)
                sum+=l2.val;
            int val = sum%10;
            sum = sum/10;
            ListNode current = new ListNode(val);
            prev.next = current;
            prev = current;
            l1 = l1==null?l1:l1.next;
            l2 = l2==null?l2:l2.next;
        }
        return header.next;
    }
}