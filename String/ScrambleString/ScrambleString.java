/*
Scramble String

Given a string s1, we may represent it as a binary tree by partitioning it to 
two non-empty substrings recursively.

Below is one possible representation of s1 = "great":

   great
  /    \
 gr    eat
/ \    /  \
g   r  e   at
          / \
         a   t
To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node "gr" and swap its two children, it produces a 
scrambled string "rgeat".

   rgeat
  /    \
 rg    eat
/ \    /  \
r   g  e   at
          / \
         a   t
We say that "rgeat" is a scrambled string of "great".

Similarly, if we continue to swap the children of nodes "eat" and "at", it produces 
a scrambled string "rgtae".

   rgtae
  /    \
 rg    tae
/ \    /  \
r   g  ta  e
      / \
     t   a
We say that "rgtae" is a scrambled string of "great".

Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
*/
import java.util.*;

public class ScrambleString {
   
    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        if(s1.equals(s2)) return true;
        int strlen = s1.length();
        char[] c1 = s1.toCharArray(); Arrays.sort(c1);
        char[] c2 = s2.toCharArray(); Arrays.sort(c2);
        if(!Arrays.equals(c1,c2)) return false;
        for(int i=1;i<strlen;i++){
            if(isScramble(s1.substring(0,i),s2.substring(0,i)) && isScramble(s1.substring(i),s2.substring(i)))
                return true;
            if(isScramble(s1.substring(0,i),s2.substring(strlen-i)) && isScramble(s1.substring(i),s2.substring(0,strlen-i)))
                return true;
        }
        return false;
    }

    public static void main(String args[]){
        String s1 = "great";
    	String s2 = "rgtae";//"rgeat" ;
        System.out.println((new ScrambleString()).isScramble(s1,s2));
    }
}
/*
Using recursive binary tree 
*/
