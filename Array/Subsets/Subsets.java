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

public class Subsets {
     public List<List<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        getSubarr(S,0,result,new ArrayList<Integer>());
        return result;
    }

    private void getSubarr(int[] s, int index, List<List<Integer>> result, 
        List<Integer> subarr){
        if(index == s.length){
            result.add(new ArrayList<Integer>(subarr));
        }
        else{ 
            getSubarr(s,index+1,result,subarr); 
            subarr.add(s[index]);
            getSubarr(s,index+1,result,subarr);
            subarr.remove(subarr.size()-1);
        }
    }

    public static void main(String args[]){
        int[] s = {1,2,3}; 
        List<List<Integer>> arr = (new Subsets()).subsets(s);
        ArrayListUtil.printListList(arr);
    }
}

/*
Use DFS.
*/