/*
Maximum Subarray 

Find the contiguous subarray within an array (containing at least one number) 
which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.

click to show more practice.

More practice:
If you have figured out the O(n) solution, try coding another solution using 
the divide and conquer approach, which is more subtle.
*/
import java.util.*;

public class MaximumSubarray {
   public int maxSubArray(int[] A) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<A.length;i++){
            sum = (sum > 0)?sum + A[i]:A[i];
            max = Math.max(sum, max);
        }
        return max;
    }

    public static void main(String args[]){
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println((new MaximumSubarray()).maxSubArray(arr));
    }
}

/*
Analysis:
Classic DP problem.

We can think this problem as this: if the previous sum are +, 
which is then useful for the current element, or if it is -, 
why not start the sub array from current element? We can use 
an int to store the max sum we have got, just scan the whole array, 
the result is easily found.
*/
