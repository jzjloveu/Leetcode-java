// Remove Duplicates from Sorted List II 

// Given a sorted linked list, delete all duplicates such that each element appear only once.

// Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

// For example,
// Given 1->2->3->3->4->4->5, return 1->2->5.
// Given 1->1->1->2->3, return 2->3. 

// Definition for singly-linked list.
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
        val = x;
        next = null;
     }
}

public class DeleteDuplicatesII {
    public ListNode deleteDuplicatesII(ListNode head) {
        if(head==null || head.next==null)
        	return head;
        ListNode dumhead = new ListNode(0);
        dumhead.next = head;
        ListNode prev = dumhead;
        while(prev.next != null){
                ListNode curr = prev.next;
        	while(curr.next!=null && curr.val==curr.next.val)
        		curr = curr.next;
        	if(curr != prev.next)
        		prev.next = curr.next;
                else
                        prev = prev.next;
        }
        return dumhead.next;
    }
    
    private static ListNode buildList(int[] arr){
	ListNode head = new ListNode(0);
        ListNode curr = head;
        for(int i:arr){
             curr.next = new ListNode(i);
             curr = curr.next;
        }
        return head.next;
    }
    
    private static void printList(ListNode head){
    	while(head!=null){
    	    System.out.print(head.val+" ");
            head = head.next;	    
    	}  
        System.out.println();  	 
    }
    
    public static void main(String args[]){
	int[] arr = {1,2,3,3,4,4,5};
        //int[] arr = {1,1,1,2,3};
	DeleteDuplicatesII sol = new DeleteDuplicatesII();
        ListNode head = sol.buildList(arr);
        sol.printList(head);
        head = sol.deleteDuplicatesII(head);
        sol.printList(head);
    }
}
