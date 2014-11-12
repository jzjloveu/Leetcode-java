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

public class BinaryTreeLevelOrderTraversalII  {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) { return result; }
        List<Integer> level = new ArrayList<Integer>();
        Deque<TreeNode> q1 = new ArrayDeque<TreeNode>();
        Deque<TreeNode> q2 = new ArrayDeque<TreeNode>();
        q1.add(root);
        while(true){
            while(!q1.isEmpty()){
                TreeNode node = q1.pollFirst();
                if(node.left != null) { q2.add(node.left); }
                if(node.right != null) { q2.add(node.right); }
                level.add(node.val);
            } 
            result.add(level);
            q1 = q2;
            level = new ArrayList<Integer>();
            q2 = new ArrayDeque<TreeNode>();
            if(q1.isEmpty()) { 
                Collections.reverse(result);
                return result; 
            }
        }
    }

    public static void main(String args[]){
	    int[] arr = {1,2,3,4,5,6};
        TreeNode root = TreeUtil.buildTree(arr);
        BinaryTreeLevelOrderTraversalII sol = new BinaryTreeLevelOrderTraversalII();
        TreeUtil.printListList(sol.levelOrderBottom(root));
    }
}

/*
The output is slightly different from the classical level-order problem, 
which do not require the level information. So in this problem one way to 
get the level is using another queue to save the current level nodes.

The main steps are:
1. Push the root node into queue 1, which is level 1 (or 0)
2. Pop all the nodes from queue 1 to get the current level, for each poped node, 
push their left child and right child into queue 2.
3. Set queue 1 = queue 2.
4. clear queue 2.
*/