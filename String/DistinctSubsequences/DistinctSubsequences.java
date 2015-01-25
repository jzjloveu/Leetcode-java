/*
Distinct Subsequences 

Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by 
deleting some (can be none) of the characters without disturbing the relative positions 
of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3. 
*/
public class DistinctSubsequences {

    public int numDistinct(String S, String T) {
		int lenS = S.length(), lenT = T.length();
		int[][] match = new int[lenS+1][lenT+1]; 
        // empty string is a subsequence of any string
        for(int i=0;i<lenS+1;i++) match[i][0] = 1;
		for(int i=1;i<lenS+1;i++){
            int range = Math.min(i+1,lenT+1);
			for(int j=1;j<range;j++)
            	match[i][j] = (S.charAt(i-1)==T.charAt(j-1))?match[i-1][j]+match[i-1][j-1]:match[i-1][j];
		}
		return match[lenS][lenT];
    }

    public static void main(String args[]){
        String S = "ccc";//"rabbbit";
    	String T = "c";//"rabbit";
		System.out.println((new DistinctSubsequences()).numDistinct(S,T));
    }
}
/*
The idea is using dynamic programming (DP).
The key is to find the recursive relation. We can think in this way: consider the original 
string length is i, substring length is j. All we need to do is to count the number when j 
length substring appear in the original i length string. Let the count to be t[i][j], 
if the last charactor of original string is not eaqual to last charactor of substring, 
which means appear count number of j length substring will in the i-1 length original string 
that is t[i][j]=t[i-1][j]. If both last charactors is same, then we need count the last charactor 
as addition that is t[i][j]=t[i-1][j] + t[i-1][j-1].
*/
