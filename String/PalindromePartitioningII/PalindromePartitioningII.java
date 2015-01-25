/*
Palindrome Partitioning II 

Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut. 
*/

public class PalindromePartitioningII {
    public int minCut(String s) {
        int strLen = s.length();
        boolean[][] isPal = new boolean[strLen][strLen];
        int[] minPaNum = new int[strLen];
        for(int i=0;i<strLen;i++) minPaNum[i] = i + 1;
        for(int j=0;j<strLen;j++)
        	for(int i=j;i>=0;i--)
                if(s.charAt(i)==s.charAt(j) && (j-i<=1 || isPal[i+1][j-1]==true)){
				    isPal[i][j] = true; 
                    minPaNum[j]=i>0?Math.min(minPaNum[j],minPaNum[i-1]+1):Math.min(minPaNum[j],1);
                }
        return minPaNum[strLen-1]-1;
    }

    public static void main(String args[]){
        String str = "aab";
        System.out.println((new PalindromePartitioningII()).minCut(str));
    }
}

/*
Dynamic programming. Use "isPal" to record whether a substring is a palindrome or not, 
"isPal[i][j] == true" means a substring starts from s[i] (includsive) to s[j] (inclusive) 
is a palindrome. Use "minPalNum" to record the minimum number of palindromes within a substring 
start from s[0], "minPalNum[i] == 3" means a substring starts from s[0] (included) to s[i] (included) 
has 3 palindromes and 3 is the minimum number. When we meet a "isPal[i][j] == true" case, 
we update minPalNum. Finally the result is minPalNum[lenS-1] - 1.
*/
