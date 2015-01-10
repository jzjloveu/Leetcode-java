/*
Sum Root to Leaf Numbers

Given a binary tree containing digits from 0-9 only, each root-to-leaf 
path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
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

public class SumRoottoLeafNumbers {
    private static int result;

    public int sumNumbers(TreeNode root) {
        if(root == null) { return 0;}
        if(root.left == null && root.right == null) { return root.val; }
        result = 0;
        if(root.left != null) { dfs(root.left, root.val); }
        if(root.right != null) { dfs(root.right, root.val); }
        return result;
    }

    private void dfs(TreeNode root, int value){
        if(root == null) return; 
        if(root.left == null && root.right == null)
            result += value * 10 + root.val;

        dfs(root.left, value*10+root.val);
        dfs(root.right, value*10+root.val);
    }
    
    public static void main(String args[]){
	    int[] arr = {1,2,3,4,5,6};
        TreeNode root = TreeUtil.buildTree(arr);
        SumRoottoLeafNumbers sol = new SumRoottoLeafNumbers();
        System.out.println(sol.sumNumbers(root));
    }
}

/*
Using dfs: 
Parent pass its value to its child, and child use that value multiple 
10 plus itself value as it own new value.
*/