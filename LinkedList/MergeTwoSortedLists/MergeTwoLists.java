// Merge Two Sorted Lists 

// Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

// Definition for singly-linked list.
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
        val = x;
        next = null;
     }
}

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode dumhead = new ListNode(0);
        ListNode curr = dumhead;
        while(true){
            if(l1==null){
        	curr.next = l2;
        	break;
            }
            if(l2==null){
                curr.next = l1;
                break;
            }
            if(l1.val<l2.val){
                curr.next = l1;
                l1 = l1.next;
            }
            else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        return dumhead.next;
    }
    
    private static int[] RandomArray(int length) {
	int[] arr = new int[length];
	java.util.ArrayList<Integer> alist = new java.util.ArrayList<Integer>();
		
	for(int i=0;i<=arr.length;i++)
	    alist.add(i);
    	
    	java.util.Collections.shuffle(alist);
    	
	for(int i=0;i<arr.length;i++)
    	    arr[i] = alist.get(i);
    		
    	return arr;
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
	int[] arr1 = RandomArray(5);
        int[] arr2 = RandomArray(5);
	MergeTwoLists sol = new MergeTwoLists();
        ListNode l1 = sol.buildList(arr1);
        ListNode l2 = sol.buildList(arr2);
        sol.printList(l1);
        sol.printList(l2);
        ListNode head = sol.mergeTwoLists(l1,l2);
        sol.printList(head);
    }
}
