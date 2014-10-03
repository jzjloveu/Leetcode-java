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
		boolean[][] res = new boolean[s.length()+1][p.length()+1];
        res[0][0] = true;
        for(int i=1;i<p.length()+1;i++)
            if(p.charAt(i-1) == '*')
                if(i >= 2) res[0][i] = res[0][i-2];
        for(int i=1;i<s.length()+1;i++)
            for(int j=1;j<p.length()+1;j++){
                if(p.charAt(j-1) == '.') res[i][j] = res[i-1][j-1];
                else if(p.charAt(j-1) == '*' && j>1)
                    res[i][j] = res[i][j-1] || res[i][j-2] || (res[i-1][j] && (s.charAt(i-1)==p.charAt(j-2) || p.charAt(j-2)=='.'));
                else res[i][j] = res[i-1][j-1] && s.charAt(i-1)==p.charAt(j-1);
            }
        return res[s.length()][p.length()];
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

This is DP version, more efficient.
*/

