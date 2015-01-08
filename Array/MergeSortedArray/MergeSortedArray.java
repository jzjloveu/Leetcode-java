/*
Merge Sorted Array 

Given two sorted integer arrays A and B, merge B into A as one sorted array.

Note:
You may assume that A has enough space (size that is greater or equal to m + n) 
to hold additional elements from B. The number of elements initialized in A and B 
are m and n respectively.
*/
import arrayUtil.*;

public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n){
        int k = m+n-1; m--; n--;
        while(m>=0 && n>= 0) A[k--] = A[m]>B[n]?A[m--]:B[n--];
        while(n >= 0) A[k--] = B[n--];   
    }

    public static void main(String args[]){
        int[] A = {2, 7, 11, 15,0,0,0};
        int[] B = {3, 6, 10};
        (new MergeSortedArray()).merge(A,4,B,3);
        ArrayListUtil.printArray(A);
    }
}

/*
Part of the merge sort, merge the arrays from the back by comparing the elements.
*/