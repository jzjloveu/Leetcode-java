// Linked List Cycle 

//  Given a linked list, determine if it has a cycle in it.

// Follow up:
// Can you solve it without using extra space? 

// Definition for singly-linked list.
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
        val = x;
        next = null;
     }
}

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(head==null)
        	return false;
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
        	fast = fast.next.next;
                slow = slow.next;
                if(slow == fast)
                	return true; 
        }
        return false;
    }
    
    
	
    private static ListNode buildList(int[] arr){
	ListNode head = new ListNode(0);
        ListNode curr = head;
        for(int i:arr){
             curr.next = new ListNode(i);
             curr = curr.next;
        }
        curr = head;
        while(curr.next != null){
             curr = curr.next;
             if(curr.next == null){
                 curr.next = head.next.next.next;
                 break;
             }
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
	int[] arr = {0,1,2,3,4,5,6,7,8,9};
	LinkedListCycle sol = new LinkedListCycle();
        ListNode head = sol.buildList(arr);
        //sol.printList(head);
        System.out.println(sol.hasCycle(head));
    }
}
