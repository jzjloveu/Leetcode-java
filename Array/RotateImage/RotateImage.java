/*
Rotate Image 

You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?
*/
import arrayUtil.*;
import java.util.*;

public class RotateImage  {
     public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i=0;i<n;i++)
            for(int j=0;j<n-1-i;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][n-1-i];
                matrix[n-1-j][n-1-i] = tmp;
            }
        for (int i=0;i<n/2;i++)
            for(int j=0;j<n;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-1-i][j] ;
                matrix[n-1-i][j] = tmp;
            }
    }

    public static void main(String args[]){
        int[][] A = {{1,2,3},{4,5,6},{7,8,9}};
        (new RotateImage()).rotate(A);
        ArrayListUtil.printMatrix(A);
    }
}

/*
In-place way is:
Swap elements by diagonal line(matrix[0][n-1] to matrix[n-1][0]),
then swap elements again by horizontal middile line (n+1)/2.
*/