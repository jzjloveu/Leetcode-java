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

public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        while(root != null){
            if(root.left == null) { root = root.right; }
            else{
                TreeNode temp = root.left;
                while(temp.right != null) { temp = temp.right; }
                temp.right = root.right;
                root.right = root.left;
                root.left = null;
            }
        }
    }
    
    public static void main(String args[]){
	    String[] arr = {"1","2","5","3","4","#","6"};
        TreeNode root = TreeUtil.buildLeetTree(arr);
        TreeGphicPrint.printTree(root);
        FlattenBinaryTreeToLinkedList sol = new FlattenBinaryTreeToLinkedList();
        sol.flatten(root);
        TreeGphicPrint.printTree(root);
    }
}

/*
Note that the problem requires in-place operation.The flatten procedure is like:  
cut the left child and set to right, the right child is then linked to somewhere 
behind the left child. Where should it be then?  Actually the right child should 
be linked to the most-right node of the left node. So the algorithm is as follows:
(1) store the right child (we call R)
(2) find the right-most node of left child
(3) set R as the right-most node's right child.
(4) set left child as the right child
(5) set the left child NULL
(6) set current node to current node's right child.
(7) iterate these steps until all node are flattened.
*/