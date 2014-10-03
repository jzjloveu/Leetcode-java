// Swap Nodes in Pairs 

// Given a linked list, swap every two adjacent nodes and return its head.

// For example:
// Given 1->2->3->4, you should return the list as 2->1->4->3.
// Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

// Definition for singly-linked list.
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
        val = x;
        next = null;
     }
}

public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
	if(head == null){ return null;}
        ListNode curr = new ListNode(0);
        curr.next = head;
        head = curr;
        while(true){
		if(curr.next == null){ break;}
		if(curr.next.next == null){ break;}
		ListNode p1 = curr.next;
		ListNode p2 = p1.next;
		p1.next = p2.next;
		p2.next= p1;
		curr.next = p2;
		curr = p1;
        }
        return head.next; 
    }
	
    // more easy way, just swaps the values of two nodes
    public ListNode swapPairs2(ListNode head){
        if(head == null){ return null;}
        ListNode curr = new ListNode(0);
        curr.next = head;
        head = curr;
        while(true){
        	if(curr.next == null){ break;}
		if(curr.next.next == null){ break;}
                int temp = curr.next.val;
                curr.next.val = curr.next.next.val;
                curr.next.next.val = temp;
                curr = curr.next.next;
        }
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
        if (head==null){ System.out.print("null");}
    	while(head!=null){
		System.out.print(head.val+" ");
		head = head.next;	    
    	}  
        System.out.println();  	 
    }
    
    public static void main(String args[]){
	int[] arr = {1,2,3,4,5,6,7,8,9};
	SwapPairs sol = new SwapPairs();
        ListNode head = sol.buildList(arr);
        sol.printList(head);
        head = sol.swapPairs2(head);
        sol.printList(head);
    }
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
