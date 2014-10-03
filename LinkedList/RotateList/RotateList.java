// Rotate List 

// Given a list, rotate the list to the right by k places, where k is non-negative.

// For example:
// Given 1->2->3->4->5->NULL and k = 2,
// return 4->5->1->2->3->NULL.

// Definition for singly-linked list.
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
        val = x;
        next = null;
     }
}

public class RotateList {
    public ListNode rotateRight(ListNode head, int n) {
	if(head == null || n == 0 ){ return head;}
        ListNode curr = head;
        int len = 1;
        while(curr.next!=null){ curr = curr.next;len++;}        
        n = len - n%len;
        if(n == len){ return head;}
        ListNode curr2 = head;
        int index = 1;
        while(index++ < n){ curr2 = curr2.next;}
        curr.next = head;
        head = curr2.next;
        curr2.next = null;
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
        if (head==null){ System.out.print("null");}
    	while(head!=null){
		System.out.print(head.val+" ");
		head = head.next;	    
    	}  
        System.out.println();  	 
    }
    
    public static void main(String args[]){
	int[] arr = {1,2,3,4,5,6,7,8,9};
        RotateList sol = new RotateList();
        ListNode head = sol.buildList(arr);
        sol.printList(head);
        sol.printList(sol.rotateRight(head,3));
    }
}

