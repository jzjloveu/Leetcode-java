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

public class PathSumIIBK {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        
        if (root==null){
            return result;
        }
        
        List<Integer> current=new ArrayList<Integer>();
        buildResult(root, sum, current, result);
        
        return result;
    }

    private void buildResult(TreeNode root,int sum, List<Integer> current, List<List<Integer>> result){
        
        if (root==null){
            return;
        }
        
        int currentVal=root.val;
        current.add(currentVal);
        if (root.left==null && root.right==null){
            
            if (sum-currentVal==0){
                List<Integer> temp=new ArrayList<Integer> (current);
                result.add(temp);
            }
        }
        
        buildResult(root.left, sum-currentVal, current, result);
        buildResult(root.right, sum-currentVal, current, result);
        
        current.remove(current.size()-1);
    }

    public static void main(String args[]){
	    int[] arr = {0,1,1}; //{5,4,8,11,13,4,7,2,1,5};
        int sum = 1;//22;
        TreeNode root = TreeUtil.buildTree(arr);
        TreeUtil.printTreePre(root);
        System.out.println();
	    PathSumIIBK sol = new PathSumIIBK();
        TreeUtil.printListList(sol.pathSum(root,sum));
    }
}
