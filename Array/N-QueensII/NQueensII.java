/*
N-Queens 

N-Queens II 

Follow up for N-Queens problem.

Now, instead outputting board configurations, return the total number of distinct solutions.
*/
import java.util.*;

public class NQueensII {
    private static int result;

    public int totalNQueens(int n) {
        result = 0;
        solveQ(n, 0, new int[n]);
        return result;
    }

    private static void solveQ(int n, int currQueenNum, int[] board){
        if(currQueenNum == n){  result++; return; }
        // try to put a Queen in (currQueenNum, 0), (currQueenNum, 1), ..., (currQueenNum, n-1)
        for(int i=0;i<n;i++){
            boolean valid = true;
            // test whether board[currQueenNum] can be i or not
            for(int j=0;j<currQueenNum;j++)
                if(board[j] == i || Math.abs(board[j]-i) == currQueenNum-j) { valid = false; break; }
            if(valid){
                board[currQueenNum] = i;
                solveQ(n, currQueenNum + 1, board);
            }
        }
    }

    public static void main(String args[]){
        int n = 4; //2; //
        System.out.println((new NQueensII()).totalNQueens(n));
    }
}

/*
This problem is the same idea as the N-Queens.
*/