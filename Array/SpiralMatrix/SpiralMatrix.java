/*
Spiral Matrix

Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
*/
import arrayUtil.*;
import java.util.*;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if(matrix.length == 0) { return result; }
        int maxUp = 0,  maxLeft = 0;
        int maxDown = matrix.length-1, maxRight = matrix[0].length-1;
        int direct = 0; // 0 go right, 1 go down, 2 go left, 3 go up
        while(true){
            if(direct == 0) { // go right
                for(int i=maxLeft;i<=maxRight;i++)
                    result.add(matrix[maxUp][i]);
                maxUp++;
            }
            else if(direct == 1) { // go down
                for(int i=maxUp;i<=maxDown;i++)
                    result.add(matrix[i][maxRight]);
                maxRight--;
            }
            else if(direct == 2) { // go left
                for(int i=maxRight;i>=maxLeft;i--)
                    result.add(matrix[maxDown][i]);
                maxDown--;
            }
            else { // go up
                 for(int i=maxDown;i>=maxUp;i--) {
                    result.add(matrix[i][maxLeft]);
                }
                maxLeft++;
            }
            if(maxLeft > maxRight || maxUp > maxDown)
                break;
            direct = (direct + 1) % 4;
        }
        return result; 
    }

    public static void main(String args[]){
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        ArrayListUtil.printList((new SpiralMatrix()).spiralOrder(matrix));
    }
}

/*
0,1,2,3 four values are used to indicates direction: 
maxUp, maxDown, maxLeft, maxRight four variables are 
used to record four boundaries. When maxUp > maxDown or 
maxLeft > maxRight program can return.
*/
;