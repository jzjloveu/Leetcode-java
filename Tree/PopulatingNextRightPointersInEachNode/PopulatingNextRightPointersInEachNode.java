/*
Populating Next Right Pointers in Each Node 

Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is 
no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at 
    the same level, and every parent has two children).

For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
*/

import java.util.*;

// Definition for binary tree with next pointer.
class TreeLinkNode {
     int val;
     TreeLinkNode left, right, next;
     TreeLinkNode(int x) { val = x; }
}

public class PopulatingNextRightPointersInEachNode  {
    public void connect(TreeLinkNode root) {
        if(root == null) { return; }
        int curNodeNum = 0;
        Deque<TreeLinkNode> queue = new ArrayDeque<TreeLinkNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeLinkNode currNode = queue.pollFirst();
            curNodeNum++;
            if(currNode.left != null) { 
                queue.add(currNode.left); 
                queue.add(currNode.right); 
            }
            if((curNodeNum & (curNodeNum+1)) == 0)
                currNode.next = null;
            else
                currNode.next = queue.getFirst();
        } 
    }

    public static void main(String args[]){
	    int[] arr = {1,2,3,4,5,6,7};
        // TreeNode root = TreeUtil.buildTree(arr);
        PopulatingNextRightPointersInEachNode sol = 
            new PopulatingNextRightPointersInEachNode();
        // TreeGphicPrint.printTree(root);
    }
}

/*
Use a queue to traverse the binary tree by level. When we meet the 
1st, 3rd, 7th, 15th, 31th... node (note that they are close to 2^n), 
assign None to their "next" field. Bit operation can be used to check 
whether N is 1, 3, 7, 15, 31... or not. N & (N + 1) == 0
*/