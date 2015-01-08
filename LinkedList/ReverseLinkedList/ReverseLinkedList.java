/*
Reverse a linked list.
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

public class ReverseLinkedList {
    public ListNode reverseLinkedList(ListNode head) {
	if(head == null){ return null;}
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }        
        return prev;
    }
      
    // another way, use fixed prev and curr, move curr to the end
    public ListNode reverseLinkedList2(ListNode head) {
	if(head == null){ return null;}
        ListNode dumhead = new ListNode(0);
        dumhead.next = head;
        ListNode prev = dumhead;
        ListNode curr = prev.next;
        while(curr.next != null){
            ListNode temp = prev.next;
            prev.next = curr.next;
            curr.next = curr.next.next;
            prev.next.next = temp;
        }        
        return dumhead.next;
    }

    public static void main(String args[]){
        int[] arr = {1,2,3,4,5,6,7,8,9};
        ReverseLinkedList sol = new ReverseLinkedList();
        ListNode head = ListUtil.buildList(arr);
        ListUtil.printList(head);
        head = sol.reverseLinkedList(head);
        ListUtil.printList(head);
        head = sol.reverseLinkedList2(head);
        ListUtil.printList(head);
    }
}
