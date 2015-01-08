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

public class FindPeakElement1{
	public int findPeakElement(int[] num) {
		int left = 0, right = num.length-1;
        while(left < right){
            int mid1 = (left + right) / 2;
            int mid2 = mid1 + 1;
            if(num[mid1] < num[mid2]) left = mid2;
            else right = mid1;
        }
        return left;
	}
   
	public static void main(String args[]) {
		int[] arr = {1,2}; // {1, 2, 3, 1};
    	System.out.println((new FindPeakElement1()).findPeakElement(arr));
	}
}

/*
Binary search.
*/
