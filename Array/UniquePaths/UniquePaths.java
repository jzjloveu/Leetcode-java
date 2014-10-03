/*
Unique Paths 

A robot is located at the top-left corner of a m x n grid (marked 'Start' 
in the diagram below).

The robot can only move either down or right at any point in time. 
The robot is trying to reach the bottom-right corner of the grid 
(marked 'Finish' in the diagram below).

How many possible unique paths are there?
*/
import java.util.*;

public class UniquePaths {
    public long uniquePaths(int m, int n) {
        long[][] board = new long[m][n];
        board[0][0] = 1l;
        for(int i=1;i<m;i++) { board[i][0] = board[i-1][0]; }
        for(int j=1;j<n;j++) { board[0][j] = board[0][j-1]; }
        for (int i=1;i<m;i++)
            for(int j=1;j<n;j++)
                board[i][j] = board[i][j-1] + board[i-1][j];
        return board[m-1][n-1];
    }
    
    public static void main(String args[]){
        int m = 7, n = 3;
        //int m = 51, n = 9; // 1916797311
        System.out.println((new UniquePaths()).uniquePaths(m,n));
    }
}

/*
This is an easy problem. From the description we know that, 
the robot can only move down or right, which means, if the 
robot is now in position (x,y), then the position before this 
step must be  either (x-1,y) or (x, y-1). Since current position 
is only from these two previous positions, the number of possible
paths that the robot can reach this current position (x,y) is the 
sum of paths from (x-1, y) and (x, y-1).
We want to get the number of paths on position (m,n), we need to 
know (m-1,n) and (m, n-1). For (m-1,n), we must know (m-2,n) and 
(m-1,n-1) ...  until we back to the start position (1,1) ([0][0] in  C++). 
Note that the boundary of the map, we can easily know that the top row 
and the first column of the map are all 1s. Use loop can solve the problem then.
*/