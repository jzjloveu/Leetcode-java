/*
Reverse Nodes in k-Group

Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
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
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
    	if(head == null){ return null;}
        ListNode curr = new ListNode(0);
        curr.next = head;
        head = curr;
        ListNode pivot = curr;
        while(true){
            int index = 0;
            while(pivot!=null && index++<k){ pivot = pivot.next;}
    		if(pivot == null){ break;}
    		else{
    			while(curr.next != pivot){
    				ListNode second = curr.next;
    				ListNode first = pivot.next;
    				curr.next = curr.next.next;
    				pivot.next= second;
    				second.next = first;
    			}
                for(int j=0;j<k;j++){ curr = curr.next;}
                pivot = curr;
    		}
        }
	   return head.next;
    }

    public static void main(String args[]){
        int[] arr = {1,2,3,4,5,6,7,8,9};
        ReverseKGroup sol = new ReverseKGroup();
        ListNode head = ListUtil.buildList(arr);
        ListUtil.printList(head);
        head = sol.reverseKGroup(head,3);
        ListUtil.printList(head);
    }
}

/*
Simliar as problem 'Swap Nodes in Pairs'.
See an example, we have linked list 3->2->1->4->5->6->7
We wan to reverse 4->5->6 to 6->5->4, so we do the following:
    (1) 3->2->1->4->5->6->7
              p        q
    (2) 3->2->1---->5->6->4->7
              p        q
    (3) 3->2->1------->6->5->4->7
              p        q

The 1st step is to find the locations p and q, where we want to 
reverse from p->next to q.
Then while p->next != q,  we do:
    (1) move p->next to q->next
    (2) connect p->next to p->next->next
Note that, p and q are fixed.
Now we solve this reverse problem, the final step is to scan the whole list:
When we finished one reverse, put p k steps further, set q=p, then put q k 
steps further to find the end node for the new reverse, if meet the end, 
no more reverse needed, return the list.
*/