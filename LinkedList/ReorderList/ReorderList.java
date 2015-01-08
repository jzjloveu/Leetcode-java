// Reorder List

// Given a singly linked list L: L0->L1->...->Ln-1->Ln,
// reorder it to: L0->Ln->L1->Ln-1->L2->Ln-2->...

// You must do this in-place without altering the nodes' values.

// For example,
// Given {1,2,3,4}, reorder it to {1,4,2,3}. 
package ListUtil;
import ListUtil.*;
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
public class ReorderList {
    public void reorderList(ListNode head) {
		if(head == null || head.next == null ){ return;}
        ListNode fast, slow;
        fast = slow = head;
        while(fast.next!=null && fast.next.next!=null){
                slow = slow.next;
        	fast = fast.next.next;
        }        
        // now slow is the mid point and do reverse
        fast = slow.next;
        while(fast.next != null){
        	ListNode temp = slow.next;
            slow.next = fast.next;
            fast.next = fast.next.next;
            slow.next.next = temp;
        }
        // insert reverse part to reorder
        fast = head;
        while(slow != fast && slow.next != null){
			ListNode temp = fast.next;
            fast.next = slow.next;
            slow.next = slow.next.next;
            fast.next.next =temp;
            fast = fast.next.next;
        }
    }
    
    public static void main(String args[]){
		int[] arr = {1,2,3,4,5};
		ReorderList sol = new ReorderList();
        ListNode head = ListUtil.buildList(arr);
        ListUtil.printList(head);
        sol.reorderList(head);
        ListUtil.printList(head);
    }
}

/*
So the algorithm implemented below can be summarized as:
Step 1  Find the middle pointer of the linked list (you can use the slow/fast pointers)
Step 2  Reverse the second part of the linked list (from middle->next to the end)
Step 3  Do the reordering. (inset every element in the second part in between the elements in the first part)
*/
