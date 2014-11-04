/*
Remove Element 

Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.
*/

public class RemoveElement  {
    public int removeElement(int[] A, int elem) {
        int newlen = 0;
        for(int i:A)
            if(i != elem)
                A[newlen++] = i;
        return newlen;
    }
    
    public static void main(String args[]){
        int[] A = {1,9,9,2}; 
        int elem = 9;
        System.out.println((new RemoveElement()).removeElement(A,elem));
    }
}
