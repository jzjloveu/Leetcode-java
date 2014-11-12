/*
Convert Sorted Array to Binary Search Tree

Given an array where elements are sorted in ascending order, 
convert it to a height balanced BST.
*/
package treeUtil;
import treeUtil.*;
import java.util.*;
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
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

public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> num = new ArrayList<Integer>();
        while(head != null){
        	num.add(head.val); head = head.next;
        }
        return buildBST(num, 0, num.size()-1);
    }

    private TreeNode buildBST(List<Integer> num, int start, int end) {
        if(start-end > 0) { return null; }
        int mid = (start+end)/2;
        TreeNode root = new TreeNode(num.get(mid));
        root.left = buildBST(num, start, mid-1);
        root.right = buildBST(num, mid+1, end);
        return root;
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

    public static void main(String args[]){
	    int[] arr = {1,2,3,4,5,6};
        ConvertSortedListToBinarySearchTree sol = 
            new ConvertSortedListToBinarySearchTree();
        ListNode head = sol.buildList(arr);
        TreeNode root = sol.sortedListToBST(head);
        TreeGphicPrint.printTree(root);
        System.out.println();
    }
}

/*
Recuesively get array mid-element as root to build a BST.
*/