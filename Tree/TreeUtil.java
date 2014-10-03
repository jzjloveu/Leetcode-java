package treeUtil;

import java.util.*;
// Definition for binary tree
// class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode(int x) { val = x; }
// }
 
public class TreeUtil {
    public static TreeNode buildTree(int[] arr){
        if(arr.length == 0) { return null;}
        TreeNode[] nodes = new TreeNode[arr.length];
        for(int i=0;i<arr.length;i++)
            nodes[i] = new TreeNode(arr[i]);
        for(int index=0; index<arr.length/2;index++) {
            if(2*index+1 < arr.length)
                nodes[index].left = nodes[2*index+1];
            if(2*index+2 < arr.length)
                nodes[index].right = nodes[2*index+2];
        }
        return nodes[0];
    }

    public static TreeNode buildTreeInOrder(int[] arr){
        if(arr.length == 0) { return null;}
        TreeNode root = new TreeNode(arr[0]);
        for(int i=1;i<arr.length;i++)
            orderInsert(root,arr[i]);
        return root;
    }
    
    private static TreeNode orderInsert(TreeNode root, int data){
        // it there isn't any data and add it
        if(root == null) { return (new TreeNode(data));}
        else{
            if(data <= root.val)
                root.left = orderInsert(root.left, data);
            else
                root.right = orderInsert(root.right, data);
            return root;
        }
    }

    public static void printTreeIn(TreeNode node){
        if(node != null) { 
            printTreeIn(node.left);
            System.out.print(node.val+" ");
            printTreeIn(node.right);
        }
    }
    

    public static void printTreePre(TreeNode node){
        if(node != null) {
            System.out.print(node.val+" ");
            printTreePre(node.left);
            printTreePre(node.right);
        }
    }

    public static void printTreePos(TreeNode node){
        if(node != null) { 
            printTreePos(node.left);
            printTreePos(node.right);
            System.out.print(node.val+" ");
        }
    }

    public static void printList(List<Integer> alist){
        if(alist != null && !alist.isEmpty()){
            System.out.print("[");
            for(int i=0;i<alist.size();i++){
                if(i == alist.size()-1)
                    System.out.print(alist.get(i));
                else
                    System.out.print(alist.get(i)+",");
                    
            }
            System.out.print("]");
            System.out.println();
        }
        else{
            System.out.println("The list is null.");
            System.out.println();
        }
    }

    public static void printListList(List<List<Integer>> alist){
      if(alist != null && !alist.isEmpty()){
        System.out.print("["); System.out.println();
        for(int i=0;i<alist.size();i++){
          System.out.print("[");
          for(int j=0;j<alist.get(i).size();j++){
            if(j == alist.get(i).size()-1)
              System.out.print(alist.get(i).get(j));
            else
              System.out.print(alist.get(i).get(j)+",");
          }
          if(i == alist.size()-1)
            System.out.print("]");
          else
            System.out.print("],");
          System.out.println();
        }
        System.out.print("]");
              System.out.println();
      }
      else{
        System.out.println("The list is null.");
        System.out.println();
      }
  }

    public static void main(String args[]){ }
}
