//Remove Nth Node From End of List
/*
 Given a linked list, remove the nth node from the end of list and return its head.

 For example,

 Given linked list: 1->2->3->4->5, and n = 2.

 After removing the second node from the end, the linked list becomes 1->2->3->5.

 Note:
 Given n will always be valid.
 Try to do this in one pass.  
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
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null){return head;}
        ListNode curr = new ListNode(0);
        curr.next = head;
        head = curr;
        ListNode prev = curr;
        int count = 0;
        while(curr.next != null){
                curr = curr.next;
                count++;
        	if(count > n)
        		prev = prev.next;
        }
        prev.next = prev.next.next;
        return head.next;
    }
    
    public static void main(String args[]){
		int[] arr = {1,2,3,4,5,6,7,8,9};
		RemoveNthFromEnd sol = new RemoveNthFromEnd();
        ListNode head = ListUtil.buildList(arr);
        ListUtil.printList(head);
        ListUtil.printList(sol.removeNthFromEnd(head,5));
    }
}
