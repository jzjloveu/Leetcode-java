/*
Surrounded Regions  

Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,
X X X X
X O O X
X X O X
X O X X

After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
*/
import java.util.*;

public class Solve2 {
   
    public void solve(char[][] board) {
        if(board==null || board.length==0){ return;}
        int rows = board.length, cols = board[0].length;
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[][] visited = new boolean[rows][cols];
        // base=min(rowss,colss); x=rows*base+cols; rows=x/base; cols=x%base
        int base = Math.max(rows,cols);
        for(int i=0;i<rows;i++){
            if(board[i][0] == 'O'){ queue.add(i*base);}
            if(board[i][cols-1] == 'O'){ queue.add(i*base+cols-1);}
        }
        for(int i=0;i<cols;i++){ 
            if(board[0][i] == 'O'){ queue.add(i);}
            if(board[rows-1][i] == 'O'){ queue.add((rows-1)*base+i);}
        }
        while(!queue.isEmpty()){
            int x = queue.poll();
            int r = x/base, c = x%base;
            board[r][c] = '$';
            visited[r][c] = true;
            if(r-1>=0 && board[r-1][c]=='O' && !visited[r-1][c])//up check
                queue.add((r-1)*base+c);
            if(r+1<rows && board[r+1][c]=='O' && !visited[r+1][c])//down check
                queue.add((r+1)*base+c);
            if(c-1>=0 && board[r][c-1]=='O' && !visited[r][c-1])//left check
                queue.add(r*base+c-1);
            if(c+1<cols && board[r][c+1]=='O' && !visited[r][c+1])//right check
                queue.add(r*base+c+1);
        }
        for(int i=0;i<rows;i++)
            for(int j=0;j<cols;j++){
                if(board[i][j] == 'O'){ board[i][j] = 'X';}
                if(board[i][j] == '$'){ board[i][j] = 'O';}
            }
    }

    private static void print2d(char[][] A){
        if(A==null || A.length==0){ return;}
        int rows = A.length, cols = A[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++)
                System.out.print(" "+A[i][j]);
            System.out.println();
        }
    }

    public static void main(String args[]){
        //char[][] A = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        //char[][] A = null;
        char[][] A = {{'X','O','X','O','X','O'},{'O','X','O','X','O','X'},{'X','O','X','O','X','O'},{'O','X','O','X','O','X'}};
        print2d(A);System.out.println();
        (new Solve2()).solve(A);
        print2d(A);
    }
}

/*
Search is a way to solve this problem!
If 'O' in the four sides of baord, they won't be surround by 'X'; so we can start from those 'O', and using BFS to get all the conjoint 'O', then repalce then to '$'. After that, just repalce all rest 'O' to 'X', then replace all '$' back to 'O'. 
*/
