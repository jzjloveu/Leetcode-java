/*
3Sum

Given an array S of n integers, are there elements a, b, c in S 
such that a + b + c = 0? Find all unique triplets in the array 
which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a <= b <= c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
*/
import java.util.*;

public class MinimumPathSum1 {
    public int minPathSum(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        if(rows == 0 || cols == 0) { return 0; }
        int[] step = new int[cols]; 
        Arrays.fill(step, Integer.MAX_VALUE); step[0] = 0;
        // dp process
        for(int i=0;i<rows;i++){
            step[0] = step[0] + grid[i][0];
            for(int j=1;j<cols;j++)
                step[j]=Math.min(step[j],step[j-1])+grid[i][j];
        }
        return step[cols-1];
    }
    
    public static void main(String args[]){
        int[][] grid = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println((new MinimumPathSum1()).minPathSum(grid));
    }
}

/*
This version is no need extra two-d array.
Using DP. For example:
[]    []       []      []
[]    []       [i-1,j] []
[]    [i,j-1]  [i,j]   [] 
[]    []       []      []
Formula:
Init: A[0][i] = A[0][i-1]+grid[0][i]
      A[i][0] = A[i-1][0]+grid[i][0]
State Change func:
      A[i][j] = min(A[i-1][j],A[i][j-1])+grid[i][j])
*/