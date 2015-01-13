/*
Sort List 

Sort a linked list in O(n log n) time using constant space complexity.
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
public class SortList {
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
    
    private static ListNode getHalf(ListNode head){
    	ListNode fast, slow, mid;
    	if(head==null || head.next==null){
    	    mid = null;
    	}
        else{   
            fast = head;
            slow = head;
            while(fast!=null && fast.next!=null){
                fast = fast.next.next;
                if(fast==null)
                    break;
                slow = slow.next;
            }
            mid = slow.next;
            slow.next = null;
        }
        return mid;
    }
    
    private static ListNode merge(ListNode listA, ListNode listB){
        ListNode head = new ListNode(0);
        ListNode current = head;
        while(true){
            if(listA==null){
        	current.next = listB;
        	break;
            }
            if(listB==null){
                current.next = listA;
                break;
            }
            if(listA.val<listB.val){
                current.next = listA;
                listA = listA.next;
            }
            else{
                current.next = listB;
                listB = listB.next;
            }
            current = current.next;
        }
        return head.next;
    }
    
    private static ListNode mergeSort(ListNode head){
        ListNode first = null,mid = null; 
        if(head==null || head.next==null)
            return head;
    
        mid = getHalf(head);
        first = mergeSort(head);
        mid = mergeSort(mid);
        return merge(first,mid);
    }
    
    public static void main(String args[]){
    	int[] arr = ListUtil.RandomArray(20,10);
        SortList sol = new SortList();
        ListNode head = ListUtil.buildList(arr);
        ListUtil.printList(head);
        head = sol.sortList(head);
        ListUtil.printList(head);
    }
}
