// Linked List Cycle II 

//  Given a linked list, return the node where the cycle begins. 
//  If there is no cycle, return null.

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

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if(head==null){ return null;}
        ListNode fast = head;
        ListNode slow = head;
        boolean flag = false;
        while(fast.next != null && fast.next.next != null){
        	fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                flag = true;
                break;
            } 
        }
        if(!flag){ return null; }
        fast = head;
        while(fast != slow){
        	fast = fast.next;
            slow = slow.next;
        }
        return fast;
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
                 curr.next = head.next.next.next.next;
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
	LinkedListCycleII sol = new LinkedListCycleII();
        ListNode head = sol.buildList(arr);
        //sol.printList(head);
        System.out.println(sol.detectCycle(head).val);
    }
}

/*
Firstly let us assume the slow pointer (S) and fast pointer (F) 
start at the same place in a n node circle. S run t steps while F 
can run 2t steps, we want to know what is t (where they meet) , then
just solve:  t mod n = 2t mod n,  we know when t = n, they meet, that 
is the start of the circle.

For our problem, we can consider the time when S enter the loop for 
the 1st time, which we assume k step from the head. At this time, 
the F is already in k step ahead in the loop. When will they meet next time? 
Still solve the function:    
t mod n = (k + 2t) mod n
Finally, when t = (n-k), S and F will meet, 
this is k steps before the start of the loop.

The way to find loop start point after loop detect:
1. Set fast to the head.
2. slow = slow.next, fast = fast.next
3. until they meet, count the steps.
*/