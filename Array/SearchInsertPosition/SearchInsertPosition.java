/*
Search Insert Position

Given a sorted array and a target value, return the index if the target is found. 
If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 -> 2
[1,3,5,6], 2 -> 1
[1,3,5,6], 7 -> 4
[1,3,5,6], 0 -> 0
*/

public class SearchInsertPosition {
    public int searchInsert(int[] A, int target) {
        int start = 0, end = A.length-1;
        while(start <= end){
            int mid = (start+end)/2;
            if(A[mid] == target) { return mid; }
            if(mid>start && A[mid]>target && A[mid-1]<target) 
                return mid;
            if(A[mid] > target) { end = mid - 1; }
            else { start = mid + 1; }
        }
        return start;
    }
    
    public static void main(String args[]){
        int[] A = {1,3,5,6};
        int target = 2;
        int index = (new SearchInsertPosition()).searchInsert(A, target);
        System.out.println(index);
    }
}

/*
Binary search.
First from the left part find the low bound.
Second from the right part find the high bound.
*/