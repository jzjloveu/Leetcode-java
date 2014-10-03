// Reverse a linked list.

// Definition for singly-linked list.
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
        val = x;
        next = null;
     }
}

public class ReverseLinkedList {
    public ListNode reverseLinkedList(ListNode head) {
	if(head == null){ return null;}
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }        
        return prev;
    }
      
    // another way, use fixed prev and curr, move curr to the end
    public ListNode reverseLinkedList2(ListNode head) {
	if(head == null){ return null;}
        ListNode dumhead = new ListNode(0);
        dumhead.next = head;
        ListNode prev = dumhead;
        ListNode curr = prev.next;
        while(curr.next != null){
            ListNode temp = prev.next;
            prev.next = curr.next;
            curr.next = curr.next.next;
            prev.next.next = temp;
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
        if (head==null){ System.out.print("null");}
    	while(head!=null){
		System.out.print(head.val+" ");
		head = head.next;	    
    	}  
        System.out.println();  	 
    }
    
    public static void main(String args[]){
	int[] arr = {1,2,3,4,5,6,7,8,9};
	ReverseLinkedList sol = new ReverseLinkedList();
        ListNode head = sol.buildList(arr);
        sol.printList(head);
        head = sol.reverseLinkedList(head);
        sol.printList(head);
        head = sol.reverseLinkedList2(head);
        sol.printList(head);
    }
}
