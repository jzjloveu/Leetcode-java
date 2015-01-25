// Merge k Sorted Lists
/*
Merge two sorted linked lists and return it as a new list. 
The new list should be made by splicing together the nodes of the first two lists.
*/
package ListUtil;
import ListUtil.*;
import java.util.List;
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
public class MergeKLists {
    public ListNode mergeKLists(List<ListNode> lists){
        if(lists.size() == 0){ return null;}
        ListNode head = new ListNode(0);
        head.next = lists.get(0);
        for(int i=1;i<lists.size();i++){
            ListNode l1 = head;
            ListNode l2 = lists.get(i);
            while(l2 != null){
    			if(l1.next==null){
    				l1.next = l2; break;
    		    }
    		    if(l1.next.val < l2.val)
    		        l1 = l1.next;
    		    else{
                    ListNode temp = l1.next;
                    l1.next = l2;
    		        l2 = l2.next;
                    l1.next.next = temp;
                    l1 = l1.next;
    		    }
    		}
        }
        return head.next;
    }

    public static void main(String args[]){
        int[] arr1 = ListUtil.RandomArray(100,5);
        int[] arr2 = ListUtil.RandomArray(100,5);
        int[] arr3 = ListUtil.RandomArray(100,5);
        int[] arr4 = ListUtil.RandomArray(100,5);
        int[] arr5 = ListUtil.RandomArray(100,5);
        MergeKLists sol = new MergeKLists();
        ListNode l1 = ListUtil.buildList(arr1);
        ListNode l2 = ListUtil.buildList(arr2);
        ListNode l3 = ListUtil.buildList(arr3);
        ListNode l4 = ListUtil.buildList(arr4);
        ListNode l5 = ListUtil.buildList(arr5);
        List<ListNode> lists = new java.util.ArrayList<ListNode>();
        lists.add(l1);lists.add(l2);lists.add(l3);lists.add(l4);lists.add(l5);
        for(ListNode l:lists) ListUtil.printList(l);
        ListUtil.printList(sol.mergeKLists(lists));
    }
}
