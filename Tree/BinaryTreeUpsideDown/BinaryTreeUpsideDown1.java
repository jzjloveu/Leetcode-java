/*
Binary Tree Upside Down

Given a binary tree where all the right nodes are either leaf nodes 
with a sibling (a left node that shares the same parent node) or empty, 
flip it upside down and turn it into a tree where the original right 
nodes turned into left leaf nodes. Return the new root.

For example:
Given a binary tree {1,2,3,4,5},
    1
   / \
  2   3
 / \
4   5
return the root of the binary tree [4,5,2,#,#,3,1].
   4
  / \
 5   2
    / \
   3   1  
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

public class BinaryTreeUpsideDown1 {
    public TreeNode UpsideDownBinaryTree(TreeNode root) {
        TreeNode p = root, parent = null, parentR = null;
        while(p != null){
          TreeNode left = p.left;
          p.left = parentR;
          parentR = p.right;
          p.right = parent;
          parent = p;
          p = left;
        }
        return parent;
    }
    
    public static void main(String args[]){
        int[] arr = {1,2,3,4,5};
        TreeNode root = TreeUtil.buildTree(arr);
        TreeGphicPrint.printTree(root);
        System.out.println();
        BinaryTreeUpsideDown1 sol = new BinaryTreeUpsideDown1();
        TreeGphicPrint.printTree(sol.UpsideDownBinaryTree(root));
    }
}

/*
Where the original right nodes turned into left leaf nodes,
Let the original tree left node be a new node p, so we get:
p.left = parent.right
p.right = parent
*/