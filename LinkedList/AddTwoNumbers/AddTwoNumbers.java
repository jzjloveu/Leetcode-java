/*
Add Two Numbers 

You are given two linked lists representing two non-negative numbers. 
The digits are stored in reverse order and each of their nodes contain 
a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
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
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode dumhead = new ListNode(0);
        ListNode head = dumhead;
        int carry = 0;
        while(carry!=0 || l1!=null || l2!=null){
            ListNode node = new ListNode(carry);
            if(l1 != null){
        	node.val += l1.val;
        	l1 = l1.next;
            }
            if(l2 != null){
                node.val += l2.val;
                l2 = l2.next;
            }
            carry = node.val / 10;
            node.val %= 10;
            head.next = node;
            head = head.next;
        }
        return dumhead.next;
    }
    
    public static void main(String args[]){
        int[] arr1 = ListUtil.RandomArray(20,10);
        AddTwoNumbers sol = new AddTwoNumbers();
        ListNode l1 = ListUtil.buildList(arr1);
        ListNode l2 = ListUtil.buildList(arr2);
        ListUtil.printList(l1);
        ListUtil.printList(l2);
        ListUtil.printList(sol.addTwoNumbers(l1,l2));
    }
}
