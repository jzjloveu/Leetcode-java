/*
Add Two Numbers 

You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
*/

// Definition for singly-linked list.
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
        val = x;
        next = null;
     }
}

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode dumhead = new ListNode(0);
        ListNode head = dumhead;
        int carry = 0;
        while(carry!=0 || l1!=null || l2!=null){
            ListNode node = new ListNode(carry);
            if(l1 != null){
        	node.val += l1.val;
        	l1 = l1.next;
            }
            if(l2 != null){
                node.val += l2.val;
                l2 = l2.next;
            }
            carry = node.val / 10;
            node.val %= 10;
            head.next = node;
            head = head.next;
        }
        return dumhead.next;
    }
    
    private static int[] RandomArray(int length) {
	int[] arr = new int[length];
	java.util.ArrayList<Integer> alist = new java.util.ArrayList<Integer>();
		
	for(int i=0;i<10;i++)
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
	AddTwoNumbers sol = new AddTwoNumbers();
        ListNode l1 = sol.buildList(arr1);
        ListNode l2 = sol.buildList(arr2);
        sol.printList(l1);
        sol.printList(l2);
        sol.printList(sol.addTwoNumbers(l1,l2));
    }
}
