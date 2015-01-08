/*
Jump Game

Given an array of non-negative integers, you are initially positioned 
at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
*/
import java.util.*;

public class JumpGame {
    public boolean canJump(int[] A) {
        int maxj = 0;
        for(int i=0;i<A.length;i++)
            if(i <= maxj){
                maxj = Math.max(maxj, i+A[i]);
                if(maxj >= A.length-1)
                    return true;
            }
        return false;   
    }
    
    public static void main(String args[]){
        int[] A = {2,3,1,1,4}; // {3,2,1,0,4}; // 
        System.out.println((new JumpGame()).canJump(A));
    }
}

/*
Note that the A[i] means the maximum jump length. In other words, 
it is possible that we move j steps (<A[i]) when we at A[i], 
e.g. if A[i]=2, we can move either 1 or 2 steps.
*/