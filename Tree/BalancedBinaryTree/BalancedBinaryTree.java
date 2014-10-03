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

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        int[] res = checkBlance(root);
        if(res[1] == 1){ return true; }
        return false;
    }

    private int[] checkBlance(TreeNode root){
        if(root == null) { return new int[] {0,1};}
        int[] lres = checkBlance(root.left);
        int[] rres = checkBlance(root.right);
        int isBlan = 0;
        if(lres[1]==1 && rres[1]==1 && Math.abs(lres[0]-rres[0])<=1)
            isBlan = 1;
        return new int[] {Math.max(lres[0],rres[0])+1, isBlan};
    }
    
    public static void main(String args[]){
	    int[] arr1 = {5,4,8,11,13,4,7,2,1};
        TreeNode root1 = TreeUtil.buildTree(arr1);
        TreeUtil.printTreePre(root1);
        System.out.println();
        BalancedBinaryTree sol = new BalancedBinaryTree();
        System.out.println(sol.isBalanced(root1));
    }
}
