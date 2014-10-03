/*
Permutation Sequence 

The set [1,2,3,...,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.
*/
import java.util.*;

public class PermutationSequence  {
    public String getPermutation(int n, int k) {
        List<Integer> num = new ArrayList<Integer>(); 
        String result = ""; int fact = 1; k--; //count from 0
        for(int i=1;i<n;i++){fact*=i; num.add(i);}
        num.add(n);
        for(int i=n-1;i>=0;i--){
            Integer curr = num.get(k/fact); 
            result += "" + curr;
            num.remove(curr);
            if(i != 0){ k %= fact; fact /= i; }
        }
        return result;
    }
    
    public static void main(String args[]){
        int n = 3, k = 5;
        System.out.println(
            (new PermutationSequence()).getPermutation(n,k));
    }
}

/*
Let num = [1,2,3,...,n]. Since kth = d*(n-1)!, so the first digit is k/(n-1)!, 
then let k = k % (n-1)! and remove this digit from num. The second digit is k/(n-2)!, 
then let k = k % (n-2)! and remove this digit from num and so on.
*/