/*
Permutations 

Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
*/
import arrayUtil.*;
import java.util.*;

public class Permutations1 {
    public List<List<Integer>> permute(int[] num){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(num.length == 0) return result;
        Integer[] numInt = new Integer[num.length];
        for(int i=0;i<num.length;i++) { numInt[i] = num[i]; }
        if(num.length == 1) {
            result.add(new ArrayList<Integer>(Arrays.asList(numInt)));
            return result;
        }
        int[] c = new int[num.length-1];
        for(int i=0;i<num.length;i++){
            System.arraycopy(num,0,c,0,i);
            System.arraycopy(num,i+1,c,i,c.length-i);
            for(List<Integer> j:permute(c)){
                j.addAll(new ArrayList<Integer>(Arrays.asList(numInt[i]))); result.add(j);
            }
        }
        return result;
    }
    
    public static void main(String args[]){
        int[] num = {1,2,3};
        List<List<Integer>> arr = (new Permutations1()).permute(num);
        ArrayListUtil.printListList(arr);
    }
}
