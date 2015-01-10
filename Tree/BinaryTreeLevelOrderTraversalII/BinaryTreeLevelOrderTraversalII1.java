/*
Binary Tree Level Order Traversal II

Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
(ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
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

public class BinaryTreeLevelOrderTraversalII1  {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) { return result; }
        Map<Integer,List<Integer>> level = new HashMap<Integer,List<Integer>>();
        preOder(root,level,0);
        for(int i=level.size()-1;i>=0;i--) result.add(level.get(i));
        return result;
    }

    private void preOder(TreeNode root, Map<Integer,List<Integer>> lvl, int lev){
        if(lvl.containsKey(lev)) lvl.get(lev).add(root.val);
        else lvl.put(lev,new ArrayList<Integer>(Arrays.asList(root.val)));
        if(root.left != null) preOder(root.left,lvl,lev+1);
        if(root.right != null) preOder(root.right,lvl,lev+1);
    }

    public static void main(String args[]){
	    int[] arr = {1,2,3,4,5,6};
        TreeNode root = TreeUtil.buildTree(arr);
        BinaryTreeLevelOrderTraversalII1 sol = new BinaryTreeLevelOrderTraversalII1();
        TreeUtil.printListList(sol.levelOrderBottom(root));
    }
}

/*
Use pre-order traversal first, and store the level number,
then output result.
*/