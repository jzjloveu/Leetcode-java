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

public class UniquePaths1 {
    public long uniquePaths(int m, int n) {
        int N = m - 1 + n - 1;
        int K = Math.min(m, n) - 1;
        long result = 1l;
        for(int i=0;i<K;i++){ result = result*(N-i)/(i+1);}
        return result;
    }
    
    public static void main(String args[]){
        //int m = 7, n = 3;
        int m = 51, n = 9; // 1916797311
        System.out.println(
            (new UniquePaths1()).uniquePaths(m,n));
    }
}
