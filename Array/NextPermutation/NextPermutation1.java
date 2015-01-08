/*
Next Permutation  

Implement next permutation, which rearranges numbers into the lexicographically 
next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible 
order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding 
outputs are in the right-hand column.
1,2,3 -> 1,3,2
3,2,1 -> 1,2,3
1,1,5 -> 1,5,1
*/
import arrayUtil.*;
import java.util.*;

public class NextPermutation1 {
    public void nextPermutation(int[] num) {
        int k = -1, l = 0;
        //step 1
        for(int i=0;i<num.length-1;i++)
            if(num[i] < num[i+1]) k = i;
        if(k == -1) {reverse(num,0,num.length-1); return;}
        //step 2
        for(int i=0;i<num.length;i++)
            if(num[i] > num[k]) l = i;
        //step 3
        int temp=num[k]; num[k]=num[l]; num[l]=temp;
        //step 4
        reverse(num,k+1,num.length-1);
    }
    private void reverse(int[] arr, int start, int end){
        while(start < end){
            int temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
    }
    
    public static void main(String args[]){
        int[] num = {1,3,2}; //{1,2,3}; //{1,1}; //
        (new NextPermutation1()).nextPermutation(num);
        ArrayListUtil.printArray(num);
    }
}

/*
Step 1: Find the largest index k, such that A[k]<A[k+1]. 
    If not exist, this is the last permutation. (in this    
    problem just sort the vector and return.)
Step 2: Find the largest index l, such that A[l]>A[k].
Step 3: Swap A[k] and A[l].
Step 4: Reverse A[k+1] to the end.
*/