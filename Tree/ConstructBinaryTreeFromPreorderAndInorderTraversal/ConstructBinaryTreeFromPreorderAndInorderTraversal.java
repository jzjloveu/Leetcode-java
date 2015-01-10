/*
Construct Binary Tree from Preorder and Inorder Traversal 

Given preorder and inorder traversal of a tree, construct the binary tree.

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

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	if(inorder.length == 0 ) { return null; }
    	TreeNode root = new TreeNode(preorder[0]);
    	int rootIndex = 0;
    	for(int i=0;i<inorder.length;i++)
			if(inorder[i] == preorder[0]) { rootIndex = i; break; }
    	root.left = buildTree(Arrays.copyOfRange(preorder,1,rootIndex+1),
    		Arrays.copyOfRange(inorder,0,rootIndex));
    	root.right = buildTree( Arrays.copyOfRange(preorder,rootIndex+1,preorder.length),
    		Arrays.copyOfRange(inorder,rootIndex+1,inorder.length));
        return root;
    }

    public static void main(String args[]){
	    int[] inorder = {4,2,5,1,3,6};
        int[] pretorder = {1,2,4,5,3,6};
        ConstructBinaryTreeFromPreorderAndInorderTraversal sol = 
            new ConstructBinaryTreeFromPreorderAndInorderTraversal();
        TreeNode root = sol.buildTree(pretorder,inorder);
        TreeGphicPrint.printTree(root);
    }
}

/*
Recursive method:
This problem is similar as Construct Binary Tree From Inorder And Postorder Traversal.
*/