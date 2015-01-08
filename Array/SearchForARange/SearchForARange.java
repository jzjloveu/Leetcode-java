/*
Search for a Range

Given a sorted array of integers, find the starting and ending 
position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
*/
import arrayUtil.*;

public class SearchForARange {
    public int[] searchRange(int[] A, int target) {
        int[] result = {-1, -1};
        int start = 0, end = A.length-1;
        while(start < end){
            int mid = (start+end)/2;
            if(A[mid] < target) start = mid+1;
            else end = mid;
        }
        int lowbound = (A[start]==target)?start:-1;
        if(lowbound == -1) {return result; }
        start = lowbound; end = A.length;
        while(start < end){
            int mid = (start+end)/2;
            if(A[mid] > target) end = mid;
            else start = mid + 1;
        }
        int highbound = start - 1;
        result[0]=lowbound; result[1]=highbound;
        return result;
    }
    
    public static void main(String args[]){
        int[] A = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] arr = (new SearchForARange()).searchRange(A, target);
        ArrayListUtil.printArray(arr);
    }
}

/*
Binary search.
First from the left part find the low bound.
Second from the right part find the high bound.
*/