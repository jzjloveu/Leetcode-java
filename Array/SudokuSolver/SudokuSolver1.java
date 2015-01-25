/*
Sudoku Solver

Write a program to solve a Sudoku puzzle by filling the empty cells.

Empty cells are indicated by the character '.'.

You may assume that there will be only one unique solution.
*/


public class SudokuSolver1 {
    public void solveSudoku(char[][] board) {
        solveRec(board, 0, 0);
    }

    private boolean solveRec(char[][] board, int row, int col){
        int nextRow = row, nextCol = col + 1;
        if(row == 9) return true;
        if(col == 8) { nextRow = row+1; nextCol = 0; }
        if(board[row][col] != '.') 
            return solveRec(board, nextRow, nextCol);
        for(char c='1';c<='9';c++)
            if(validate(board, row, col, c)) {
                board[row][col] = c;
                if(solveRec(board,nextRow,nextCol)) return true;
                board[row][col] = '.';
            }
        return false;
    }

    private boolean validate(char[][] board, int row, int col, char c) {
        for(int i=0;i<9;i++){
            if(board[row][i] == c) return false;
            if(board[i][col] == c) return false;
        }
        int cubeRow = (row/3)*3, cubeCol = (col/3)*3;
        for(int i=cubeRow;i<cubeRow+3;i++)
            for(int j=cubeCol;j<cubeCol+3;j++)
                if(board[i][j] == c) return false;
        return true;
    }

    public static void main(String args[]){
        char[][] board = {
             {'5','3','.','.','7','.','.','.','.'},
             {'6','.','.','1','9','5','.','.','.'},
             {'.','9','8','.','.','.','.','6','.'},
             {'8','.','.','.','6','.','.','.','3'},
             {'4','.','.','8','.','3','.','.','1'},
             {'7','.','.','.','2','.','.','.','6'},
             {'.','6','.','.','.','.','2','8','.'},
             {'.','.','.','4','1','9','.','.','5'},
             {'.','.','.','.','8','.','.','7','9'}};
        (new SudokuSolver1()).solveSudoku(board);
        for(char[] row:board){
            for(char i:row) System.out.print(i+" ");
            System.out.println();
        }
    }
}

/*
Using DFS. 
As the Sudoku has fixed size of board (9x9), the check procedure 
can be solved using just "for loop".
1. Check the rows and columns respectively, a mark array is used 
   to check the numbers.
2. Check the 3x3 blocks, also using a mark array.
*/
