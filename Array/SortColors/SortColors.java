/*
Sort Colors 

Given an array with n objects colored red, white or blue, 
sort them so that objects of the same color are adjacent, 
with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent 
the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function 
for this problem.

Follow up:
A rather straight forward solution is a two-pass algorithm 
using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, 
then overwrite array with total number of 0's, then 1's 
and followed by 2's.

Could you come up with an one-pass algorithm using only 
constant space?
*/
import arrayUtil.*;
import java.util.*;

public class SortColors  {
     public void sortColors(int[] A) {
        if(A.length == 0){ return; }
        int p0 = 0, p2 = A.length-1, i = 0;
        while(i <= p2){
            if(A[i] == 2) {
                int temp = A[p2];
                A[p2--] = A[i];
                A[i] = temp;
            }
            else if(A[i] == 0) {
                int temp = A[p0];
                A[p0++] = A[i];
                A[i++] = temp;
            }
            else { i++; }
        }
    }

    public static void main(String args[]){
        int[] A = {0,1,1,0,2,1,2,2,0};
        (new SortColors()).sortColors(A);
        ArrayListUtil.printArray(A);
    }
}

/*
Two pointer in place sorting, like quitsort handle duplicate 
elements.
But it can more simple for this problem, the idea as:
p0 is 0 value pointer start form beginnng, p2 is 2 value pointer 
start from the end; for pointer i go through the array, 
if A[i] is 2 then swap A[i] with A[p2], and then p2 move backward, 
i stay same; when i > p2, program stop.
If A[i] is 0, swap A[i] with A[p0], p0 and i both move forward.
if A[i] is 1, then just i move forward.
*/