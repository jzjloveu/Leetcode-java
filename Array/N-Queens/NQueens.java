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

public class NQueens {
    public List<String[]> solveNQueens(int n) {
        List<String[]> result = new ArrayList<String[]>();
        solveQ(n,0,new int[n], result);
        return result;
    }
    private void solveQ(int n, int row, int[] columnForRow, List<String[]> result){
        if(row == n){
            String[] item = new String[n];
            for(int i=0;i<n;i++){
                StringBuilder strRow = new StringBuilder();
                for(int j=0;j<n;j++){
                    if(columnForRow[i]==j)
                        strRow.append('Q');
                    else
                        strRow.append('.');
                }
                item[i] = strRow.toString();
            }
            result.add(item);
            return;
        }
        for(int i=0;i<n;i++){
            columnForRow[row] = i;
            if(check(row,columnForRow))
                solveQ(n,row+1,columnForRow,result);
        }
    }
    private boolean check(int row, int[] columnForRow){
        for(int i=0;i<row;i++)
            if(columnForRow[row]==columnForRow[i] || Math.abs(columnForRow[row]-columnForRow[i])==row-i)
                return false;
        return true;
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
        int n = 4; //2;
        List<String[]> resultultboard = (new NQueens()).solveNQueens(n);
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