package stringListUtil;

import java.util.*;

public class StringListUtil {
  public static void printList(List<String> arr){
        System.out.print("[");
        for(int i=0;i<arr.size();i++){
            if(i<arr.size()-1) System.out.print("\""+arr.get(i)+"\""+",");
            else System.out.print("\""+arr.get(i)+"\"");
        }
        System.out.print("]\n"); 
  }

  public static void printListList(List<List<String>> alist){
    if(alist != null && !alist.isEmpty()){
      System.out.print("["); 
      System.out.println();
      for(int i=0;i<alist.size();i++){
        System.out.print("[");
        for(int j=0;j<alist.get(i).size();j++){
          if(j == alist.get(i).size()-1)
            System.out.print("\""+alist.get(i).get(j)+"\"");
          else
            System.out.print("\""+alist.get(i).get(j)+"\""+",");
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
    public static void main(String args[]){ }
  }
