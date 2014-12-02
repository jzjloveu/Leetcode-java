/*
Gray Code 

The gray code is a binary numeral system where two successive 
values differ in only one bit.

Given a non-negative integer n representing the total number of 
bits in the code, print the sequence of gray code. A gray code 
sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2
Note:
For a given n, a gray code sequence is not uniquely defined.

For example, [0,2,3,1] is also a valid gray code sequence according to 
the above definition.

For now, the judge is able to judge based on one instance of gray code 
sequence. Sorry about that.
*/
import arrayUtil.*;
import java.util.*;

public class GrayCode  {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        int size = 1 << n; //it equals 2^n
        for (int i=0;i<size;i++) 
            result.add((i>>1)^i);    
        return result;
    }

    public static void main(String args[]){
        int n = 2;
        List<Integer> arr = (new GrayCode()).grayCode(n);
        ArrayListUtil.printList(arr);
    }
}

/*
The gray code and the binary to gray algorithm:
http://en.wikipedia.org/wiki/Gray_code
*/