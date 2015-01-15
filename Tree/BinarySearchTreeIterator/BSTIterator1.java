/*
Binary Search Tree Iterator

Implement an iterator over a binary search tree (BST). Your iterator 
will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, 
where h is the height of the tree.
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

public class BSTIterator1 {
    private ArrayList<TreeNode> list;
    private int index;
    public BSTIterator1(TreeNode root) {
        list = new ArrayList<TreeNode>();
        inorderDFS(root, list);
        index = 0;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (index < list.size()) return true;
        return false;
    }

    /** @return the next smallest number */
    public int next() {
        return list.get(index++).val;
    }

    // Inorder traversal recursively.
    public void inorderDFS (TreeNode root, ArrayList<TreeNode> ret) {
        if (root == null) return;
        inorderDFS(root.left, ret);
        ret.add(root);
        inorderDFS(root.right, ret);
    }
/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
    public static void main(String args[]){
	    int[] arr = {1,2,3,4,5,6};
        TreeNode root = TreeUtil.buildTree(arr);
        TreeUtil.printTreeIn(root);
        System.out.println();
        BSTIterator1 sol = new BSTIterator1(root);
    }
}

/*
Using ArrayList, inorder traversal.
Memory used is O(size), not match question requirement.
*/