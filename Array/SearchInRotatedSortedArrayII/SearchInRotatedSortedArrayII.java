/*
Search in Rotated Sorted Array II 

Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.
*/
import java.util.*;

public class SearchInRotatedSortedArrayII {
    public boolean search(int[] A, int target) {
        int left = 0, right = A.length-1;
        while(left <= right){
            int mid = (left+right) / 2;
            if(A[mid] == target) { return true; }
            if(A[mid] > A[left]){ // the right side rotated
                // A[left] may equal to target
                if(A[left] <= target && target < A[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            else if(A[mid] == A[left]){ left++; }
            else{ // A[mid] < A[left] the left side rotated 
                if(A[mid] < target && target <= A[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return false;
    }
    
    public static void main(String args[]){
        int[] A = {1,3,1,1,1};
        int target = 3;
        System.out.println((new SearchInRotatedSortedArrayII()).search(A,target));
    }
}

/*
When there's no duplicate, A[left] <= A[mid] means the right part 
is rotated. When there are duplicates, A[left] <= A[mid] is not certain.
E.g. A=[1,3,1,1,1], left = 0, right = 4, mid = 2, although A[left] <= A[mid], 
the left part is rotated. Here A[left] < A[mid] means the right part is rotated, 
when A[left] == A[mid] just left++.
*/