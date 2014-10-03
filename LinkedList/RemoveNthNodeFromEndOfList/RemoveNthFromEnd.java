//Remove Nth Node From End of List

// Given a linked list, remove the nth node from the end of list and return its head.

// For example,

// Given linked list: 1->2->3->4->5, and n = 2.

// After removing the second node from the end, the linked list becomes 1->2->3->5.

// Note:
// Given n will always be valid.
// Try to do this in one pass.  

// Definition for singly-linked list.
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
        val = x;
        next = null;
     }
}

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
	int[] arr = {1,2,3,4,5,6,7,8,9};
	RemoveNthFromEnd sol = new RemoveNthFromEnd();
        ListNode head = sol.buildList(arr);
        sol.printList(head);
        head = sol.removeNthFromEnd(head,5);
        sol.printList(head);
    }
}
