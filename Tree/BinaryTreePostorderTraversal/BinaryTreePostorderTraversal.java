/*
Binary Tree Postorder Traversal 

Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].

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

public class BinaryTreePostorderTraversal  {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode previous = null;
        while(root != null || !st.empty()){
            if(root != null) {
                st.push(root); root = root.left;
            }
            else if(previous == st.peek().right){
                previous = st.pop(); result.add(previous.val); // post-order print out 
            }
            else{ root = st.peek().right; previous = null;}
        }
        return result;
    }

    public static void main(String args[]){
	    int[] arr = {1,2,3,4,5,6};
        TreeNode root = TreeUtil.buildTree(arr);
        TreeUtil.printTreePos(root);
        System.out.println();
        BinaryTreePostorderTraversal sol = new BinaryTreePostorderTraversal();
        TreeUtil.printList(sol.postorderTraversal(root));
    }
}

/*
Doing in the iteratively way:
Using stack to main the traversal. when root is not null, put it in stack and
go to the left child (root = root.left), till no more left child, then pull out
the stack which the previous value, the go to the right child ( root = root.right ).
We need a varible (previous) to store the status of left child or right child, 
if previous is right child then we can pop out the root.
*/