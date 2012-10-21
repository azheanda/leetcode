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

/*
	It's like my first time to write bug free code despite the fact 
	that this might not be a  decent solution.
	helpful link: http://cslibrary.stanford.edu/105/LinkedListProblems.pdf
*/
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyNode = new ListNode(0);
       	dummyNode.next =head;
       	ListNode p = dummyNode;
       	ListNode endOfFirstList = null;
       	ListNode startOfThirdList =null;
        ListNode endOfSecondList = null;
       	int count = 0;
       	while(count<=n){
       		if(count==m-1)
       			endOfFirstList = p;
      		if(count==n){
      			endOfSecondList = p;
      			startOfThirdList = p.next;
      		}
       		p=p.next;
       		count++;
       	}

       	endOfSecondList.next = null; 
       	endOfSecondList = endOfFirstList.next;
       	endOfFirstList.next = reverseLinkedList(endOfFirstList.next);
       	endOfSecondList.next = startOfThirdList;
       	return dummyNode.next;
    }

    // so called "Push reverse"
    public ListNode reverseLinkedList(ListNode head){
    	if(head==null) return head;
    	ListNode prev = null;
    	ListNode curr = head;

    	while(curr!=null){
    		ListNode next = curr.next;
    		curr.next = prev;
    		// update curr and prev
    		prev = curr;
    		curr = next;
    	}
    	return prev;
    }

    
}

/*
	// recursive reverse
	public ListNode reverseLinkedList(ListNode curr){
    	if(curr==null) return curr;
    	ListNode rest = curr.next;
    	if(rest==null) return curr;

    	rest = reverseLinkedList(rest);
    	curr.next.next = curr;    //  Here is the trick
    	curr.next =null;          //
    	return rest;
    }

*/

