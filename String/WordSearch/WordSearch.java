/*
Word Search 

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, 
where "adjacent" cells are those horizontally or vertically neighboring. 
The same letter cell may not be used more than once.

For example,
Given board =
[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/


public class WordSearch {
    public boolean exist(char[][] board, String word)  {
        for(int i=0;i<board.length;i++)
          for(int j=0;j<board[0].length;j++)
            if(board[i][j] == word.charAt(0))
              if(dfs(board,i,j,word.substring(1))) return true;
        return false;
	  }

	  private static boolean dfs(char[][] board, int row, int col, String word){
        if(word.length() == 0) { return true;}
        // Go up
        if(row > 0 && board[row-1][col] == word.charAt(0)){
          char tmp = board[row][col];
          board[row][col] = '#';
          if(dfs(board,row-1,col,word.substring(1))) { return true;}
          board[row][col] = tmp;
        }
        // Go down
        if(row < board.length-1 && board[row+1][col] == word.charAt(0)){
          char tmp = board[row][col];
          board[row][col] = '#';
          if(dfs(board,row+1,col,word.substring(1))) { return true;}
          board[row][col] = tmp;
        }
        // Go left
        if(col > 0 && board[row][col-1] == word.charAt(0)){
          char tmp = board[row][col];
          board[row][col] = '#';
          if(dfs(board,row,col-1,word.substring(1))) { return true;}
          board[row][col] = tmp;
        }
        // Go right
        if(col < board[0].length-1 && board[row][col+1] == word.charAt(0)){
          char tmp = board[row][col];
          board[row][col] = '#';
          if(dfs(board,row,col+1,word.substring(1))) { return true;}
          board[row][col] = tmp;
        }
        return false;
    }

    public static void main(String args[]){
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "SEE";
        System.out.println((new WordSearch()).exist(board,word));
    }
}

/*
Use DFS. Don't make a new board or other large 
variables to record state, or it's easy to TLE.
*/
