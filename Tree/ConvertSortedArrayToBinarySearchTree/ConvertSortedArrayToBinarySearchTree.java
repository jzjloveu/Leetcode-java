/*
Convert Sorted Array to Binary Search Tree

Given an array where elements are sorted in ascending order, 
convert it to a height balanced BST.
*/
package treeUtil;
import treeUtil.*;
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] num) {
        return buildBST(num, 0, num.length-1);
    }

    private TreeNode buildBST(int[] num, int start, int end) {
        if(start-end > 0) { return null; }
        int mid = (start+end)/2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = buildBST(num, start, mid-1);
        root.right = buildBST(num, mid+1, end);
        return root;
    }

    public static void main(String args[]){
	    int[] arr = {1,2,3,4,5,6};
        ConvertSortedArrayToBinarySearchTree sol = 
            new ConvertSortedArrayToBinarySearchTree();
        TreeNode root = sol.sortedArrayToBST(arr);
        TreeGphicPrint.printTree(root);
        System.out.println();
    }
}

/*
Recuesively get array mid-element as root to build a BST.
*/