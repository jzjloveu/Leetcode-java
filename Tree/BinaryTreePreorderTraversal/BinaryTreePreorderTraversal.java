/*
Binary Tree Preorder Traversal 

Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].

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

public class BinaryTreePreorderTraversal  {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> st = new Stack<TreeNode>();
        while(root != null || !st.empty()){
            if(root != null) { // pre-order print out
                result.add(root.val); st.push(root); root = root.left;
            }
            else{ root = st.pop();  root = root.right; }
        }
        return result;
    }

    public static void main(String args[]){
	    int[] arr = {1,2,3,4,5,6};
        TreeNode root = TreeUtil.buildTree(arr);
        TreeUtil.printTreePre(root);
        System.out.println();
        BinaryTreePreorderTraversal sol = new BinaryTreePreorderTraversal();
        TreeUtil.printList(sol.preorderTraversal(root));
    }
}

/*
Doing in the iteratively way:
Using stack to main the traversal. when root is not null, put it in stack and
go to the left child (root = root.left), till no more left child, then pull out
the stack which the previous value, the go to the right child ( root = root.right )
*/