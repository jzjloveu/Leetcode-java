// Partition List 

// Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x. 

// You should preserve the original relative order of the nodes in each of the two partitions.

// For example,
// Given 1->4->3->2->5->2 and x = 3,
// return 1->2->2->4->3->5.

// Definition for singly-linked list.
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
        val = x;
        next = null;
     }
}

public class PartitionList {
    public ListNode partitionList(ListNode head, int x) {
        if(head==null){ return head;}
        ListNode headLess,currLess,headGreat,currGreat,prev,curr;
        headLess = currLess = new ListNode(0);
        headGreat = currGreat = new ListNode(0);
        prev = null;
        curr = head;
        while(curr != null){
            prev = curr;
            curr = curr.next;
            if(prev.val < x){
                 currLess.next = prev;
                 currLess = currLess.next;
                 currLess.next = null;
            }
            else{
                 currGreat.next = prev;
                 currGreat = currGreat.next;
                 currGreat.next = null;
            }
        } 
        currLess.next = headGreat.next;
        return headLess.next;
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
	int[] arr = {1,4,3,2,5,2};
	PartitionList sol = new PartitionList();
        ListNode head = sol.buildList(arr);
        sol.printList(head);
        head = sol.partitionList(head,3);
        sol.printList(head);
    }
}
