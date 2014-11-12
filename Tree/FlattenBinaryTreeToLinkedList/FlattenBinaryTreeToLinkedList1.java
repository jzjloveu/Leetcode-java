/*
Flatten Binary Tree to Linked List 

Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6

Hints:
If you notice carefully in the flattened tree, 
each node's right child points to the next node of a pre-order traversal.
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

public class FlattenBinaryTreeToLinkedList1 {
    public void flatten(TreeNode root) {
        if(root == null){ return; }
        flatten(root.left);
        flatten(root.right);
        if(root.left == null) { return; }
        else{
            TreeNode temp = root.left;
            while(temp.right != null) { temp = temp.right; }
            temp.right = root.right;
            root.right = root.left;
            root.left = null;
        }
    }
    
    public static void main(String args[]){
	    String[] arr = {"1","2","5","3","4","#","6"};
        TreeNode root = TreeUtil.buildLeetTree(arr);
        TreeGphicPrint.printTree(root);
        FlattenBinaryTreeToLinkedList1 sol = new FlattenBinaryTreeToLinkedList1();
        sol.flatten(root);
        TreeGphicPrint.printTree(root);
    }
}

/*
Flatten left child first and then flatten right, after that attach left to roo.right.
*/