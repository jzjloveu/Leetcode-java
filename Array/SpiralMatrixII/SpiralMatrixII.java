/*
Spiral Matrix II 

Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
*/
import arrayUtil.*;
import java.util.*;

public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        //if(n == 0) { return null; }
        int maxUp = 0,  maxLeft = 0;
        int maxDown = n - 1, maxRight = n - 1;
        int[][] matrix = new int[n][n];
        int curr = 0;
        int direct = 0; // 0 go right, 1 go down, 2 go left, 3 go up
        while(true){
            if(direct == 0) { // go right
                for(int i=maxLeft;i<=maxRight;i++)
                    matrix[maxUp][i] = ++curr;
                maxUp++;
            }
            else if(direct == 1) { // go down
                for(int i=maxUp;i<=maxDown;i++)
                    matrix[i][maxRight] = ++curr;
                maxRight--;
            }
            else if(direct == 2) { // go left
                for(int i=maxRight;i>=maxLeft;i--)
                    matrix[maxDown][i] = ++curr;
                maxDown--;
            }
            else { // go up
                for(int i=maxDown;i>=maxUp;i--) 
                    matrix[i][maxLeft] = ++curr;
                maxLeft++;
            }
             if(maxLeft > maxRight || maxUp > maxDown)
                 break;
            //if(curr >= n*n) { break; }
            direct = (direct + 1) % 4;
        }
        return matrix; 
    }

    public static void main(String args[]){
        int n = 3;
        ArrayListUtil.printMatrix((new SpiralMatrixII()).generateMatrix(n));
    }
}

/*
Same idea as Spiral Matrix.
*/
