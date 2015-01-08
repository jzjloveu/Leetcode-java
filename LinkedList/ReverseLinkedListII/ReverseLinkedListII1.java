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

public class ReverseLinkedListII1 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        for(int i=0;i<n-m;i++){
            int index1 = n - i;
            int index2 = m + i;
            if(index2 >= index1){ return head;}
            ListNode first = head;
            ListNode second = head;
            while(index1-1>0){
                first = first.next;
                index1--;
            }
            while(index2-1>0){
                second = second.next;
                index2--;
            }
            int temp = second.val;
            second.val = first.val;
            first.val = temp;
        }
        return head;
    }

    public static void main(String args[]){
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        ReverseLinkedListII1 sol = new ReverseLinkedListII1();
        ListNode head = ListUtil.buildList(arr);
        ListUtil.printList(head);
        head = sol.reverseBetween(head,1,2);
        ListUtil.printList(head);
    }
}

/*
This is easy way which reverses just value of nodes.
(1) the stop condition is the middle of the reversed sublist (m+n)/2
(2) for each element in the sublist, the swapping element is the next 
(n-m-(i-m)*2) element.
    e.g.
    1-2-3-4-5-6-7-8-9-10-null
      |             |
     m=2           n=9
    for 2, just get the next (n-m) element.

    1-9-3-4-5-6-7-8-2-10-null
        |         |
       i=3      idx=8
    next element 3, the swapping element is 8.
*/