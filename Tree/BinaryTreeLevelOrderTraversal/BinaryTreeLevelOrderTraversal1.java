/*
Binary Tree Level Order Traversal 

Given a binary tree, return the level order traversal of its nodes' values. 
(ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
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

public class BinaryTreeLevelOrderTraversal1 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) { return result; }
        Map<Integer,List<Integer>> level = new HashMap<Integer,List<Integer>>();
        preOder(root,level,0);
        for(Integer i:level.keySet()) result.add(level.get(i));
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
        TreeUtil.printTreeLevel(root);
        System.out.println();
        BinaryTreeLevelOrderTraversal1 sol = new BinaryTreeLevelOrderTraversal1();
        TreeUtil.printListList(sol.levelOrder(root));
    }
}

/*
Use pre-order traversal first, and store the level number,
then output result.
*/