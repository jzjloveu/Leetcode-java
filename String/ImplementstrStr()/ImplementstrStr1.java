/*
Implement strStr() 

Implement strStr().

Returns the index of the first occurrence of needle in haystack, 
or -1 if needle is not part of haystack.
*/
import java.util.*;

public class ImplementstrStr1 {
    public int strStr(String haystack, String needle) {
        if(needle.isEmpty()) return 0;
        if(haystack.isEmpty()) return -1;
        int m = haystack.length(), n = needle.length();
        int[] match = KMPpreprocessing(needle);
        int j = -1;
        for(int i=0;i<m;i++) {
            while(j>=0 && haystack.charAt(i)!=needle.charAt(j+1)) 
                j = match[j];
            if(haystack.charAt(i)==needle.charAt(j+1)) j++;
            if(j == n-1) return i-n+1;
        }
        return -1; 
    }

    private int[] KMPpreprocessing(String s){
        int n = s.length(), j = -1;
        int[] match = new int[n];
        Arrays.fill(match,-1);
        for(int i=1;i<n;i++){
            while(j>=0 && s.charAt(i)!=s.charAt(j+1)) 
                j = match[j];
            if(s.charAt(i) == s.charAt(j+1)) j++;
            match[i] = j;
        }
        return match;
    }

    public static void main(String args[]){
        String S = "This is a simple string";
        String sub = "simple";
        System.out.println((new ImplementstrStr1()).strStr(S,sub)); 
    }
}

/*
KMP algorithm. Complexity is O(n).
Reference:
http://www.matrix67.com/blog/archives/115
*/

