/* 
Median of Two Sorted Arrays 

Given two sorted integer arrays A and B of size n and m respectively, find the kth smallest element in the sum of A and B with pairs in O(k*lg(n+m)) time.
*/
import java.util.Arrays;
public class FindMedianSortedArrays{
	private float findMedianSortedArrays(int[] arr1,int[] arr2){
		int length = arr1.length + arr2.length;
		if(length % 2 == 1)
			return getMedian(arr1,arr2,length/2+1);
		else
			return (float)(getMedian(arr1,arr2,length/2)+getMedian(arr1,arr2,length/2+1))/2;
	}
	
	private int getMedian(int[] arr1,int[] arr2,int k){
		// return kth smallest number of arrays arr1 and arr2, 
        // assume len(arr1) <= len(arr2)
		int length1 = arr1.length;
        int length2 = arr2.length;
		if(length1 > length2){ return getMedian(arr2,arr1,k);}
		if(length1 == 0){ return arr2[k-1];}
  		if(k == 1){ return (arr1[0]<arr2[0])?arr1[0]:arr2[0];}
		int part1 = (k/2<length1)?k/2:length1;
        int part2 = k - part1;
		if(arr1[part1-1] <= arr2[part2-1])
			return getMedian(Arrays.copyOfRange(arr1,part1,length1),arr2,k-part1);
        else
			return getMedian(arr1,Arrays.copyOfRange(arr2,part2,length2),k-part2);
	}
   
	public static void main(String args[]) {
		int[] arr1 = {1, 5, 7, 10, 13};
    	int[] arr2 = {4, 6, 8, 10, 12};
		float ans = (new FindMedianSortedArrays()).findMedianSortedArrays(arr1,arr2);
		System.out.println(ans);
	}
}
/*
First, as the two arrays are sorted. Median is the (m+n)/2+1 th element if m+n is odd, the average of (m+n)/2 th and (m+n)/2+1 th  if m+n is even. e.g.  [1,2,3],[5,6,7], the median is (3+5)/2 = 4.0. [1,2,3,4], [1,3,5,7,9], the median is 3.

As mentioned above, our task becomes find the Kth (K-1 and K) number in two arrays. Two pointers are used, one for array A and one for array B. The basic idea is count K elements from A and B according to the pointers. A better thought is that assign half of K to each side, cut the smaller array again and again, until (1) the smaller array is empty, output the (K-1)th (array starts from 0) element in the bigger array (2) K=1. Return min(A[0],B[0]);
*/
