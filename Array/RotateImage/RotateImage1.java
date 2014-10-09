/*
Rotate Image 

You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?
*/
import arrayUtil.*;
import java.util.*;

public class RotateImage1 {
     public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int layer=0; layer<n/2; layer++){
            int first = layer;
            int last  = n-1-layer; 
            for (int i=first;i<last;i++){
                int offset = i-first;
                int top = matrix[first][i];
                // left to top            
                matrix[first][i] = matrix[last-offset][first];
                // bottom to top
                matrix[last-offset][first] = matrix[last][last-offset];
                //right to bottom
                matrix[last][last-offset] = matrix[i][last];
                //top to right
                matrix[i][last] = top;
            }
        }
    }

    public static void main(String args[]){
        int[][] A = {{1,2,3},{4,5,6},{7,8,9}};
        (new RotateImage1()).rotate(A);
        ArrayListUtil.printMatrix(A);
    }
}

/*
The idea is to rotate the matrix according to layers. 
For the nth layer(the out layer), rotate 90 degree is 
to move all the elements n times in a circle. In each layer, 
the rotation can be performed by first swap 4 corners, 
then swap 4 elements next to corner until the end of each line.
*/