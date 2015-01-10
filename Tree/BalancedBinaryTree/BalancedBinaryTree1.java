/*
Balanced Binary Tree

Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined 
as a binary tree in which the depth of the two subtrees of 
every node never differ by more than 1.
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

public class BalancedBinaryTree1 {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return checkBlance(root) != -1;
    }

    private int checkBlance(TreeNode root){
        if(root == null) return 0;
        int left = checkBlance(root.left);
        if(left == -1) return -1;
        int right = checkBlance(root.right);
        if(right == -1) return -1;
        if(left-right>1 || right-left>1) return -1;
        return left>right? left+1 : right+1;
    }
    
    public static void main(String args[]){
	    int[] arr1 = {5,4,8,11,13,4,7,2,1};
        TreeNode root1 = TreeUtil.buildTree(arr1);
        TreeUtil.printTreePre(root1);
        System.out.println();
        BalancedBinaryTree1 sol = new BalancedBinaryTree1();
        System.out.println(sol.isBalanced(root1));
    }
}

/*
Recursion. For each node, check the left branch and right branch.
*/