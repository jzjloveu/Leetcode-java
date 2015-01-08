/*
One Edit Distance

Given two strings S and T, determine if they are both one edit 
distance apart.

Hint:
1. If | n - m | is greater than 1, we know immediately both are 
not one-edit distance apart.
2. It might help if you consider these cases separately, m == n and m != n.
3. Assume that m is always <= n, which greatly simplifies the conditional 
statements. If m > n, we could just simply swap S and T.
4. If m == n, it becomes finding if there is exactly one modified operation. 
If m != n, you do not have to consider the delete operation. Just consider 
the insert operation in T.
*/
import java.util.*;

public class OneEditDistance {
   
    public boolean isOneEditDistance(String s, String t) {
        if(s.length() > t.length()){
        	String temp = t; t = s; s = temp;
        }
        if(t.length() - s.length() > 1) return false;
        boolean flag = false;
        for(int i=0,j=0;i<s.length();i++,j++){
        	if(s.charAt(i) != t.charAt(j)){
        		if(flag) return false;
        		flag = true;
        		if(s.length() < t.length()) i--;
        	}
        }
        return flag || s.length() < t.length();
    }

    public static void main(String args[]){
        String s = "simple";
        String t = "simple";
        System.out.println((new OneEditDistance()).isOneEditDistance(s,t)); 
    }
}

/*
Just two cases:
1. when s length equals t length, then no more than one char different.
2. if s length is less than t length, then there is one char in t different
from s either in the middle of s or may be append to s, such 'abc' and 'abcd'.
*/