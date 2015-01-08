/*
Longest Substring with At Most Two Distinct Characters

GGiven a string S, find the length of the longest substring 
T that contains at most two distinct characters.

For example,
Given S = "eceba",
T is "ece" which its length is 3.
*/

public class LongestSubstringWithAtMostTwoUniqueCharacters {
   
    public int maxLength(String s) {
        int i = 0, j = -1, maxLen = 0;
        for (int k = 1; k < s.length(); k++) {
            if (s.charAt(k) == s.charAt(k - 1)) continue;
            if (j >= 0 && s.charAt(j) != s.charAt(k)) {
                maxLen = Math.max(k - i, maxLen);
                i = j + 1;
            }
            j = k - 1;
        }
        return Math.max(s.length() - i, maxLen);
    }

    public static void main(String args[]){
        String S = "abcbbbbcccbdddadacb"; //"eceba";// "abaac";
        LongestSubstringWithAtMostTwoUniqueCharacters sol = 
            new LongestSubstringWithAtMostTwoUniqueCharacters();
        System.out.println(sol.maxLength(S));
    }
}

/*
An O(n) solution: (this is standard solutin)
the idea is to maintain a sliding window.
use two pointers, one store the previous different char index.
e.g.
index   0 1 2 3 4 
str     a b a a c 
1st run --^---^
2nd run     ^---^
*/

