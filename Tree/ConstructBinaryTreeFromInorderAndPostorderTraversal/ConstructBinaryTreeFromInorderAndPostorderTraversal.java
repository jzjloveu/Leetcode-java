/*
Construct Binary Tree from Inorder and Postorder Traversal 

Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
*/
package treeUtil;
import java.util.*;
import treeUtil.*;
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    	if(inorder.length == 0 ) { return null; } //inorder is empty
    	TreeNode root = new TreeNode(postorder[postorder.length-1]);
        int rootIndex = 0;
    	for(int i=0;i<inorder.length;i++)
			if(inorder[i]==postorder[postorder.length-1]){ rootIndex=i; break; }
    	root.left = buildTree(Arrays.copyOfRange(inorder,0,rootIndex),
    		Arrays.copyOfRange(postorder,0,rootIndex));
    	root.right = buildTree(Arrays.copyOfRange(inorder,rootIndex+1,inorder.length),
    		Arrays.copyOfRange(postorder,rootIndex,postorder.length-1));
        return root;
    }

    public static void main(String args[]){
	    int[] inorder = {4,2,5,1,3,6};
        int[] postorder = {4,5,2,6,3,1};
        ConstructBinaryTreeFromInorderAndPostorderTraversal sol = 
            new ConstructBinaryTreeFromInorderAndPostorderTraversal();
        TreeNode root = sol.buildTree(inorder,postorder);
        TreeGphicPrint.printTree(root);
    }
}

/*
Recursive method:
1. Find the last node in the postorder vector, which is the root of the current tree.
2. Find the position of root node in the inorder vector, which divide the inorder vector 
into 2 sub tree inorder vectors. Left part is the left sub-tree, right part is the right sub-tree.
3. Do 1 and 2 for the right and left sub-tree, respectively.
(Updated in 201309)
e.g. The tree is:
        1
   2        3
4   5         6
Inorder:     425136
Postorder:   452631

So, first we have 1 as the root node, and find 1's position in inorder, 425  1  36
Then we search: inorder 36        as the right child, and  inorder:   425  as the left child
                postorder (452)63                          postorder: 452
*/