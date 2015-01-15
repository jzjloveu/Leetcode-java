/*
Maximum Gap

Given an unsorted array, find the maximum difference between the successive 
elements in its sorted form.

Try to solve it in linear time/space.

Return 0 if the array contains less than 2 elements.

You may assume all elements in the array are non-negative integers and fit 
in the 32-bit signed integer range.
*/

import java.util.*;

public class MaximumGap {
    public int maximumGap(int[] num) {
        if(num.length < 2) return 0;
        int max=Integer.MIN_VALUE, min=Integer.MAX_VALUE;
        for(int i:num){ max=Math.max(max,i); min=Math.min(min,i); }
        int gap = (int)(Math.ceil((double)(max-min)/(num.length-1)));
        int bucketNum = (int)(Math.ceil((double)(max-min)/gap));
        int[] bucketMin=new int[bucketNum], bucketMax = new int[bucketNum];
        Arrays.fill(bucketMin,Integer.MAX_VALUE);
        Arrays.fill(bucketMax,Integer.MIN_VALUE);
        for(int i=0;i<num.length;i++){
            if(num[i]==max || num[i]==min) continue;
            int idx = (num[i] - min) / gap;
            bucketMin[idx] = Math.min(bucketMin[idx],num[i]);
            bucketMax[idx] = Math.max(bucketMax[idx],num[i]);
        }
        int prev = min, ans=Integer.MIN_VALUE;
        for(int i=0;i<bucketNum;i++){
            if(bucketMin[i]==Integer.MAX_VALUE || bucketMax[i]==Integer.MIN_VALUE)
                continue;
            ans = Math.max(ans, bucketMin[i]-prev);
            prev = bucketMax[i];
        }
        ans = Math.max(ans, max-prev);
        return ans; 
    }
    
    public static void main(String args[]){
        int[] num = {1, 0, 1, 2, 1, 4};
        System.out.println((new MaximumGap()).maximumGap(num));
    }
}

/*
Suppose there are N elements and they range from A to B.

Then the maximum gap will be no smaller than ceiling[(B - A) / (N - 1)]

Let the length of a bucket to be len = ceiling[(B - A) / (N - 1)], then 
we will have at most num = (B - A) / len + 1 of bucket

for any number K in the array, we can easily find out which bucket it belongs 
by calculating loc = (K - A) / len and therefore maintain the maximum and minimum 
elements in each bucket.

Since the maximum difference between elements in the same buckets will be at most len - 1, 
so the final answer will not be taken from two elements in the same buckets.

For each non-empty buckets p, find the next non-empty buckets q, then q.min - p.max 
could be the potential answer to the question. Return the maximum of all those values.
*/