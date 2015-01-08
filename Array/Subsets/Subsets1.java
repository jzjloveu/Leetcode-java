/*
Subsets 

Given a set of distinct integers, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,3], a solution is:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/
import arrayUtil.*;
import java.util.*;

public class Subsets1 {
    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> subarr = new ArrayList<Integer>();
        if(S.length == 0) { return result; }
        result.add(subarr);
        Arrays.sort(S);
        getSubarr(S,0,result,subarr);
        return result;
    }

    private void getSubarr(int[] s, int step, List<List<Integer>> result, 
        List<Integer> subarr){
        for(int i=step;i<s.length;i++){
            subarr.add(s[i]);
            result.add(new ArrayList<Integer>(subarr));
            //if(i < s.length-1) { getSubarr(s,i+1,result,subarr); }
            getSubarr(s,i+1,result,subarr);
            subarr.remove(subarr.size()-1);
        }
    }

    public static void main(String args[]){
        int[] s = {1,2,3}; 
        List<List<Integer>> arr = (new Subsets1()).subsets(s);
        ArrayListUtil.printListList(arr);
    }
}

/*
Use DFS.
*/