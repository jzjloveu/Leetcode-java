/*
Combination Sum 

Given a set of candidate numbers (C) and a target number (T), find all 
unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2,..., ak) must be in non-descending order.
(ie, a1 <= a2 <= ... <= ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7]
[2, 2, 3]
*/
import arrayUtil.*;
import java.util.*;

public class CombinationSum1  {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        if(candidates.length == 0) return result;
        Arrays.sort(candidates);
        dfs(candidates,target,result,list,0);
        return result;
    }
    
    private void dfs(int[] candidates, int target, List<List<Integer>> result, 
            List<Integer> list, int i) {
        if(target < 0) { return; }
        else{
            if(target == 0) { result.add(new ArrayList<Integer>(list)); }
            else{
                while(i<candidates.length && target-candidates[i]>=0){
                    list.add(candidates[i]);
                    dfs(candidates,target-candidates[i],result,list,i);
                    i++;
                    list.remove(list.size()-1);
                }
            }
                  
        }
    }
    
    public static void main(String args[]){
        int[] candidates = {2,3,6,7};
        int target = 7;
        ArrayListUtil.printListList(
            (new CombinationSum1()).combinationSum(candidates,target));
    }
}

/*
Using DFS:
The idea is to scan from the first to the last element from the ordered array. 
check every possible combination of these numbers(multiple times for a single element).
The end condition of the dfs function is
1. the target ==0 , print list, return
2. the target < 0 return
3. start position >= array size return
otherwise, from for each element in the array, dfs(start, target-element value);
*/