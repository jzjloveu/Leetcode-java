/*
Longest Substring with At Most Two Distinct Characters

GGiven a string S, find the length of the longest substring 
T that contains at most two distinct characters.

For example,
Given S = "eceba",
T is "ece" which its length is 3.
*/

public class LongestSubstringWithAtMostTwoUniqueCharacters1 {
   
   // public int maxLength(String s) {
    public String maxLength(String s) { //for print maxLen substr
        //if (s.isEmpty()) return 0;
        int maxlen = 1, currLen = 1, diffIdx = -1;
        int maxIdx = 0; //for print maxLen substr
        for(int i=1;i<s.length();i++){
            if(s.charAt(i) != s.charAt(i-1)){
                if(diffIdx==-1 || s.charAt(i)==s.charAt(diffIdx))
                    currLen++;
                else currLen = i - diffIdx;
                diffIdx = i - 1;
            }
            else currLen++;   
            if(maxlen < currLen) {
                maxlen = currLen;
                maxIdx = i-currLen+1; //for print maxLen substr
            }    
        }
        //return maxlen;
        return s.substring(maxIdx,maxIdx+maxlen); //for print maxLen substr

    }

    public static void main(String args[]){
        String S = "abcbbbbcccbdddadacb"; //"eceba"; //"abaac";
        LongestSubstringWithAtMostTwoUniqueCharacters1 sol = 
            new LongestSubstringWithAtMostTwoUniqueCharacters1();
        System.out.println(sol.maxLength(S));
    }
}

/*
An O(n) solution:
the idea is to maintain a sliding window.
use two pointers, one store the previous different char index.
e.g.
index   0 1 2 3 4 
str     a b a a c 
1st run --^---^
2nd run     ^---^
*/

