/*
Wildcard Matching 

Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") -> false
isMatch("aa","aa") -> true
isMatch("aaa","aa") -> false
isMatch("aa", "*") -> true
isMatch("aa", "a*") -> true
isMatch("ab", "?*") -> true
isMatch("aab", "c*a*b") -> false
*/
import java.util.*;

public class IsMatch {
   
    public boolean isMatch(String s, String p) {
        int slen = s.length(), plen = p.length();
        int sPoint = 0, pPoint= 0, match = 0, star = -1;
        while(sPoint < slen){
            if(pPoint<plen && (s.charAt(sPoint)==p.charAt(pPoint) || p.charAt(pPoint)=='?')){
                sPoint++; 
                pPoint++;
                continue;
            }
            if(pPoint<plen && p.charAt(pPoint)=='*'){
                match = sPoint;
                star = pPoint;
                pPoint++;
                continue;
            }
            if(star != -1){
                pPoint = star+1;
                match++;
                sPoint = match;
                continue;
            }
            return false;
        }
        while(pPoint<plen && p.charAt(pPoint)=='*')
            pPoint++;
             
        return pPoint == plen;        
    }

    public static void main(String args[]){
        String[] s = {"aa","aa","aaa","aa","aa","ab","aab"};
        String[] p = {"a","aa","aa","*","a*","?*","c*a*b"};
        for(int i=0;i<s.length;i++){
            System.out.println((new IsMatch()).isMatch(s[i],p[i]));
        }
    }
}

/*
For each element in s
If *s==*p or *p == ? which means this is a match, then goes to next element s++ p++.
If p=='*', this is also a match, but one or many chars may be available, so let us save this *'s position and the matched s position.
If not match, then we check if there is a * previously showed up,
       if there is no *,  return false;
       if there is an *,  we set current p to the next element of *, and set current s to the next saved s position.

e.g.

abed
?b*d**

a=?, go on, b=b, go on,
e=*, save * position star=3, save s position ss = 3, p++
e!=d,  check if there was a *, yes, ss++, s=ss; p=star+1
d=d, go on, meet the end.
check the rest element in p, if all are *, true, else false;

Note that in char array, the last is NOT NULL, to check the end, use  "*p"  or "*p=='\0'".
*/

