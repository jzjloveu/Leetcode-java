/*
Validate Binary Search Tree 

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

OJ's Binary Tree Serialization:
The serialization of a binary tree follows a level order traversal, where '#' signifies 
a path terminator where no node exists below.

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
        return verifyBST(root,false,false,0,0);
    }

    private boolean verifyBST(TreeNode root, boolean left, boolean right,
            int lmax, int rmin){
        if(root == null) { return true; }
        if(left && root.val>=lmax) { return false; }
        if(right && root.val<=rmin) { return false; }
        boolean leftValid = verifyBST(root.left,true,right,root.val,rmin);
        boolean rightValid = verifyBST(root.right,left,true,lmax,root.val);
        return leftValid && rightValid;
    }
    
    public static void main(String args[]){
	    int[] arr1 = {0}; // {1,1}; //{5,4,8,11,13,6,7,2,1}; //
        TreeNode root1 = TreeUtil.buildTreeInOrder(arr1);
        TreeNode root2 = TreeUtil.buildTree(arr1);
        ValidateBinarySearchTree1 sol = new ValidateBinarySearchTree1();
        System.out.println(sol.isValidBST(root1));
        System.out.println(sol.isValidBST(root2));
    }
}

/*
For each subtree, give it max and min bound, if outside return fasle.
But for root node there is no bound.
For each level root, left subtree max bound should less than root,
right subtree min bound should greater than root.
Notice that for recursive call, should input parent node value.
*/