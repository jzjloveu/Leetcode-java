/*
Combination Sum II 

Given a collection of candidate numbers (C) and a target number (T), 
find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, ... , ak) must be in non-descending order. 
(ie, a1 <= a2 <= ... <= ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] 
*/
import arrayUtil.*;
import java.util.*;

public class CombinationSumII  {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        if(num.length == 0) return result;
        Arrays.sort(num);
        dfs(num,target,result,list,0);
        return result;
    }
    
    private void dfs(int[] num, int target, List<List<Integer>> result, 
            List<Integer> list, int start) {
        if(target < 0) { return; }
        else{
            if(target == 0) { result.add(new ArrayList<Integer>(list)); }
            else{
                int pre = -1;
                for (int i=start;i<num.length;i++)
                    if(num[i] != pre){
                        list.add(num[i]);
                        dfs(num,target-num[i],result,list,i+1);
                        pre = num[i];
                        list.remove(list.size()-1);
                    }
            }          
        }
    }
    
    public static void main(String args[]){
        int[] num = {10,1,2,7,6,1,5};
        int target = 8;
        ArrayListUtil.printListList(
            (new CombinationSumII()).combinationSum2(num,target));
    }
}

/*
Using DFS:
The only difference between this problem and the previous one is each element 
can be used at most once.
We can change the recursive step to handle this.
*/