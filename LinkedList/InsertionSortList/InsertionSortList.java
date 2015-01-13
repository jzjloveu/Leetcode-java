// Insertion Sort List 
/*
Sort a linked list using insertion sort.
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
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if(head==null) return head;
        ListNode dumhead = new ListNode(0);
        dumhead.next = head;
        ListNode curr = head;
        while(curr.next != null){
        	if(curr.next.val < curr.val){
        		ListNode pre = dumhead;
        		while(pre.next.val < curr.next.val)
        			pre = pre.next;
        		ListNode tmp = curr.next;
        		curr.next = tmp.next;
        		tmp.next = pre.next;
        		pre.next = tmp;
        	}
        	else
        		curr = curr.next;
        }
        return dumhead.next;
    }

    public static void main(String args[]){
        int[] arr = ListUtil.RandomArray(20,10);
        InsertionSortList sol = new InsertionSortList();
        ListNode head = ListUtil.buildList(arr);
        ListUtil.printList(head);
        head = sol.insertionSortList(head);
        ListUtil.printList(head);
    }
}
