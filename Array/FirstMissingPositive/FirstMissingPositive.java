/*
First Missing Positive

Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
*/

public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {
        for(int i=0;i<A.length;i++)
            while(A[i] != i+1){
                if(A[i]<=0 || A[i]>A.length || A[i]==A[A[i]-1])
                    break;
                // swap A[i], A[A[i]-1] 
                int tmp=A[A[i]-1]; A[A[i]-1]=A[i]; A[i]=tmp;
            }
        for(int i=0;i<A.length;i++)
            if(A[i] != i+1) { return i+1; }
        return A.length+1;
    }
    
    public static void main(String args[]){
        int[] A = {3,4,-1,1};
        int index = (new FirstMissingPositive()).firstMissingPositive(A);
        System.out.println(index);
    }
}

/*
It is bucket, but cannot use extra space. So when A[i] != i, need to 
swap A[i] with A[A[i]], until A[i] == A[A[i]]. Then go through the array and 
find the miss match index and value.
Just notice, because need to a positive number, so we need start from i+1, 
since 0 is not positive integer, like A[i] = i+1.
*/