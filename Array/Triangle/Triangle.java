/*
Triangle

Given a triangle, find the minimum path sum from top to bottom. 
Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, 
where n is the total number of rows in the triangle.
*/
import java.util.*;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        for(int i=triangle.size()-2;i>=0;i--)
            for(int j=0;j<=i;j++){
                int minval = triangle.get(i).get(j) + 
                    Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1));
                triangle.get(i).set(j,minval);
            }
        return triangle.get(0).get(0);
    }

    public static void main(String args[]){
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        List<Integer> row = new ArrayList<Integer>();
        row.add(2); triangle.add(row);
        row = new ArrayList<Integer>();
        row.add(3); row.add(4); triangle.add(row);
        row = new ArrayList<Integer>();
        row.add(6); row.add(5); row.add(7);triangle.add(row);
        row = new ArrayList<Integer>();
        row.add(4);row.add(1);row.add(8);row.add(3);triangle.add(row);
        System.out.println((new Triangle()).minimumTotal(triangle));
    }
}

/*
Bottom up dp.
*/
