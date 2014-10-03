/*
Valid Sudoku

Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled 
with the character '.'.

A partially filled sudoku which is valid.

Note:
A valid Sudoku board (partially filled) is not necessarily solvable. 
Only the filled cells need to be validated.
*/


public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        //check rows
        for(char[] row:board){
          String dup = "";
          for(char c:row){
            if(c != '.'){
              if(dup.indexOf(""+c) == -1) { dup += ""+c; }
              else { return false; }
            }
          }
        }
        //check columns
        for(int i=0;i<9;i++){
          String dup = "";
          for(int j=0;j<9;j++){
            char c = board[j][i];
            if(c != '.'){
              if(dup.indexOf(""+c) == -1) { dup += ""+c; }
              else { return false; }
            }
          }
        }
        // check 3x3 subboard
        for(int i=0;i<=6;i+=3)
            for(int j=0;j<=6;j+=3){
                String dup = "";
                for(int m=0;m<3;m++)
                    for(int n=0;n<3;n++){
                        char c  = board[i+m][j+n];
                        if(c != '.'){
                          if(dup.indexOf(""+c) == -1) { dup += ""+c; }
                          else { return false; }
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
        for(char[] row:board){
          for(char i:row)
            System.out.print(i+" ");
          System.out.println();
        }
        System.out.println((new ValidSudoku()).isValidSudoku(board));
    }
}

/*
As the Sudoku has fixed size of board (9x9), the check procedure 
can be solved using just "for loop"
1. Check the rows and columns respectively, a mark array is used 
to check the numbers.
2. Check the 3x3 blocks, also using a mark array.
*/
