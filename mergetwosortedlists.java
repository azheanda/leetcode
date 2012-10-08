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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        ListNode dummyNode = new ListNode(0);
        ListNode currentNode = dummyNode;
        
        while(l1!=null||l2!=null){
            if(l1!=null&&l2!=null)
                if(l1.val>l2.val){
                    currentNode.next =l2;
                    l2 = l2.next;
                }else{
                    currentNode.next =l1;
                    l1 = l1.next;
                }
            else if(l1==null){
                currentNode.next =l2;
                    l2 = l2.next;
            }else{
                currentNode.next =l1;
                    l1 = l1.next;
            }
            currentNode=currentNode.next;
                       
        }
        return dummyNode.next;
        
    }
}