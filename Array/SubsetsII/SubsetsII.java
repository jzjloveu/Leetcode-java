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

public class SubsetsII {
     public List<List<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        getSubarr(num,0,result,new ArrayList<Integer>());
        return result;
    }

    private void getSubarr(int[] s, int index, List<List<Integer>> result, 
        List<Integer> subarr){
        if(index == s.length){
            result.add(new ArrayList<Integer>(subarr));
        }
        else{
            int i = index;
            while(i < s.length && s[i] == s[index]) { i++; }
            getSubarr(s,i,result,subarr); 
            subarr.add(s[index]);
            getSubarr(s,index+1,result,subarr);
            subarr.remove(subarr.size()-1);
        }
    }

    public static void main(String args[]){
        int[] s = {1,2,2}; 
        List<List<Integer>> arr = (new SubsetsII()).subsetsWithDup(s);
        ArrayListUtil.printListList(arr);
    }
}

/*
Same as Subsets problem, only diffferent is to remove the duplicate.
*/