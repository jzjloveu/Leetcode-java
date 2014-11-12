/*
Path Sum

Given a binary tree and a sum, determine if the tree has a root-to-leaf path 
such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
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

public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) { return false;}
        if(root.val == sum && root.left == null && root.right == null) { return true;}
        if(root.left != null && hasPathSum(root.left,sum - root.val)) { return true;}
        if(root.right != null && hasPathSum(root.right,sum - root.val)) { return true;}
        return false;
    }
    
    public static void main(String args[]){
	      // int[] arr = {5,4,8,11,13,4,7,2,1};
        String[] arr = {"5","4","8","11","#","13","4","7","2","#","#","#","1"};
        int sum = 22;
        // TreeNode root = TreeUtil.buildTree(arr);
        TreeNode root = TreeUtil.buildLeetTree(arr);
        // TreeUtil.printTreePre(root);
        // System.out.println();
        TreeGphicPrint.printTree(root);
	      PathSum sol = new PathSum();
        System.out.println(sol.hasPathSum(root,sum));
    }
}
