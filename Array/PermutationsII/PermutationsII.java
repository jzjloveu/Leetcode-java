/*
Permutations II  

Given a collection of numbers that might contain duplicates, 
return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].
*/
import arrayUtil.*;
import java.util.*;

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] num){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Integer[] numInt = new Integer[num.length];
        for(int i=0;i<num.length;i++) { numInt[i] = num[i]; }
        getPerm(numInt,0,numInt.length-1,result);
        return result;
    }

    private void getPerm(Integer[] num, int k, int end, List<List<Integer>> result){
        if(k == end)
            result.add(new ArrayList<Integer>(Arrays.asList(num)));
        else{
            for(int i=k;i<=end;i++){
                if(isDuplicate(num,k,i)) { continue; }
                int temp = num[k];
                num[k] = num[i];
                num[i] = temp;
                getPerm(num,k+1,end,result);
                temp = num[k];
                num[k] = num[i];
                num[i] = temp;
            }
        }
    }

    private boolean isDuplicate(Integer[] num, int k, int i){
        for(int j=k;j<i;j++)
            if(num[j] == num[i]) { return true; }
        return false;
    }
    
    public static void main(String args[]){
        int[] num = {-1,-1,3,-1}; // {1,1,2}; //
        List<List<Integer>> arr = (new PermutationsII()).permuteUnique(num);
        ArrayListUtil.printListList(arr);
    }
}

/*
The idea of permutation problem, except it need to remove
duplicate. 
*/