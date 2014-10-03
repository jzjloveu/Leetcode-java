/*
Set Matrix Zeroes  

Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

click to show follow up.

Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
*/
import arrayUtil.*;
import java.util.*;

public class SetMatrixZeroes {
     public void setZeroes(int[][] matrix) {
        int rowLen = matrix.length; 
        int colLen = matrix[0].length;
        Set<Integer> rowSet = new TreeSet<Integer>();
        Set<Integer> colSet = new TreeSet<Integer>();
        for(int i=0;i<rowLen;i++)
            for(int j=0;j<colLen;j++){
                if(matrix[i][j] == 0){
                    rowSet.add(i); colSet.add(j);
                }
            }
        Iterator<Integer> rowit = rowSet.iterator();
        Iterator<Integer> colit = colSet.iterator();
        while(rowit.hasNext()){
            Integer i = rowit.next();
            for(int j=0;j<colLen;j++)
                matrix[i][j] = 0;
        }
        while(colit.hasNext()){
            Integer j = colit.next();
            for(int i=0;i<rowLen;i++)
                matrix[i][j] = 0;
        }
    }

    public static void main(String args[]){
        int[][] s = {{1,2,0,3},{1,3,4,5},{2,3,6,7},{1,3,4,5}};
        (new SetMatrixZeroes()).setZeroes(s);
        ArrayListUtil.printMatrix(s);
    }
}
