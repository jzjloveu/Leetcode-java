/*
Remove Duplicates from Sorted List II 

Given a sorted linked list, delete all duplicates such that each element appear only once.

Given a sorted linked list, delete all nodes that have duplicate numbers, 
leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3. 
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
public class DeleteDuplicatesII {
    public ListNode deleteDuplicatesII(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode dumhead = new ListNode(0);
        dumhead.next = head;
        ListNode prev = dumhead;
        while(prev.next != null){
                ListNode curr = prev.next;
        	while(curr.next!=null && curr.val==curr.next.val)
        		curr = curr.next;
        	if(curr != prev.next)
        		prev.next = curr.next;
                else
                        prev = prev.next;
        }
        return dumhead.next;
    }

    public static void main(String args[]){
        int[] arr = {1,2,3,3,4,4,5}; //{1,1,1,2,3};
        DeleteDuplicatesII sol = new DeleteDuplicatesII();
        ListNode head = ListUtil.buildList(arr);
        ListUtil.printList(head);
        head = sol.deleteDuplicatesII(head);
        ListUtil.printList(head);
    }
}
