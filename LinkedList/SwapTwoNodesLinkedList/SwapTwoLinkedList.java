// Swap a linked list elements m and n. 

// For example:
// Given 1->2->3->4->5->NULL, m=2 and n=4
// return 1->4->3->2->5->NULL

// Definition for singly-linked list.
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
        val = x;
        next = null;
     }
}

public class SwapTwoLinkedList {
    public ListNode swapTwoLinkedList(ListNode head, int m, int n) {
	if(head == null){ return null;}
        int min = (m < n)?m:n;
        n = (m < n)?n:m;
        m = min;
        ListNode dumhead = new ListNode(0);
        dumhead.next = head;
        ListNode first = dumhead;
        ListNode second = dumhead;
        int count = 0;
        while(count < n-1 && first.next!=null){
            first = first.next;
            count += 1;
            if(count > n-m)
                second = second.next;
        }
        if(first.next == null){ return null;}
        ListNode temp = second.next;
        second.next = first.next;
        first.next = temp;
        temp = second.next.next;
        second.next.next = first.next.next;
        first.next.next = temp;
        return dumhead.next; 
    }
	
    // more easy way, just swap the value of two nodes
    public ListNode swapTwoLinkedList2(ListNode head, int m, int n){
        if(head == null){ return null;}
        m = (m < n)?m:n;
        n = (m < n)?n:m;
        ListNode first = head;
        ListNode second = head;
        int count = 0;
        while(count < n-1 && first!=null){
            first = first.next;
            count += 1;
            if(count > n-m)
                second = second.next;
        }
        if(first == null){ return null;}
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
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
	SwapTwoLinkedList sol = new SwapTwoLinkedList();
        ListNode head = sol.buildList(arr);
        sol.printList(head);
        head = sol.swapTwoLinkedList(head,1,9);
        sol.printList(head);
        head = sol.swapTwoLinkedList2(head,1,9);
        sol.printList(head);
    }

/* 
 * swap two nodes in linked list scheme:
 * node1->node2->node3->node3->node4
 * first swap node1.next with node2.next
 * node1.next = node2.next
 * node2.next = node2
 * second swap node2.next with node3.next
 * node2.next = node4
 * node3.next = node2
 *
 */
