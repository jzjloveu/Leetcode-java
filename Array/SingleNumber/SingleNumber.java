/*
Single Number

Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/


public class SingleNumber {
   
    public int singleNumber(int[] A) {
        int res = 0;
        for(int i:A) res ^= i;
        return res;
    }

    public static void main(String args[]){
        int[] A = {1,2,1,3,4,2,3,4,5};
        System.out.println((new SingleNumber()).singleNumber(A));
    }
}

/*
The requirement is O(n) time and O(1) space.
Thus, the  "first sort and then find " way is not working.
Also the "hash map" way is not working.

Since we can not sort the array, we shall find a cumulative way, which is not about the ordering.

XOR is a good way, we can use the property that A XOR A = 0, and A XOR B XOR A = B.

So, the code becomes extremely easy.
*/
