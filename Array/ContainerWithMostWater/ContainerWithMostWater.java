/*
Container With Most Water 

Given n non-negative integers a1, a2, ..., an, where each represents 
a point at coordinate (i, ai). n vertical lines are drawn such that 
the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, 
which together with x-axis forms a container, such that the container 
contains the most water.

Note: You may not slant the container.
*/
import java.util.*;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1, maxWater = -1;
        while(l < r){
          maxWater = Math.max(maxWater, Math.min(height[l],height[r])*(r-l));
          if(height[l] < height[r]) { l++; }
          else { r--; }
        }
        return maxWater; 
    }

    public static void main(String args[]){
        int[] height = {1,5,3,7};
        System.out.println((new ContainerWithMostWater()).maxArea(height));
    }
}

/*
There is a greedy way to solve this problem in O(n). Use two pointers, 
one from the start and one from the end of the height vector. 
Compute the current area, move the smaller pointer to its direction, 
until two pointers meet.
*/