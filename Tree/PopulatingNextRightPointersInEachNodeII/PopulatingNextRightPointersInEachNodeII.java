/*
Populating Next Right Pointers in Each Node II 

Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
*/

import java.util.*;

// Definition for binary tree with next pointer.
class TreeLinkNode {
     int val;
     TreeLinkNode left, right, next;
     TreeLinkNode(int x) { val = x; }
}

public class PopulatingNextRightPointersInEachNodeII  {
    public void connect(TreeLinkNode root) {
        TreeLinkNode curr = root;
        while(curr != null) {
            TreeLinkNode NextLvlFirst = null, previous = null;
            while(curr != null) {
                if(NextLvlFirst == null){
                    if(curr.left!=null) NextLvlFirst = curr.left;
                    else NextLvlFirst = curr.right;
                }
                if(curr.left != null) { 
                    if(previous != null) previous.next = curr.left;
                    previous = curr.left;
                }
                if(curr.right != null) { 
                    if(previous != null) previous.next = curr.right;
                    previous = curr.right;
                }
                curr = curr.next;
            }
            curr = NextLvlFirst;
        } 
    }

    public static void main(String args[]){
	    String[] arr = {"1","2","3","4","5","#","7"};
        // TreeNode root = TreeUtil.buildLeetTree(arr);
        PopulatingNextRightPointersInEachNodeII sol = 
            new PopulatingNextRightPointersInEachNodeII();
        // sol.connect(root);
        // TreeGphicPrint.printTree(root);
    }
}

/*
When traversing the current level, build the next level.
*/