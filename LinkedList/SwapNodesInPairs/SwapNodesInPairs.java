/*
Swap Nodes in Pairs

Given a linked list, swap every two adjacent nodes and return its head.

For example:
Given 1->2->3->4, you should return the list as 2->1->4->3. 
Your algorithm should use only constant space. You may not modify the 
values in the list, only nodes itself can be changed.
*/
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

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
	if(head == null){ return null;}
        ListNode curr = new ListNode(0);
        curr.next = head;
        head = curr;
        while(true){
		if(curr.next == null){ break;}
		if(curr.next.next == null){ break;}
		ListNode p1 = curr.next;
		ListNode p2 = p1.next;
		p1.next = p2.next;
		p2.next= p1;
		curr.next = p2;
		curr = p1;
        }
        return head.next; 
    }

    public static void main(String args[]){
        int[] arr = {1,2,3,4,5,6,7,8,9};
        SwapNodesInPairs sol = new SwapNodesInPairs();
        ListNode head = ListUtil.buildList(arr);
        ListUtil.printList(head);
        head = sol.swapPairs(head);
        ListUtil.printList(head);
    }
}
/* 
 * swap two nodes in linked list scheme:
 * node1->node2->node3->node3->node4
 * first swap node1.next with node2.next
 * node1.next = node2.next
 * node2.next = node2
 * second swap node2.next with node3.next
 * node2.next = node4
 * node3.next = node2
 *
 */
