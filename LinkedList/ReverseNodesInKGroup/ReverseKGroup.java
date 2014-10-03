// Reverse Nodes in k-Group

// Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

// If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

// You may not alter the values in the nodes, only nodes itself may be changed.

// Only constant memory is allowed.

// For example,
// Given this linked list: 1->2->3->4->5

// For k = 2, you should return: 2->1->4->3->5

// For k = 3, you should return: 3->2->1->4->5

// Definition for singly-linked list.
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
        val = x;
        next = null;
     }
}

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
	ReverseKGroup sol = new ReverseKGroup();
        ListNode head = sol.buildList(arr);
        sol.printList(head);
        head = sol.reverseKGroup(head,3);
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
