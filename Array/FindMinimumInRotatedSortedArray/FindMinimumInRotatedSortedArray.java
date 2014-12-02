/*
Find Minimum in Rotated Sorted Array

Suppose a sorted array is rotated at some pivot unknown 
to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.
*/

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] num) {
        int res=num[0], start=0, end=num.length-1;
        while(start <= end){
            int mid = (start+end)/2;
            // right part ordered
            if(num[mid] < num[end]){
                res = Math.min(res, num[mid]);
                end = mid - 1;
            }
            else{ //right part unordered
                res = Math.min(res, num[start]);
                start = mid + 1;
            }
        } 
        return res;
    }
    
    public static void main(String args[]){
        int[] arr = {4, 5, 6, 7, 0, 1, 2}; 
        FindMinimumInRotatedSortedArray sol = 
            new FindMinimumInRotatedSortedArray();
        System.out.println(sol.findMin(arr));
        
    }
}

/*
Using binary search.
Since there is only 1 rotation, which means that if right part is unordered, 
the left part of array must be ordered.
1. right part is ordered (A[mid] < A[ed])
2. right part is unordered (A[mid] > A[ed])
*/