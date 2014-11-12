/*
Unique Binary Search Trees II 

Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
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

public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        return dfs(1, n);
    }
	
	// return a list containing all root nodes of BSTs 
	// constructed from [start, end]
    private List<TreeNode> dfs(int start, int end) {
    	List<TreeNode> result = new ArrayList<TreeNode>();
        if(start > end) { result.add(null); return result; }
        for(int n=start;n<=end;n++) {
        	List<TreeNode> leftList = dfs(start, n-1);
        	List<TreeNode> rightList = dfs(n+1, end);
        	for(TreeNode left:leftList)
        		for(TreeNode right:rightList){
        			TreeNode root = new TreeNode(n);
        			root.left = left;
        			root.right = right;
        			result.add(root);
        		}
        }
        return result;
    }

    public static void main(String args[]){
	    int n = 3;
        UniqueBinarySearchTreesII sol = 
            new UniqueBinarySearchTreesII();
        List<TreeNode> roots = sol.generateTrees(n);
        for(TreeNode root:roots)
        	TreeGphicPrint.printTree(root);
    }
}

/*
The basic idea is still using the DFS scheme. 
It is a little hard to think the structure of the argument list in the function. 
It is clear that for each tree/subtree, we will set the root as the start position to 
the end position, and recursively construct the left subtree with the left part and 
the right subtree with the right part.

So first we can have
void dfs (int st, int ed){
    if (st>ed) {   // generate a null node }
    else{
      for (int i=st;i<=ed;i++){  
        dfs(st,i-1,   );     //generate left subtree 
        dfs(i+1,ed,   );  // generate right subtree
      }
    }
}

All the possible solutions of the tree are from the combinations of all the possible 
solutions of its left subtree, and its right subtree.  That is Left-Child X Right-Child.
So use a list to store all the roots of nodes.
*/