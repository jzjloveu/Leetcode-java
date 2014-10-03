// Decode Ways 

// A message containing letters from A-Z is being encoded to numbers using the following mapping:

// 'A' -> 1
// 'B' -> 2
// ...
// 'Z' -> 26
// Given an encoded message containing digits, determine the total number of ways to decode it.

// For example,
// Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

// The number of ways decoding "12" is 2.

public class NumDecodings {
   
    public int numDecodings(String s)  {
        if(s.isEmpty() || s.charAt(0)=='0'){ return 0;}
        java.util.ArrayList<Integer> ways = new java.util.ArrayList<Integer>();
        ways.add(1);ways.add(1);
        for(int i=2;i<=s.length();i++){
			if(10<=Integer.parseInt(s.substring(i-2,i)) &&
               Integer.parseInt(s.substring(i-2,i))<=26 &&
               1<=Character.getNumericValue(s.charAt(i-1)) &&
               Character.getNumericValue(s.charAt(i-1))<=9)
				ways.add(ways.get(i-1)+ways.get(i-2));
            else if(10<=Integer.parseInt(s.substring(i-2,i)) && 
                    Integer.parseInt(s.substring(i-2,i))<=26)
                ways.add(ways.get(i-2));
            else if(1<=Character.getNumericValue(s.charAt(i-1)) && 
                    Character.getNumericValue(s.charAt(i-1))<=9)
                ways.add(ways.get(i-1));
            else // s[i] == '0'
                return 0;
		}
        return ways.get(s.length());
    }

    public static void main(String args[]){
        String s = "12";
        System.out.println((new NumDecodings()).numDecodings(s));
    }
}
/*
Using recursive. First we need look at the current value and previous value, also need mine the 0 case, such as "10", "101" which can only count one decode way. ways[N]=M means the previous N charactors of string s have M decode ways.
*/
