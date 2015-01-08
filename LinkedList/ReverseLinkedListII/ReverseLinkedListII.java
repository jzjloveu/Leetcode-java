/*
Reverse Linked List II 

Reverse a linked list from position m to n. Do it in-place and one-pass.

For example:
Given 1->2->3->4->5->NULL, m=2 and n=4
return 1->4->3->2->5->NULL

Note:
Given m, n satisfy the following condition:
1 <= m <= n <= length of list
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

public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n){
	if(head == null){ return null;}
        ListNode dumhead = new ListNode(0);
        dumhead.next = head;
        ListNode first = dumhead;
        ListNode second = dumhead;
        int count = 0;
        while(count < n-1 && first.next!=null){
            first = first.next;
            count += 1;
            if(count > n-m)
                second = second.next;
        }
        if(first.next == null){ return null;}
        ListNode temp1 = first.next.next;
        ListNode curr = second.next;
        ListNode prev = null;
        while(curr != temp1){
            ListNode temp2 = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp2;
	}
        second.next = prev;
        if(curr != null){
            while(prev.next != null)
                prev = prev.next;
            prev.next = curr;
	}
        return dumhead.next;
    }

    public static void main(String args[]){
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        ReverseLinkedListII sol = new ReverseLinkedListII();
        ListNode head = ListUtil.buildList(arr);
        ListUtil.printList(head);
        head = sol.reverseBetween(head,1,8);
        ListUtil.printList(head);
    }
}
