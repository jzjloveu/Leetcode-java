/*
Binary Tree Inorder Traversal

Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?
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

public class BinaryTreeInorderTraversal  {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> st = new Stack<TreeNode>();
        while(root != null || !st.empty()){
            if(root != null) {
                st.push(root); root = root.left;
            }
            else{                // in-order print out
                root = st.pop(); result.add(root.val); root = root.right;
            }
        }
        return result;
    }

    public static void main(String args[]){
	    int[] arr = {1,2,3,4,5,6};
        TreeNode root = TreeUtil.buildTree(arr);
        TreeUtil.printTreeIn(root);
        System.out.println();
        BinaryTreeInorderTraversal sol = new BinaryTreeInorderTraversal();
        TreeUtil.printList(sol.inorderTraversal(root));
    }
}

/*
Doing in the iteratively way:
Using stack to main the traversal. when root is not null, put it in stack and
go to the left child (root = root.left), till no more left child, then pull out
the stack which the previous value, the go to the right child ( root = root.right )
*/