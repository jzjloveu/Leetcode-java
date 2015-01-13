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

public class ReverseLinkedList1 {
    public ListNode reverseLinkedList(ListNode head) {
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
        ReverseLinkedList1 sol = new ReverseLinkedList1();
        ListNode head = ListUtil.buildList(arr);
        ListUtil.printList(head);
        head = sol.reverseLinkedList(head);
        ListUtil.printList(head);
    }
}

/*
Another way: use fixed prev and curr, move curr to the end
*/