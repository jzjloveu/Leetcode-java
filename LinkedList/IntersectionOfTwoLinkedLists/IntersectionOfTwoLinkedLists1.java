/*
Intersection of Two Linked Lists

Write a program to find the node at which the intersection 
of two singly linked lists begins.

For example, the following two linked lists:

A:          a1 -> a2
                    \
                     c1 -> c2 -> c3
                    /            
B:     b1 -> b2 -> b3
begin to intersect at node c1.

Notes:
* If the two linked lists have no intersection at all, return null.
* The linked lists must retain their original structure after the function returns.
* You may assume there are no cycles anywhere in the entire linked structure.
* Your code should preferably run in O(n) time and use only O(1) memory.
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

public class IntersectionOfTwoLinkedLists1 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode pA=headA, pB=headB, tailA=null, tailB=null;
        while(true){
            if(pA == null) pA = headB;
            if(pB == null) pB = headA;
            if(pA.next == null) tailA = pA;
            if(pB.next == null) tailB = pB;
            //The two links have different tails. So just return null;
            if (tailA != null && tailB != null && tailA != tailB) 
                return null;
            if(pA == pB) return pA;
            pA = pA.next; pB = pB.next;
        }
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
            if(head!=null) System.out.print("-> ");	    
    	}  
        System.out.println();  	 
    }
    
    public static void main(String args[]){
	IntersectionOfTwoLinkedLists1 sol = new IntersectionOfTwoLinkedLists1();
    ListNode headA = buildList(new int[]{2,3});
    ListNode headB = buildList(new int[]{4,5,6});
    ListNode headC = buildList(new int[]{8,9,10});
    headA.next.next=headC; headB.next.next.next=headC; 
    System.out.println((sol.getIntersectionNode(headA,headB)).val);
    }
}

/*
Two pointer solution (O(n+m) running time, O(1) memory): (Standard solution)
Maintain two pointers pA and pB initialized at the head of A and B, respectively. 
Then let them both traverse through the lists, one node at a time.
When pA reaches the end of a list, then redirect it to the head of B 
(yes, B, that's right.); similarly when pB reaches the end of a list, 
redirect it the head of A.
If at any point pA meets pB, then pA/pB is the intersection node.
*/