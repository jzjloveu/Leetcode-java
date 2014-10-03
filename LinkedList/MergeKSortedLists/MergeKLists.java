// Merge k Sorted Lists

// Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

import java.util.List;

// Definition for singly-linked list.
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
        val = x;
        next = null;
     }
}

public class MergeKLists {
    public ListNode mergeKLists(List<ListNode> lists){
        if(lists.size() == 0){ return null;}
        ListNode head = new ListNode(0);
        head.next = lists.get(0);
        for(int i=1;i<lists.size();i++){
		ListNode l1 = head;
                ListNode l2 = lists.get(i);
		while(l2 != null){
			if(l1.next==null){
				l1.next = l2;
				break;
		    	}
		    	if(l1.next.val < l2.val)
		        	l1 = l1.next;
		    	else{
                        	ListNode temp = l1.next;
                        	l1.next = l2;
		        	l2 = l2.next;
                        	l1.next.next = temp;
                        	l1 = l1.next;
		    	}
		}
        }
        return head.next;
    }
    
    private static int[] RandomSortedArray(int length) {
	int[] arr = new int[length];
	java.util.ArrayList<Integer> alist = new java.util.ArrayList<Integer>();
		
	for(int i=0;i<=100;i++)
	    alist.add(i);
    	
    	java.util.Collections.shuffle(alist);
    	
	for(int i=0;i<length;i++)
    	    arr[i] = alist.get(i);
    	
        java.util.Arrays.sort(arr);	
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

    private static void printLists(List<ListNode> lists){
        for(ListNode head:lists){
	    	while(head!=null){
	    	    System.out.print(head.val+" ");
		    head = head.next;	    
	    	}  
                System.out.println();  
        } 
    }

    public static void main(String args[]){
	int[] arr1 = RandomSortedArray(5);
        int[] arr2 = RandomSortedArray(5);
        int[] arr3 = RandomSortedArray(5);
        int[] arr4 = RandomSortedArray(5);
        int[] arr5 = RandomSortedArray(5);
	MergeKLists sol = new MergeKLists();
        ListNode l1 = sol.buildList(arr1);
        ListNode l2 = sol.buildList(arr2);
        ListNode l3 = sol.buildList(arr3);
        ListNode l4 = sol.buildList(arr4);
        ListNode l5 = sol.buildList(arr5);
        List<ListNode> lists = new java.util.ArrayList<ListNode>();
        lists.add(l1);lists.add(l2);lists.add(l3);lists.add(l4);lists.add(l5);
        sol.printLists(lists);
        sol.printList(sol.mergeKLists(lists));
    }
}
