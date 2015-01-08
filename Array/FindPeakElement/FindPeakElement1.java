/* 
Find Peak Element 

A peak element is an element that is greater than its neighbors.

Given an input array where num[i] =/= num[i+1], find a peak element 
and return its index.

The array may contain multiple peaks, in that case return the index 
to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -inf.

For example, in array [1, 2, 3, 1], 3 is a peak element and your 
function should return the index number 2.

Note:
Your solution should be in logarithmic complexity.
*/

public class FindPeakElement{
	public int findPeakElement(int[] num) {
		int left = 0, right = num.length-1;
        while(left <= right){
            int mid = (left + right) / 2;
            if((mid==0 || num[mid]>num[mid-1]) && 
                (mid==num.length-1 || num[mid]>num[mid+1]))
                return mid;
            if(mid > 0 && num[mid] < num[mid-1])
                right = mid - 1;
            else left = mid + 1;
        }
        return 0;
	}
   
	public static void main(String args[]) {
		int[] arr = {1,2}; // {1, 2, 3, 1};
    	System.out.println((new FindPeakElement()).findPeakElement(arr));
	}
}

/*
Binary search.
If mid small than its left neighbor, which means the peak in the left,
otherwise in the right. And be careful for the peak in the both end side.
*/
