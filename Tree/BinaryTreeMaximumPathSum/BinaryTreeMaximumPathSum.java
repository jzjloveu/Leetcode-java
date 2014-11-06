/*
Binary Tree Maximum Path Sum

Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
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
import java.util.*;
import treeUtil.*;

public class BinaryTreeMaximumPathSum {
    private static int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node){
        if(node == null) { return 0; }
        int leftVal = dfs(node.left);
        int rightVal = dfs(node.right);
        maxSum = Math.max(maxSum, leftVal+rightVal+node.val);
        return Math.max(Math.max(leftVal+node.val,rightVal+node.val),0);
    }
    
    public static void main(String args[]){
	    int[] arr = {1,2,3,4,5,6};
        TreeNode root = TreeUtil.buildTree(arr);
        BinaryTreeMaximumPathSum sol = new BinaryTreeMaximumPathSum();
        System.out.println(sol.maxPathSum(root));
    }
}

/*
Using dfs:
The max path can be root + left-child or root + right-child or only root.
And because node value can be negative, so if curr-root or curr-root + left-child
or curr-root + right-child less than zero then ignore it and return zero. 
*/