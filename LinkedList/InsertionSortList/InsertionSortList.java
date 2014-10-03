// Insertion Sort List 

// Sort a linked list using insertion sort.

// Definition for singly-linked list.
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
        val = x;
        next = null;
     }
}

public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if(head==null)
        	return head;
        ListNode dumhead = new ListNode(0);
        dumhead.next = head;
        ListNode curr = head;
        while(curr.next != null){
        	if(curr.next.val < curr.val){
        		ListNode pre = dumhead;
        		while(pre.next.val < curr.next.val)
        			pre = pre.next;
        		ListNode tmp = curr.next;
        		curr.next = tmp.next;
        		tmp.next = pre.next;
        		pre.next = tmp;
        	}
        	else
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
	int[] arr = RandomArray(20);
	InsertionSortList sol = new InsertionSortList();
        ListNode head = sol.buildList(arr);
        sol.printList(head);
        head = sol.insertionSortList(head);
        sol.printList(head);
    }
}
