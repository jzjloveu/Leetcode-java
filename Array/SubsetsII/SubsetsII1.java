/*
Subsets II  

Given a collection of integers that might contain duplicates, S, 
return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/
import arrayUtil.*;
import java.util.*;

public class SubsetsII1 {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> subarr = new ArrayList<Integer>();
        if(num.length == 0) { return result; }
        result.add(subarr);
        Arrays.sort(num);
        getSubarr(num,0,result,subarr);
        return result;
    }

    private void getSubarr(int[] s, int step, List<List<Integer>> result, 
        List<Integer> subarr){
        for(int i=step;i<s.length;i++){
            subarr.add(s[i]);
            result.add(new ArrayList<Integer>(subarr));
            getSubarr(s,i+1,result,subarr);
            subarr.remove(subarr.size()-1);
            while(i < s.length-1 && s[i] == s[i+1]) { i++; }
        }
    }

    public static void main(String args[]){
        int[] s = {1,2,2}; 
        List<List<Integer>> arr = (new SubsetsII1()).subsetsWithDup(s);
        ArrayListUtil.printListList(arr);
    }
}

/*
Same as Subsets problem, only diffferent is to remove the duplicate.
*/