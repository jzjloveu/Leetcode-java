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

public class SurroundedRegions {
   
    public void solve(char[][] board) {
        if(board==null || board.length==0){ return;}
        int row = board.length, col = board[0].length;
        Queue<List<Integer>> queue = new LinkedList<List<Integer>>();
        boolean[][] visited = new boolean[row][col];
        for(int i=0;i<row;i++){
            if(board[i][0] == 'O'){ queue.add(Arrays.asList(i,0));}
            if(board[i][col-1] == 'O'){ queue.add(Arrays.asList(i,col-1));}
        }
        for(int i=0;i<col;i++){
            if(board[0][i] == 'O'){ queue.add(Arrays.asList(0,i));}
            if(board[row-1][i] == 'O'){ queue.add(Arrays.asList(row-1,i));}
        }
        while(!queue.isEmpty()){
            List<Integer> idO = queue.poll();
            int r = idO.get(0), c = idO.get(1);
            board[r][c] = '$';
            visited[r][c] = true;
            if(r-1>=0 && board[r-1][c]=='O' && !visited[r-1][c])//up check
                queue.add(Arrays.asList(r-1,c));
            if(r+1<row && board[r+1][c]=='O' && !visited[r+1][c])//down check
                queue.add(Arrays.asList(r+1,c));
            if(c-1>=0 && board[r][c-1]=='O' && !visited[r][c-1])//left check
                queue.add(Arrays.asList(r,c-1));
            if(c+1<col && board[r][c+1]=='O' && !visited[r][c+1])//right check
                queue.add(Arrays.asList(r,c+1));
        }
        for(int i=0;i<row;i++)
            for(int j=0;j<col;j++){
                if(board[i][j] == 'O'){ board[i][j] = 'X';}
                if(board[i][j] == '$'){ board[i][j] = 'O';}
            }
    }

    private static void print2d(char[][] A){
        if(A==null || A.length==0){ return;}
        int row = A.length, col = A[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++)
                System.out.print(" "+A[i][j]);
            System.out.println();
        }
    }

    public static void main(String args[]){
        //char[][] A = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        //char[][] A = null;
        char[][] A = {{'X','O','X','O','X','O'},{'O','X','O','X','O','X'},{'X','O','X','O','X','O'},{'O','X','O','X','O','X'}};
        print2d(A);System.out.println();
        (new SurroundedRegions()).solve(A);
        print2d(A);
    }
}

/*
Search is a way to solve this problem!
If 'O' in the four sides of baord, they won't be surround by 'X'; so we can start from those 'O', 
and using BFS to get all the conjoint 'O', then repalce then to '$'. After that, just repalce all 
rest 'O' to 'X', then replace all '$' back to 'O'. 
*/
