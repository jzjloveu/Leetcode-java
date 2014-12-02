/*
Largest Rectangle in Histogram  

Given n non-negative integers representing the histogram's bar 
height where the width of each bar is 1, find the area of largest 
rectangle in the histogram.
          6
       5  __
       __|  |
      |  |  |   3
 2    |  |  |2  __
 __ 1 |  |  |__|  |
|  |__|  |  |  |  |
|__|__|__|__|__|__|

Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
          6
       5  __
       __|__|
      |//|//|   3
 2    |//|//|2  __
 __ 1 |//|//|__|  |
|  |__|//|//|  |  |
|__|__|//|//|__|__|

The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example,
Given height = [2,1,5,6,2,3],
return 10.
*/

import java.util.*;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] height) {
        int i = 0, maxArea = 0;
        Stack<Integer> st = new Stack<Integer>();
        int[] h = new int[height.length+1];
        h = Arrays.copyOf(height, h.length);
        while(i < h.length){
            if(st.isEmpty() || h[st.peek()] <= h[i])
                st.push(i++);
            else
                maxArea = Math.max(maxArea,
                    h[st.pop()]*(st.isEmpty()?i:i-st.peek()-1));
        }
        return maxArea;
    }
    
    public static void main(String args[]){
        int[] A = {2,1,5,6,2,3};
        LargestRectangleInHistogram sol = new LargestRectangleInHistogram();
        System.out.println(sol.largestRectangleArea(A));
    }
}

/*
An O(n) solution idea:
For each bar, use a stack to store its index by ascending height. 
If meet the current index(i) bar height less than the top of stack index
bar height, then pop the stack to compute the area by height * width:
h[stack.pop()] * i - stack.top() - 1; and if stack is empty just:
h[stack.pop()] * i.
Notice that, we need add a dummy 0 to end of stack to make sure all height
can be pop.
*/