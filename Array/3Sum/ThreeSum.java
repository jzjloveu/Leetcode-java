/*
3Sum

Given an array S of n integers, are there elements a, b, c in S 
such that a + b + c = 0? Find all unique triplets in the array 
which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a <= b <= c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
*/
import arrayUtil.*;
import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        int num1,num2,num3,idx1,idx2,idx3;
        for(idx1=0;idx1<num.length;idx1++){
            num1 = num[idx1]; 
            //skip the same element
            if(idx1 >= 1 && num1 == num[idx1-1]) { continue; }
            idx2 = idx1+1; idx3 = num.length-1;
            while(idx2 < idx3){
                num2 = num[idx2]; num3 = num[idx3]; 
                if(num1+num2+num3 == 0){
                    result.add(new ArrayList<Integer>(
                        Arrays.asList(new Integer[]{num1,num2,num3})));
                    while(idx2++ < idx3--)
                        if(num2!=num[idx2] || num3!=num[idx3])
                            break;
                }
                else if(num1+num2+num3 > 0) //skip the same element
                    while(idx2 < idx3--) { if(num3!=num[idx3]){break;} }

                else //skip the same element
                    while(idx2++ < idx3) { if(num2!=num[idx2]){break;} }
            }
        }
        return result;
    }
    
    public static void main(String args[]){
        int[] num = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> arr = (new ThreeSum()).threeSum(num);
        ArrayListUtil.printListList(arr);
    }
}

/*
Two iterations:
1. 1st pointer from 1 to index end-2
2. while (2nd<3rd)

Conditions:
1. if (array[1st]+array[2nd]+array[3rd]==0), get one result
2. if (array[1st]+array[2nd]+array[3rd]>0), 3rd -1
3. if (array[1st]+array[2nd]+array[3rd]<0), 2nd +1

Notice for the same element, need to skip them.
*/