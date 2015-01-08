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

public class UniquePaths2 {
    public long uniquePaths(int m, int n) {
        long[] maxv = new long[n];
        maxv[0] = 1l;
        for(int i=0;i<m;i++)
            for(int j=1;j<n;j++)
                maxv[j] = maxv[j-1] + maxv[j];
        return maxv[n-1];
    }
    
    public static void main(String args[]){
        //int m = 7, n = 3;
        int m = 51, n = 9; // 1916797311
        System.out.println(
            (new UniquePaths2()).uniquePaths(m,n));
    }
}

/*
One dimension DP: Step[i][j] = Step[i-1][j] + Step[i][j-1].
*/