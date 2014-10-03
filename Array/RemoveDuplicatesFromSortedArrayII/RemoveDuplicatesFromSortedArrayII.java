/*
Remove Duplicates from Sorted Array II 

Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array A = [1,1,1,2,2,3],

Your function should return length = 5, and A is now [1,1,2,2,3].
*/
import java.util.*;

public class RemoveDuplicatesFromSortedArrayII {
     public int removeDuplicates(int[] A) {
        if(A.length == 0) { return 0; }
        int slow = 0, count = 0;
        for(int fast=1;fast<A.length;fast++){
          if(A[fast] == A[fast-1]){
            count++;
            if(count <= 1){
              slow += 1;
              A[slow] = A[fast];
            }
          }
          else{
            count = 0;
            slow += 1;
            A[slow] = A[fast];
          }
        }
        return slow+1;
    }

    public static void main(String args[]){
        int[] s = {1,1,1,2,2,3}; // {-1,0,0,0,0,3,3}; //
        System.out.println(
          (new RemoveDuplicatesFromSortedArrayII()).removeDuplicates(s));
 
    }
}
