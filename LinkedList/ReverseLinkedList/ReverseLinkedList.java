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

    public static void main(String args[]){
        int[] arr = {1,2,3,4,5,6,7,8,9};
        ReverseLinkedList sol = new ReverseLinkedList();
        ListNode head = ListUtil.buildList(arr);
        ListUtil.printList(head);
        head = sol.reverseLinkedList(head);
        ListUtil.printList(head);
    }
}
