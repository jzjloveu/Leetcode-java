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

public class Combinations1 {
    List<List<Integer>> result;
    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<List<Integer>>();
        if((k < 1) || (n < 1) || (k > n)){ return result; }
        int[] alist = new int[n];
        List<Integer> tmplist = new ArrayList<Integer>();
        for (int i=0;i<n;i++){ alist[i] = i+1; }
        dfs(alist,0,k,tmplist);
        return result;
    }

    private void dfs(int[] alist, int step, int end, List<Integer> tmplist){
        if(tmplist.size() == end){
            result.add(new ArrayList<Integer>(tmplist));
            return;
        }
        for(int i=step;i<alist.length;i++){
            tmplist.add(alist[i]);
            dfs(alist,i+1,end,tmplist);
            tmplist.remove(tmplist.size()-1);
        }
    }
    
    public static void main(String args[]){
        List<List<Integer>> arr = (new Combinations1()).combine(4,3);
        ArrayListUtil.printListList(arr);
    }
}

/*
Depth first search.
*/