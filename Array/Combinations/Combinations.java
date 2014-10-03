/*
Combinations  

Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/
import arrayUtil.*;
import java.util.*;

public class Combinations {
     public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(k == 0) { return result; }
        Integer[] comb = new Integer[k];
        Arrays.fill(comb,0);
        int p = 0;
        while(p >= 0){
          comb[p] += 1;
          for(int i=p+1;i<k;i++){
            comb[i] = comb[i-1] + 1;
          }
          result.add(new ArrayList<Integer>(Arrays.asList(comb)));
          p = k - 1;
          while(p >= 0 && comb[p] == n-(k-1-p)){ p--; }
        }
        return result;
    }

    public static void main(String args[]){
        List<List<Integer>> arr = (new Combinations()).combine(4,3);
        ArrayListUtil.printListList(arr);
    }
}

/*
counting p, when p reach the maximum number k, then moving p forward.
For example, combine(5,3), when get [1,2,5], p point to poistion 3rd and 
it reach maximum number 5, then p move to position 2nd, comb[p] += 1,
so we get [1,3,4]. And when p in position 1st reach the maximum k, such as
[3,4,5], then program end.
*/