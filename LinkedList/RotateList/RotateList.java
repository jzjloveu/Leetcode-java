// Rotate List 
/*
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
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
public class RotateList {
    public ListNode rotateRight(ListNode head, int n) {
		if(head == null || n == 0 ){ return head;}
        ListNode curr = head;
        int len = 1;
        while(curr.next!=null){ curr = curr.next;len++;}        
        n = len - n%len;
        if(n == len){ return head;}
        curr.next = head;
        int index = 0;
        while(index++ < n){ curr = curr.next;}
        head = curr.next;
        curr.next = null;
        return head;
    }
    
    public static void main(String args[]){
		int[] arr = {1,2,3,4,5}; int k = 2;
        RotateList sol = new RotateList();
        ListNode head = ListUtil.buildList(arr);
        ListUtil.printList(head);
        ListUtil.printList(sol.rotateRight(head,k));
    }
}

/*
First, get the length of the list, then make last node.next point to head.
Second, iterate from head until length-k%length, then break the node. 
*/
