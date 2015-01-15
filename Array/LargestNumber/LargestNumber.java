/*
Largest Number

Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.
*/
import java.util.*;

class StringComparator implements Comparator<String> {
    public int compare(String a, String b) {
        String ab = a+b, ba = b+a;
        return ba.compareTo(ab);
    }
}
public class LargestNumber {
     public String largestNumber(int[] num) {
        ArrayList<String> list = new ArrayList<String>(num.length);
        for (int i=0;i<num.length;i++) list.add(""+num[i]);
        Collections.sort(list,new StringComparator());
        String result = list.toString().replaceAll("[^\\d.]","");
        if (result.charAt(0)=='0') return "0";
        return result;
    }

    public static void main(String args[]){
        int[] arr = {3, 30, 34, 5, 9};
        System.out.println((new LargestNumber()).largestNumber(arr));
    }
}
/*
Greedy algorithm.
Pick two numbers in the array, 
if String.valueOf(a)+String.valueOf(b) > String.valueOf(b)+String.valueOf(a), 
then a advanced b, otherwise b advanced a.
*/