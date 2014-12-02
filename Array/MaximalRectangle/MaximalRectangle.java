/*
Maximal Rectangle 

Given a 2D binary matrix filled with 0's and 1's, find the largest 
rectangle containing all ones and return its area.
*/

import java.util.*;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        int maxArea=0, rlen=matrix.length, clen=matrix[0].length;
        int[][] m = new int[rlen+1][clen+1];
        for(int i=0;i<rlen;i++)
            for(int j=clen-1;j>=0;j--)
                m[i][j] = (matrix[i][j]=='1')? 1+m[i][j+1] : 0;

        for(int i=0;i<clen;i++){
            int p = 0; Stack<Integer> st = new Stack<Integer>();
            while(p < m.length){
                if(st.isEmpty() || m[p][i] >= m[st.peek()][i])
                    st.push(p++);
                else
                    maxArea = Math.max(maxArea,
                      m[st.pop()][i]*(st.isEmpty()?p:p-st.peek()-1));
          }
        }
        return maxArea;
    }
    
    public static void main(String args[]){
        char[][] matrix = {{'0','1','1','1','0','0','0','0'},
                           {'1','1','1','1','0','0','0','0'},
                           {'1','1','1','1','1','1','1','0'},
                           {'1','0','0','0','0','1','1','0'}};
        MaximalRectangle sol = new MaximalRectangle();
        System.out.println(sol.maximalRectangle(matrix));
    }
}

/*
An O(mn) solution idea:
Transform this problem to the 1-dimensional one, and then 
use O(n) algorithm to solve it by each column (total m). 
("Largest Rectangle in Histogram" problem)

Problem solving:
Suppose the matrix has m rows and n columns. The following will discuss an 
efficient algorithm which has time complexity O(mn). To begin with, 
we show some properties of all 1's largest rectangle.

Definition:
1. Bar: A bar is a line of matrix elements being all 1's. 
Bar could be horizontal or vertical according to its orientation.
2. Histogram: A histogram is one horizontal bar being the base concatenating with 
a number of vertical bars ('base' means that the bottoms of vertical bars are located 
on the horizontal bar). We call a histogram base-k histogram if its base horizontal 
bar is at k-th row. Moreover, if a histogram cannot be contained within any other 
histogram except itself, it is a "maximal histogram".
i.e.  maximal histograms in a matrix:
    _________ 
 0 | 1  1  1 | 0  0  0  0
 __|         |
|1 | 1  1  1 | 0  0  0  0
|  |         |________
|1 | 1  1  1   1 |1  1| 0
|__|_____________|____|
|1 | 0  0  0   0 |1  1| 0
|__|_____________|____|

Theorem 1: The largest rectangle is contained within a maximal histogram.

Theorem 2: For each k, any two base-k maximal histograms do not intersect.
*/