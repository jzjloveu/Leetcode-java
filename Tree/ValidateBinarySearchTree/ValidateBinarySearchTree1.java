/*
Validate Binary Search Tree 

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

OJ's Binary Tree Serialization:
The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.

Here's an example:
   1
  / \
 2   3
    /
   4
    \
     5
The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".
*/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */ 
import treeUtil.*;

public class ValidateBinarySearchTree1 {
    public boolean isValidBST(TreeNode root) {
        return checkBST(Integer.MIN_VALUE,root,Integer.MAX_VALUE);
    }

    private boolean checkBST(int Min, TreeNode root, int Max){
        if(root == null) { return true; }
        if(!(Min < root.val && root.val < Max)) { return false; }
        return checkBST(Min,root.left,root.val) && 
            checkBST(root.val,root.right,Max);
    }
    
    public static void main(String args[]){
	    int[] arr1 = {0}; // {5,4,8,11,13,6,7,2,1}; // {1,1}; //
        TreeNode root1 = TreeUtil.buildTreeInOrder(arr1);
        TreeNode root2 = TreeUtil.buildTree(arr1);
        ValidateBinarySearchTree1 sol = new ValidateBinarySearchTree1();
        System.out.println(sol.isValidBST(root1));
        System.out.println(sol.isValidBST(root2));
    }
}

/*
Using left bound and right to validate.
Think more about the node than tree.
*/