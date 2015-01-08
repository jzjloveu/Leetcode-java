/*
Single Number II 

Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/


public class SingleNumberII {
   
    public int singleNumber(int[] A) {
        int[] bit = new int[32];
        for(int x : A)
            for(int i=0;i<32;i++)
                if((x & (1<<i)) == 1<<i) bit[i]++;
        int result = 0;
        if(bit[31] % 3 == 0) {// positive
            for(int i=0;i<31;i++)
                if(bit[i]%3 == 1) result += 1<<i;
        }
        else {// negative
            for(int i=0;i<31;i++)
                if(bit[i]%3 == 0) result += 1<<i;
            result = -(result+1);
        }
        return result;
    }

    public static void main(String args[]){
        int[] A = {1,2,1,3,1,2,2};
        System.out.println((new SingleNumberII()).singleNumber(A));
    }
}

/*
Need to consider these cases:
1. irregular input but valid, such as "-3924x8fc","  +  413";
2. invalid format: such as " ++c", " ++1"
3. overflow integer range: "2147483648".
*/
