/*
Unique Paths II 

Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Note: m and n will be at most 100.
*/
import java.util.*;

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1) { return 0; }
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];
        // base case
        for(int i=0;i<row;i++){
            if(obstacleGrid[i][0] == 0) { dp[i][0] = 1; }
            else{ break; }
        }
        for(int j=0;j<col;j++){
            if(obstacleGrid[0][j] == 0) { dp[0][j] = 1; }
            else{ break; }
        }
        // dp process
        for(int i=1;i<row;i++)
            for(int j=1;j<col;j++)
                dp[i][j] = (obstacleGrid[i][j]==1)? 0:dp[i-1][j]+dp[i][j-1];
        return dp[row-1][col-1];
    }
    
    public static void main(String args[]){
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(
            (new UniquePathsII()).uniquePathsWithObstacles(obstacleGrid));
    }
}
