// Sort List 

// Sort a linked list in O(n log n) time using constant space complexity.

// Definition for singly-linked list.
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
        val = x;
        next = null;
     }
}

public class SortList {
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
    
    private static ListNode getHalf(ListNode head){
    	ListNode fast, slow, mid;
    	if(head==null || head.next==null){
    	    mid = null;
    	}
        else{   
            fast = head;
            slow = head;
            while(fast!=null && fast.next!=null){
                fast = fast.next.next;
                if(fast==null)
                    break;
                slow = slow.next;
            }
            mid = slow.next;
            slow.next = null;
        }
        return mid;
    }
    
    private static ListNode merge(ListNode listA, ListNode listB){
        ListNode head = new ListNode(0);
        ListNode current = head;
        while(true){
            if(listA==null){
        	current.next = listB;
        	break;
            }
            if(listB==null){
                current.next = listA;
                break;
            }
            if(listA.val<listB.val){
                current.next = listA;
                listA = listA.next;
            }
            else{
                current.next = listB;
                listB = listB.next;
            }
            current = current.next;
        }
        return head.next;
    }
    
    private static ListNode mergeSort(ListNode head){
        ListNode first = null,mid = null; 
        if(head==null || head.next==null)
            return head;
    
        mid = getHalf(head);
        first = mergeSort(head);
        mid = mergeSort(mid);
        return merge(first,mid);
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
	SortList sol = new SortList();
        ListNode head = sol.buildList(arr);
        sol.printList(head);
        head = sol.sortList(head);
        sol.printList(head);
    }
}
