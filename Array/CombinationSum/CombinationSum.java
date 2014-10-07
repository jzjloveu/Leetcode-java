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

public class CombinationSum  {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Map<Integer,List<List<Integer>>> dp = 
            new HashMap<Integer,List<List<Integer>>>();
        dp.put(0,new ArrayList<List<Integer>>()); 
        dp.get(0).add(new ArrayList<Integer>());
        for(int i=1;i<=target;i++){
            dp.put(i,new ArrayList<List<Integer>>()); 
            for(int num:candidates)
                // dp.containsKey(i-num) means it's not empty 
                if(i >= num)  // && dp.containsKey(i-num)){
                    for(List<Integer> L:dp.get(i-num)){ 
                        List<Integer> temp = new ArrayList<Integer>(L);
                        temp.add(num); Collections.sort(temp);  
                        if(!dp.get(i).contains(temp))
                            dp.get(i).add(temp); 
                    }
        }                          
        return dp.get(target); 
    }
    
    public static void main(String args[]){
        int[] candidates = {2,3,6,7};
        int target = 7;
        ArrayListUtil.printListList(
            (new CombinationSum()).combinationSum(candidates,target));
    }
}

/*
Using DP:
figure out solution set when target=1,2,3...N; the late outcome
result based on the previous.
*/