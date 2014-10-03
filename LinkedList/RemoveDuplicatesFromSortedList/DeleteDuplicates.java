// Remove Duplicates from Sorted List 

// Given a sorted linked list, delete all duplicates such that each element appear only once.

// For example,
// Given 1->1->2, return 1->2.
// Given 1->1->2->3->3, return 1->2->3. . 

// Definition for singly-linked list.
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
        val = x;
        next = null;
     }
}

public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null)
        	return head;
        ListNode curr = head;
        while(curr.next != null){
        	if(curr.next.val == curr.val)
        		curr.next = curr.next.next;
        	else
        		curr = curr.next;
        }
        return head;
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
	int[] arr = {1,1,2,3,3};
	DeleteDuplicates sol = new DeleteDuplicates();
        ListNode head = sol.buildList(arr);
        sol.printList(head);
        head = sol.deleteDuplicates(head);
        sol.printList(head);
    }
}
