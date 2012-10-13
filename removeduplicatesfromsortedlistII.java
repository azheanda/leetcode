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
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;        
        ListNode current = dummy;
        while(current.next!=null){
            ListNode prev = current;
            current = current.next;
            boolean isDuplicate = false;
            
            while(current!=null && current.next!=null && current.val==current.next.val){
                current = current.next;
                isDuplicate = true;
            }
            
            prev.next = isDuplicate?current.next:current;
            current = isDuplicate?prev:current;   
           
        }
        return dummy.next;
    }
}