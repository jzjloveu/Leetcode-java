/*
Recover Binary Search Tree 

Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. 
Could you devise a constant space solution?
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

public class RecoverBinarySearchTree {
    TreeNode last, first, second;
    public void recoverTree(TreeNode root) {
        last = first = second = null;
        dfs(root);
        if (first != null && second != null){
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }

    private void dfs (TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        if (last != null && node.val < last.val){
            if (first == null) { first=last; second=node;}
            else second = node;
        }
        last = node;
        dfs(node.right);
    }
    
    public static void main(String args[]){
	    String[] arr = {"4","3","10","1","6","#","14","#","#","8","7","13"};
        TreeNode root = TreeUtil.buildLeetTree(arr);
        TreeGphicPrint.printTree(root);
        (new RecoverBinarySearchTree()).recoverTree(root);
        TreeGphicPrint.printTree(root);
    }
}

/*
DFS, in-order tree traversal recursively.
What we need is actually two pointers, which point to 2 tree nodes where is incorrect. 
Therefore, we only need to store these two pointers, and, we also need another pointer 
to store the previous element, in order to ompare if the current element is valid or not.

The last step is to replace the wrong pair's value. And the in-order traversal is to search the 
whole BST and find the wrong pairs.

Note that: 
(1)the previous element is NOT the root node of the current element, 
but the previous element in the "in-order" order; 
(2) To store the wrong pair, the first found wrong element is stored in first pointer, 
while the next is stored in the second pointer.
*/