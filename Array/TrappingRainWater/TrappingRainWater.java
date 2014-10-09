/*
Trapping Rain Water 

Given n non-negative integers representing an elevation 
map where the width of each bar is 1, compute how much 
water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
*/
import java.util.*;

public class TrappingRainWater {
    public int trap(int[] A) {
        int vol = 0, n = A.length;
        if(n < 2) { return 0;}
        int[] l = new int[n], r = new int[n];
        for(int i=1;i<n;i++)
            l[i] = Math.max(l[i-1],A[i-1]);
        for(int i=n-2;i>=0;i--)
            r[i] = Math.max(r[i+1],A[i+1]);
        for(int i=0;i<n;i++)
            if(Math.min(l[i],r[i])-A[i] > 0)
                vol += Math.min(l[i],r[i]) - A[i];
        return vol;
    }
    
    public static void main(String args[]){
        int[] A = {0,1,0,2,1,0,1,3,2,1,2,1}; 
        System.out.println((new TrappingRainWater()).trap(A));
    }
}


/*
An O(n) solution idea:
For each bar, the water itself can trap depends on the 
max height on its left and right, that means for each 
coordinate need to check its left and right max value, 
then substract from it to get the volume.
Steps as follows:
1. Scan from left to right of array, for each coordinate, 
find the maximum left value.
2. Scan from right to left of array, for each coordinate,
find the maximum value.
3. Scan array again to accumulate the volume and get the result. 
*/