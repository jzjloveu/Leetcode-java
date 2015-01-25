/*
Edit Distance 

Given two words word1 and word2, find the minimum number 
of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character
*/

public class MinDistance {
   
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        // initialization  
        int[][] step = new int[len1+1][len2+1];
        for(int i=0;i<len1+1;i++)
			step[i][0] = i;
        for(int j=0;j<len2+1;j++)
            step[0][j] = j;
        // the dp procedure
        for(int i=1;i<len1+1;i++)
			for(int j=1;j<len2+1;j++){
				if(word1.charAt(i-1) == word2.charAt(j-1))
					step[i][j] = step[i-1][j-1];
				else{
					int min = Math.min(step[i-1][j],step[i][j-1]);
                    min = Math.min(min,step[i-1][j-1]);
                    step[i][j] = min + 1;
				}
			}
		return step[len1][len2];
    }

    public static void main(String args[]){
        String word1 = "ACC";
    	String word2 = "BBDC";
        System.out.println((new MinDistance()).minDistance(word1,word2));
    }
}
/*
Dynamic programming. Let dp[i][j] indicate the steps (edit distance) of changing 
word1's first i letters to word2's first j letters. If word1's ith letter equals 
to word2's jth letter, then dp[i][j] = dp[i-1][j-1]. If not, 3 cases:
1) Change word1's first i-1 letters to word2's j-1 letters, then change word1's 
   ith letter to word2's jth letter, i.e. dp[i-1][j-1] + 1
2) Change word1's first i letters to word2's first j-1 letters, then add word2's 
   jth letter, i.e. dp[i][j-1] + 1
3) Delete word1's ith letter, then change word1's first i-1 letters to word2's first 
   j letters, i.e. 1 + dp[i-1][j]
dp[i][j] is the min value of the above 3 cases. Initialization: 
dp[i][0] = i (0 <= i <= word1 length), dp[0][j] = j (0 <= j <= word2 length).
*/
