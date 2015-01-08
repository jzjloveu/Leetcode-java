/*
Merge Two Sorted Lists 

Merge two sorted linked lists and return it as a new list. 
The new list should be made by splicing together the nodes 
of the first two lists.
*/
package ListUtil;
import ListUtil.*;
import java.util.*;
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

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode dumhead = new ListNode(0);
        ListNode curr = dumhead;
        while(true){
            if(l1==null){
        	curr.next = l2;
        	break;
            }
            if(l2==null){
                curr.next = l1;
                break;
            }
            if(l1.val<l2.val){
                curr.next = l1;
                l1 = l1.next;
            }
            else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        return dumhead.next;
    }
    
    public static void main(String args[]){
        int[] arr1 = ListUtil.RandomArray(10,5);
        int[] arr2 = ListUtil.RandomArray(10,5);
        Arrays.sort(arr1); Arrays.sort(arr2);
        ListNode l1 = ListUtil.buildList(arr1);
        ListNode l2 = ListUtil.buildList(arr2);
        ListUtil.printList(l1);
        ListUtil.printList(l2);
        MergeTwoLists sol = new MergeTwoLists();
        ListNode head = sol.mergeTwoLists(l1,l2);
        ListUtil.printList(head);
    }
}
