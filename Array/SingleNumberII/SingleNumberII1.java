/*
Single Number II 

Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/


public class SingleNumberII1 {
   
    public int singleNumber(int[] A) {
        int ones = 0, twos = 0, threes = 0;
        for (int i = 0; i < A.length; i++) {
            twos |= ones & A[i];
            ones ^= A[i];   
            threes = ones & twos;
            ones &= ~threes;
            twos &= ~threes;
        }
        return ones;
    }

    public static void main(String args[]){
        int[] A = {1,2,1,3,1,2,2};
        System.out.println((new SingleNumberII1()).singleNumber(A));
    }
}

/*
Bit operation.
No extra memory used.
'ones' stands for bitmask only appears once in i-th position.
'twos' stands for bitmask only appears twice in i-th position.
'threes' stands for bitmask only appears three times in i-th position.
When the bitmask in i-th position appears three times, set 'ones' and 'twos' to zero.
And the final answer is the 'ones'.
*/
