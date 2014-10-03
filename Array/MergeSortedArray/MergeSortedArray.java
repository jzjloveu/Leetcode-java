/*
Merge Sorted Array 

Given two sorted integer arrays A and B, merge B into A as one sorted array.

Note:
You may assume that A has enough space (size that is greater or equal to m + n) 
to hold additional elements from B. The number of elements initialized in A and B 
are m and n respectively.
*/
import java.util.*;

public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n){
        int i,j,k;
        i = m-1; j = n-1; k = m+n-1;
        while(i>=0 && j >=0){
            if(A[i] < B[j]) { A[k] = B[j--]; }
            else { A[k] = A[i--]; }
            k--;
        }
        while(j >= 0){
            A[k--] = B[j--];
        }
    }

    private static void printArray(int[] arr){
        for(int i:arr)
            System.out.print(i+" ");
        System.out.println();
    }

    public static void main(String args[]){
        int[] A = {2, 7, 11, 15,0,0,0};
        int[] B = {3, 6 , 10};
        (new MergeSortedArray()).merge(A,4,B,3);
        printArray(A);
    }
}
