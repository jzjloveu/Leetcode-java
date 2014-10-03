/*
PSame Tree

Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical 
and the nodes have the same value.
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

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) { return true;}
        if((p==null && q!=null) || (p!=null && q==null)){
            return false;
        }
        if(p.val != q.val) { return false;}
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
    
    public static void main(String args[]){
	      int[] arr1 = {5,4,8,11,13,4,7,2,1};
        int[] arr2 = {5,4,8,11,13,4,7,2,2};
        TreeNode root1 = TreeUtil.buildTree(arr1);
        TreeNode root2 = TreeUtil.buildTree(arr2);
        TreeUtil.printTreePre(root1);
        System.out.println();
        TreeUtil.printTreePre(root2);
        System.out.println();
	      SameTree sol = new SameTree();
        System.out.println(sol.isSameTree(root1,root2));
    }
}
