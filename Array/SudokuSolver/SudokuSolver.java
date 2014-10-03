/*
Sudoku Solver

Write a program to solve a Sudoku puzzle by filling the empty cells.

Empty cells are indicated by the character '.'.

You may assume that there will be only one unique solution.
*/


public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        boolean[][] r = new boolean[9][9];  // appearance of 1-9 in row 1-9
        boolean[][] c = new boolean[9][9];  // appearance of 1-9 in col 1-9
        boolean[][][] g = new boolean[3][3][9];  // appearance of 1-9 in grid 1-9
        // init r, c, g
        for (int i = 0; i < 9; i++) {
          for (int j = 0; j < 9; j++) {
            if (board[i][j] != '.') {
              r[i][board[i][j]-'1'] = true;
              c[j][board[i][j]-'1'] = true;
              g[i/3][j/3][board[i][j]-'1'] = true;
            }
          }
        }
        sudokuDFS(board,0,0,r,c,g); // using dfs to check each possible number
	  }
    private boolean sudokuDFS(char[][] board, int i, int j,
        boolean[][] r, boolean[][] c, boolean[][][] g) {
        int k;
        for (int m = i; m < 9; m++) {
          for (int n = m==i?j:0; n < 9; n++) {
            if (board[m][n] == '.') {
              for (k = 0; k < 9; k++) {
                if (!r[m][k] && !c[n][k] && !g[m/3][n/3][k]) {
                  r[m][k] = c[n][k] = g[m/3][n/3][k] = true;
                  board[m][n] = (""+(k+1)).charAt(0);
                  if (sudokuDFS(board,m,n,r,c,g))
                    return true;
                  board[m][n] = '.';
                  r[m][k] = c[n][k] = g[m/3][n/3][k] = false;
                }
              }
              if (k == 9)  // no such number possible, dead
                return false;
            }
          }
        }
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
        (new SudokuSolver()).solveSudoku(board);
        for(char[] row:board){
          for(char i:row)
            System.out.print(i+" ");
          System.out.println();
        }
    }
}

/*
As the Sudoku has fixed size of board (9x9), the check procedure 
can be solved using just "for loop"
1. Check the rows and columns respectively, a mark array is used 
to check the numbers.
2. Check the 3x3 blocks, also using a mark array.
*/
