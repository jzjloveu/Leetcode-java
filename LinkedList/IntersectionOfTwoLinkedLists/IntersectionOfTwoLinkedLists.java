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
package ListUtil;
import ListUtil.*;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        int lenA = getSize(headA), lenB = getSize(headB);
        if(lenA > lenB)
            while(lenA > lenB){ headA = headA.next; lenA--;}
        else while(lenB > lenA){ headB = headB.next; lenB--;}
        while(headA != null){
            if(headA == headB) return headA;
            headA = headA.next; headB = headB.next;
        }
        return null;
    }
    
    private int getSize(ListNode node){
        int length = 0;
        while(node!=null){ length++; node = node.next;}
        return length;
    }
    
    public static void main(String args[]){
    	IntersectionOfTwoLinkedLists sol = new IntersectionOfTwoLinkedLists();
        ListNode headA = ListUtil.buildList(new int[]{2,3});
        ListNode headB = ListUtil.buildList(new int[]{4,5,6});
        ListNode headC = ListUtil.buildList(new int[]{8,9,10});
        headA.next.next=headC; headB.next.next.next=headC; 
        ListUtil.printList(headA); ListUtil.printList(headB);
        System.out.println((sol.getIntersectionNode(headA,headB)).val);
    }
}

/*
Get both list length, then start to traverse from the shorter length.
e.g.
     a1 -> a2
     |       \
     |         c1 -> c2 -> c3
     |       /            
b1 ->|b2 -> b3
     v
   start point 
*/