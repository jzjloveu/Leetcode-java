/*
Search a 2D Matrix

Write an efficient algorithm that searches for a value in an m x n matrix. 
This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
*/
import java.util.*;

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowSize = matrix.length, colSize = matrix[0].length;
        int leftI = 0, leftJ = 0;
        int rightI = rowSize-1, rightJ = colSize-1;
        while(leftI*colSize+leftJ <= rightI*colSize+rightJ){
            int mid = (leftI*colSize+leftJ + rightI*colSize+rightJ) / 2;
            int midI = mid / colSize;
            int midJ = mid % colSize;
            if(matrix[midI][midJ] == target) { return true; }
            else if(matrix[midI][midJ] < target){
                leftI = (mid+1) / colSize;
                leftJ = (mid+1) % colSize;
            }
            else{
                rightI = (mid-1) / colSize;
                rightJ = (mid-1) % colSize;
            }
        }
        return false;
    }
    
    public static void main(String args[]){
        int[][] A = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        int target = 11;
        System.out.println((new SearchA2DMatrix()).searchMatrix(A,target));
    }
}

/*
Binary search, just convert 2D coordinate to linear coordinate.
*/