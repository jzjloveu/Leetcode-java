/*
Maximum Depth of Binary Tree

Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along 
the longest path from the root node down to the 
farthest leaf node.
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

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root == null) { return 0;}
        if(root.left==null && root.right==null) { return 1;}
        if(root.right==null) { 
            return maxDepth(root.left) + 1;
        }
        if(root.left==null) { 
            return maxDepth(root.right) + 1;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }
    
    public static void main(String args[]){
	    int[] arr1 = {5,4,8,11,13,4,7,2,1};
        TreeNode root1 = TreeUtil.buildTree(arr1);
        TreeUtil.printTreePre(root1);
        System.out.println();
        MaximumDepthOfBinaryTree sol = new MaximumDepthOfBinaryTree();
        System.out.println(sol.maxDepth(root1));
    }
}
