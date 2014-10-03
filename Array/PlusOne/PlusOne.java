/*
Plus One

Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
*/
import arrayUtil.*;
import java.util.*;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int[] newdigi = new int[digits.length+1];
        int carry = 0;
        for(int i=digits.length-1;i>=0;i--){
            if(i == digits.length-1)
                digits[i] = 1 + digits[i];
            else
                digits[i] = digits[i] + carry;
            if(digits[i] == 10){
                digits[i] = 0;
                carry = 1;
            }
            else
                carry = 0;
        }
        if(carry == 1){
            newdigi[0] = 1;
            for(int i=0;i<digits.length;i++)
                newdigi[i+1] = digits[i];
            return newdigi;
        }
        return digits;
    }
    
    public static void main(String args[]){
        int[] digits = {9,9,9,9}; 
        int[] arr = (new PlusOne()).plusOne(digits);
        ArrayListUtil.printArray(arr);
    }
}
