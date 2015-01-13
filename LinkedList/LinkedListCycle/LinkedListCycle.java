/*
Linked List Cycle 

 Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space? 
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
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(head==null)
        	return false;
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
        	fast = fast.next.next;
                slow = slow.next;
                if(slow == fast)
                	return true; 
        }
        return false;
    }
    
    public static void main(String args[]){
        int[] arr = {0,1,2,3,4,5,6,7,8,9};
        LinkedListCycle sol = new LinkedListCycle();
        ListNode head = ListUtil.buildList(arr);
        System.out.println(sol.hasCycle(head));
    }
}
