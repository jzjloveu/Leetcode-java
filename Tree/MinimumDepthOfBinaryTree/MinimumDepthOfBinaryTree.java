/*
Minimum Depth of Binary Tree

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path 
from the root node down to the nearest leaf node.
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

public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if(root == null) { return 0;}
        if(root.left==null && root.right==null) { return 1;}
        if(root.right==null) { 
            return minDepth(root.left) + 1;
        }
        if(root.left==null) { 
            return minDepth(root.right) + 1;
        }
        return Math.min(minDepth(root.left),minDepth(root.right)) + 1;
    }
    
    public static void main(String args[]){
	    int[] arr1 = {5,4,8,11,13,4,7,2,1};
        TreeNode root1 = TreeUtil.buildTree(arr1);
        TreeUtil.printTreePre(root1);
        System.out.println();
        MinimumDepthOfBinaryTree sol = new MinimumDepthOfBinaryTree();
        System.out.println(sol.minDepth(root1));
    }
}
