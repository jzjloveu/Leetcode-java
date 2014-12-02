/*
Find Minimum in Rotated Sorted Array II

Follow up for "Find Minimum in Rotated Sorted Array":
What if duplicates are allowed?
Would this affect the run-time complexity? How and why?

Suppose a sorted array is rotated at some pivot unknown 
to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array may contain duplicates.
*/

public class FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] num) {
        int res=num[0], start=0, end=num.length-1;
        while(start <= end){
            int mid = (start+end)/2;
            // skip the duplicates
            while(num[mid]==num[end] && mid!=end) 
                end--;
            while(num[start]==num[mid] && start!=mid) 
                start++;
            // right part ordered
            if(num[mid] < num[end] || mid == end){
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
        int[] arr = {4,5,6,6,7,7,0,1,2,2}; 
        FindMinimumInRotatedSortedArrayII sol = 
            new FindMinimumInRotatedSortedArrayII();
        System.out.println(sol.findMin(arr));
        
    }
}

/*
Using binary search.
Same as the "Find Minimum in Rotated Sorted Array",
only minute different is to need skip duplicates.
*/