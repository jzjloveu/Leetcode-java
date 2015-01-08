package ListUtil;

import java.util.*;
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
public class ListUtil {
    public static int[] RandomArray(int range, int length) {
        int[] arr = new int[length];
        ArrayList<Integer> alist = new ArrayList<Integer>();        
        for(int i=0;i<range;i++) { alist.add(i); }
        java.util.Collections.shuffle(alist);
        for(int i=0;i<arr.length;i++) { arr[i] = alist.get(i); }
        return arr;
    }
    
    public static ListNode buildList(int[] arr){
        ListNode head = new ListNode(0);
        ListNode curr = head;
        for(int i:arr){
            curr.next = new ListNode(i);
            curr = curr.next;
        }
        return head.next;
    }
    
    public static void printList(ListNode head){
        while(head!=null){
            System.out.print(head.val+" ");
            head = head.next;  
            if(head != null) System.out.print("-> ");
        }  
        System.out.println();    
    }

    public static void printList(ListNode[] lists){
        for(ListNode head: lists){
            while(head!=null){
                System.out.print(head.val+" ");
                head = head.next;  
                if(head != null) System.out.print("-> ");     
            }  
            System.out.println();
        }    
    }

    public static void main(String args[]){ }
}
