/*
    Basically, I revise the min heap to a piority queue to solution this problem. The time complexity is O(nlogk),
    k--the number of sorted lists,n--the total number of elements in all the sorted lists.
    Hmmm, in fact, we have PriorityQueue in Java.


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
    int heap_size ;
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists.size()==0 )
            return null;
        
        ListNode[] A = new ListNode[lists.size()];
    	int i=0;
    	for(ListNode node : lists){
             if(!(node==null)){   //in stupid leetcode judge, I can say "if(node!=null)" because it will complain that operator ! cannot be applied to <nulltype>"
    		    A[i++]=node;
    		    node = node.next;         
                heap_size++;
             }
    	}
    	build_min_heap(A);
    	return mergeKLists(A);
        
    }

    public ListNode mergeKLists(ListNode[] A){
    	ListNode dumbNode = new ListNode(0);
		ListNode currentNode = dumbNode;
    	
    	while(heap_size!=0){
    		currentNode.next=A[0];
    		currentNode = currentNode.next;
    		if(A[0].next!=null)
    			A[0]=A[0].next;
    		else{
                swap(A,0,heap_size-1);
    			heap_size--;
    		}
    		min_heapify(A,0);
    	}

    	return dumbNode.next;
    }

    public void build_min_heap(ListNode[] A){
    	//heap_size =A.length;
    	for(int i=A.length/2;i>=0;i--)
    		min_heapify(A,i);
    }

    public void min_heapify(ListNode[] A,int i){
    	int l = 2*i; //LEFT(i)
    	int r = 2*i+1; //RIGHT(i)
    	int smallest=0;
    	smallest = (l<heap_size && A[l].val<A[i].val)?l:i;
   		smallest = (r<heap_size && A[r].val<A[smallest].val)?r:smallest;
   		if(smallest!=i){
   			swap(A,i,smallest);
   			min_heapify(A,smallest);
   		}
    }

    public void swap(ListNode[] A, int i, int j){
    	ListNode temp = A[i];
    	A[i] = A[j];
    	A[j] = temp;
    }
}