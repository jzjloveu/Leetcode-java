/*
Pascal's Triangle II

Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
*/
import arrayUtil.*;
import java.util.*;

public class PascalsTriangleII {
    public List<Long> getRow(int rowIndex) {
        List<Long> triangle = new ArrayList<Long>();
        triangle.add(1L);
        int n = (rowIndex)/2;
        for (int i=1;i<=n;i++){
            Long tmp = triangle.get(i-1) * (rowIndex+1-i)/i;
            triangle.add(tmp);
        }
        int len = triangle.size();
        if (rowIndex%2==1){ 
            for (int i=len-1;i>=0;i--)
                triangle.add(triangle.get(i));
        }else{
            for (int i=len-2;i>=0;i--)
                triangle.add(triangle.get(i));
        }
        return triangle;
    }

    public static void main(String args[]){
        int rowIndex = 11;
        ArrayListUtil.printList((new PascalsTriangleII()).getRow(rowIndex));
    }
}

/*
This can be solved in according to the formula to generate 
the kth element in nth row of Pascal's Triangle:

r(k) = r(k-1) * (n+1-k)/k,

where r(k) is the kth element of nth row. The formula just 
use the previous element to get the new one. The start point is 1.
Once get the formula, it is easy to generate the nth row.
*/