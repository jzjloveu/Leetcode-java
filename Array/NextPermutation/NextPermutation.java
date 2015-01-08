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

public class NextPermutation {
    public void nextPermutation(int[] num) {
        int numLen = num.length, pindex = -1;
        //step 1
        for(int i=numLen-2;i>=0;i--)
            if(num[i] < num[i+1]) { pindex = i; break;}
        //step 2
        if(pindex != -1)
            for(int i=numLen-1;i>=0;i--)
                if(num[i] > num[pindex]){ //step 3
                    int tmp = num[i];
                    num[i] = num[pindex];
                    num[pindex] = tmp;
                    break;
                }
        //step 4
        int i = pindex+1, j = numLen-1;
        while(i < j){
            int tmp = num[i];
            num[i++] = num[j];
            num[j--] = tmp;
        }
    }
    
    public static void main(String args[]){
        int[] num = {1,3,2}; //{1,2,3}; //{1,1}; //
        (new NextPermutation()).nextPermutation(num);
        ArrayListUtil.printArray(num);
    }
}

/*
1. From right to left, find the first digit (PartitionNumber) which 
violates the decrease trend.
2. From right to left, find the first digit which is larger than 
PartitionNumber, call it ChangeNumber.
3. Swap PartitionNumber and ChangeNumber.
4. Reverse all the digit on the right of partition index.
*/