/*
Search in Rotated Sorted Array

Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its 
index, otherwise return -1.

You may assume no duplicate exists in the array.
*/
import java.util.*;

public class SearchInRotatedSortedArray {
    public int search(int[] A, int target) {
        int left = 0, right = A.length-1;
        while(left <= right){
            int mid = (left+right) / 2;
            if(A[mid] == target) { return mid; }
            // the left hand side is increasing
            if(A[mid] >= A[left]){
                // A[left] may equal to target
                if(A[left] <= target && target < A[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            else{ // the right hand side is increasing
                if(A[mid] < target && target <= A[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return -1;
    }
    
    public static void main(String args[]){
        int[] A = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println((new SearchInRotatedSortedArray()).search(A,target));
    }
}

/*
Binary search.  Just need to consider left hand side increase or
right hand side increase.
*/