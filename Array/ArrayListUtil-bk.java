package arrayUtil;

import java.util.*;

public class ArrayListUtil {
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
      System.out.println("[]");
      System.out.println();
    }
  }

  public static void printListStr(List<String> alist){
    if(alist != null && !alist.isEmpty()){
      System.out.print("[");
      for(int i=0;i<alist.size();i++){
        if(i == alist.size()-1)
          System.out.print("\""+alist.get(i)+"\"");
        else
          System.out.print("\""+alist.get(i)+"\",");

      }
      System.out.print("]");
      System.out.println();
    }
    else{
      System.out.println("[]");
      System.out.println();
    }
  }

  public static void printListList(List<List<Integer>> alist){
    if(alist != null && !alist.isEmpty()){
      System.out.print("["); 
      System.out.println();
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
      System.out.println("[]");
      System.out.println();
    }
  }

  public static void printMapList(Map<Integer,List<Integer>> maplist){
    for(Integer key:maplist.keySet()){
      System.out.print(key+": ");
      List<Integer> lines = maplist.get(key);
      if(lines != null && !lines.isEmpty()){
        for(int i=0;i<lines.size();i++){
          System.out.print(lines.get(i)+" ");   
        }
      }
      System.out.println();
    }
  }

  public static void printMatrix(int[][] matrix){
    for(int i=0;i<matrix.length;i++){
      for(int j=0;j<matrix[0].length;j++)
        System.out.print(matrix[i][j]+" ");
      System.out.println();
    }
  }

  public static void printArray(int[] arr){
      if(arr.length == 0) {
        System.out.println("The array is empty.");
        return; }
      System.out.print("[");
      for(int i=0;i<arr.length;i++){
        if(i == arr.length-1)
          System.out.print(arr[i]);
        else
          System.out.print(arr[i]+", ");
      }
      System.out.print("]\n");
    }

    public static void main(String args[]){ }
  }
