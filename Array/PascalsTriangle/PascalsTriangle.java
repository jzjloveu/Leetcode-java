/*
Pascal's Triangle

Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

*/
import arrayUtil.*;
import java.util.*;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        List<Integer> arr = new ArrayList<Integer>();
        if(numRows == 0) { return triangle;}
        arr.add(1); triangle.add(arr);
        if(numRows == 1) { return triangle;}
        arr = new ArrayList<Integer>();
        arr.add(1); arr.add(1); triangle.add(arr);
        if(numRows == 2) { return triangle;}
        for (int i=2;i<numRows;i++){
            List<Integer> tmp = new ArrayList<Integer>();
            tmp.add(1);
            for (int j=1;j<i;j++){
            	tmp.add(triangle.get(i-1).get(j-1)+triangle.get(i-1).get(j));
            }
            tmp.add(1);
            triangle.add(tmp);
        }
        return triangle;
    }

    public static void main(String args[]){
        int numRows = 5;
        ArrayListUtil.printListList((new PascalsTriangle()).generate(numRows));
    }
}


