/*
N-Queens 

The n-queens puzzle is the problem of placing n queens on an nXn chessboard such 
that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, 
where 'Q' and '.' both indicate a queen and an empty space resultpectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
*/
import java.util.*;

public class NQueens1 {
    private static List<String[]> result;

    public List<String[]> solveNQueens(int n) {
        int[] board = new int[n];
        result = new ArrayList<String[]>();
        solveQ(n, 0, board);
        return result;
    }

    private static void solveQ(int n, int currQueenNum, int[] board){
        if(currQueenNum == n){
            String[] solu = new String[n];
            char[][] soluboard = new char[n][n];
            for(char[] s:soluboard) { Arrays.fill(s, '.'); }
            for(int i=0;i<currQueenNum;i++) { soluboard[i][board[i]] = 'Q'; }
            for(int i=0;i<n;i++) { solu[i] = new String(soluboard[i]); }
            result.add(solu); return;
        }
        // try to put a Queen in (currQueenNum, 0), (currQueenNum, 1), ..., (currQueenNum, n-1)
        for(int i=0;i<n;i++){
            boolean valid = true;
            // test whether board[currQueenNum] can be i or not
            for(int j=0;j<currQueenNum;j++){
                // check column
                if(board[j] == i) { valid = false; break; }
                // check dianogal
                if(Math.abs(board[j]-i) == currQueenNum-j) { valid = false; break; }
            }
            if(valid){
                board[currQueenNum] = i;
                solveQ(n, currQueenNum + 1, board);
            }
        }
    }

    private static void printbaord(List<String[]> borad){
        System.out.print("[");
        for(int i=0;i<borad.size();i++) {
            System.out.print("[");
            for(int j=0;j<borad.get(i).length;j++)
                System.out.println(borad.get(i)[j]); 
            System.out.println("]");
        }
        System.out.print("]\n");
    }

    public static void main(String args[]){
        int n = 4; //2; //
        List<String[]> resultultboard = (new NQueens1()).solveNQueens(n);
        printbaord(resultultboard);
    }
}

/*
The classic recursive problem.
1. Use a int vector to store the current state,  A[i]=j refers that 
the ith row and jth column is placed a queen.
2. Valid state:  not in the same column, which is A[i]!=A[current], 
not in the same diagonal direction: abs(A[i]-A[current]) != r-i

3. Recursion: 
       Start: placeQueen(0,n)
        if current ==n then print resultult
        else
            for each place less than n,
                place queen
                if current state is valid, then place next queen place Queen(cur+1,n)
           end for
        end if
*/