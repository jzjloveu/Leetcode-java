/*
Regular Expression Matching 

Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") -> false
isMatch("aa","aa") -> true
isMatch("aaa","aa") -> false
isMatch("aa", "a*") -> true
isMatch("aa", ".*") -> true
isMatch("ab", ".*") -> true
isMatch("aab", "c*a*b") -> false
*/
import java.util.*;

public class IsMatchII {
   
    public static boolean isMatch(String s, String p) {
		return match(s, p, 0, 0);
	}
	
	public static boolean match(String s, String p, int iS, int iP){
		if(iP >= p.length()) return iS >= s.length(); //It matchs when p finished and s also finished.
		if(iP == p.length()-1)//If iP is last index, it matchs when iS also is last and the char equals. 
			return (iS == s.length()-1) && (s.charAt(iS)==p.charAt(iP) || p.charAt(iP)=='.');
        if(iP+1<p.length() && p.charAt(iP+1)!='*'){//If p's next char iP+1 is not '*'.
			if(iS == s.length()) return false; //It not match if iS finished. 
			if(s.charAt(iS)==p.charAt(iP) || p.charAt(iP)=='.') //If current index char match, then go on
                return match(s, p, iS+1, iP+1);
            else return false; //If current index char not match, then return false.
		} //If next iP+1 is '*' and current index char match, then go on.
		while(iS<s.length() && iP<p.length() && (s.charAt(iS)==p.charAt(iP) || p.charAt(iP)=='.')){
            //since '*' can be 0,1,2,...so iS=iS,iS+1,iS+2,...need try all possible index of s
			//see if the rest match or not
			if(match(s, p, iS, iP+2)) return true; //if get one match means, it means done match 
	        iS++;
		}
        //If next iP+1 is '*' and current index char not match, then p skip two and go on.
		//another case meet here is when it is iS==s.length()
		return match(s, p, iS, iP+2);
	}

    public static void main(String args[]){
        String[] s={"aa","aa","aaa","aa","aa","ab","aab","",    "ab","aaa","a","a",  "bb","bb"};
        String[] p={"a","aa","aa","a*",".*",".*","c*a*b","bab",".*c","a.a",".","ab*",".bab","*"};
                   //T,  F,  T,    F,   T,   T,   T,     F,     F,    T,    T,  T,    F,   F   
        for(int iS=0;iS<s.length;iS++)
            System.out.println((new IsMatchII()).isMatch(s[iS],p[iS]));
    }
}

/*
The same question of Wildcard Matching.
The major difference is the meaning of  "*" in the string.
Here, "*" means 0 or more preceding element. For example, the last test case in the problem description: 
    isMatch("aab",""c*a*b")
The pattern :  "c*a*b" means,  there can be 0 or more 'c', 0 or more 'a' and one b.
e.g., "ccaab", "aab", "ccb", "b" are all valid strings for this pattern, thus the correct answer for this test case is also true (0 'c', 2 'a' and 1 'b').

This is recursive version, low efficiency.
*/

