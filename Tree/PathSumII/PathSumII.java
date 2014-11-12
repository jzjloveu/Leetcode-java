/*
Path Sum II

Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
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
import treeUtil.*;
import java.util.*;

public class PathSumII {
    private static int summ; 
    private static List<List<Integer>> paths; 
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        paths = new ArrayList<List<Integer>>();
        summ = sum;
        if(root == null) { return paths;}
        List<Integer> valList = new ArrayList<Integer>();
        valList.add(root.val);
        getPath(root,valList,root.val);
        return paths;
    }
    
    private static void getPath(TreeNode root, List<Integer> valList, int currSum){
        if(root == null){ return;}
        if(root.left == null && root.right == null){
            if(currSum == summ){
                List<Integer> temp=new ArrayList<Integer> (valList);
                paths.add(temp);
            }
        }
        if(root.left != null){
            valList.add(root.left.val);
            getPath(root.left,valList,currSum + root.left.val);
        }
        if(root.right != null){
            valList.add(root.right.val);
            getPath(root.right,valList,currSum + root.right.val);
        }
        valList.remove(valList.size()-1);
    }

    public static void main(String args[]){
	    // int[] arr = {5,4,8,11,13,4,7,2,1,5}; //{0,1,1};//
        String[] arr = {"5","4","8","11","#","13","4","7","2","#","#","5","1"};
        int sum = 22; //1;//
        // TreeNode root = TreeUtil.buildTree(arr);
        TreeNode root = TreeUtil.buildLeetTree(arr);
        // TreeUtil.printTreePre(root);
        // System.out.println();
        TreeGphicPrint.printTree(root);
        PathSumII sol = new PathSumII();
        TreeUtil.printListList(sol.pathSum(root,sum));
    }
}
