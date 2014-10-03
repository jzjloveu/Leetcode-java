// Reverse Linked List II 

// Reverse a linked list from position m to n. Do it in-place and one-pass.

// For example:
// Given 1->2->3->4->5->NULL, m=2 and n=4
// return 1->4->3->2->5->NULL

// Note:
// Given m, n satisfy the following condition:
// 1 <= m <= n <= length of list

// Definition for singly-linked list.
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
        val = x;
        next = null;
     }
}

public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n){
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
        ListNode temp1 = first.next.next;
        ListNode curr = second.next;
        ListNode prev = null;
        while(curr != temp1){
            ListNode temp2 = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp2;
	}
        second.next = prev;
        if(curr != null){
            while(prev.next != null)
                prev = prev.next;
            prev.next = curr;
	}
        return dumhead.next;
    }

    // this is easy way which reverses just value of nodes
    public ListNode reverseBetween2(ListNode head, int m, int n) {
	for(int i=0;i<n-m;i++){
		int index1 = n - i;
                int index2 = m + i;
                if(index2 >= index1){ return head;}
                ListNode first = head;
                ListNode second = head;
                while(index1-1>0){
                	first = first.next;
                        index1--;
                }
		while(index2-1>0){
                	second = second.next;
                        index2--;
                }
                int temp = second.val;
                second.val = first.val;
                first.val = temp;
        }
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
	int[] arr = {1,2,3,4,5,6,7,8,9,10};
	ReverseLinkedListII sol = new ReverseLinkedListII();
        ListNode head = sol.buildList(arr);
        sol.printList(head);
        head = sol.reverseBetween(head,1,8);
        sol.printList(head);
    }
}
