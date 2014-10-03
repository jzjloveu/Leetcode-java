/*
3Sum Closest                                                                                                                       

Given an array S of n integers, find three integers in S such 
that the sum is closest to a given number, target. Return the 
sum of the three integers. You may assume that each input would 
have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/
import java.util.*;

public class ThreeSumClosest {
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int minVal = Integer.MAX_VALUE, result = 0;
        for(int i=0;i<num.length;i++){
            int start = i+1, end = num.length-1;
            while(start < end){
                int sum = num[i]+num[start]+num[end]; 
                if(sum == target){
                    minVal = 0; result = sum;
                    break;
                }
                if(sum < target){
                    if(target - sum < minVal){
                        minVal = target - sum;
                        result = sum;
                    }
                    start++;
                }
                else{
                    if(sum - target < minVal){
                        minVal = sum - target;
                        result = sum;
                    }
                    end--;
                }
            }
            //skip the same element
            while(i < num.length-1 && num[i] == num[i+1]) { i++; } 
        }
        return result;
    }
    
    public static void main(String args[]){
        int[] num = {1,1,1,0}; // {-1, 2, 1, -4};
        int target = -100; // 1;
        System.out.println((new ThreeSumClosest()).threeSumClosest(num,target));
    }
}
