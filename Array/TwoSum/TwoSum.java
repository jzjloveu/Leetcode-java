/*
Two Sum

Given an array of integers, find two numbers such that they add up to 
a specific target number.

The function twoSum should return indices of the two numbers such that 
they add up to the target, where index1 must be less than index2. 
Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
*/
import java.util.*;

public class TwoSum {
    public int[] twoSum(int[] numbers, int target){
        Map<Integer,List<Integer>> dic = new HashMap<Integer,List<Integer>>();
        for(int i=0;i<numbers.length;i++){
            if(!dic.containsKey(numbers[i])){
                List<Integer> arr = new ArrayList<Integer>();
                arr.add(i+1);
                dic.put(numbers[i],arr);
            }
            else{
                dic.get(numbers[i]).add(i+1);
            }
        }
        for(int i:numbers){
            if(dic.containsKey(target-i)){  
                if(i == target-i){
                    if(dic.get(i).size() == 2){
                        return new int[] {dic.get(i).get(0),dic.get(i).get(1)};
                    }
                }
                else{
                    if(dic.get(i).get(0) < dic.get(target-i).get(0)){
                        return new int[] {dic.get(i).get(0),dic.get(target-i).get(0)};
                    }
                    else{
                        return new int[] {dic.get(target-i).get(0),dic.get(i).get(0)};  
                    }
                }
            }
        }
        return new int[] {0,0};
    }
    
    public static void main(String args[]){
        int[] num = {2, 7, 11, 15}; //{0,4,3,0}; //  
        int target = 9; // 0; // 
        int[] arr = (new TwoSum()).twoSum(num,target);
        System.out.println(arr[0]+", "+arr[1]);
    }
}

/*
Need to notice the situation when two numbers are same:
num=[0,4,3,0], target=0
*/