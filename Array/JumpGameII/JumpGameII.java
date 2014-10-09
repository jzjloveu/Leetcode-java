/*
Jump Game II 

Given an array of non-negative integers, you are initially positioned 
at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. 
(Jump 1 step from index 0 to 1, then 3 steps to the last index.)
*/
import java.util.*;

public class JumpGameII {
    public int jump(int[] A) {
        int lenA = A.length, maxi = 0, jumpNum = 0;
        if(lenA == 1) { return 0; }
        while(true){
            jumpNum++;
            int tmp = maxi;
            for(int i=0;i<=tmp;i++){
                maxi = Math.max(maxi,i+A[i]);
                if(maxi >= lenA - 1) { return jumpNum; }
            }
        }
    }
    
    public static void main(String args[]){
        int[] A = {2,3,1,1,4}; 
        System.out.println((new JumpGameII()).jump(A));
    }
}

/*
Similar as Jump Game.  Store first step can reach maximum index 
and count the jump number, then go to the index and do the same 
till the last index.
*/