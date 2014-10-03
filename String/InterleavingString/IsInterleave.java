// Interleaving String 

// Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

// For example,
// Given:
// s1 = "aabcc",
// s2 = "dbbca",

// When s3 = "aadbbcbcac", return true.
// When s3 = "aadbbbaccc", return false.

public class IsInterleave {

    public boolean isInterleave(String s1, String s2, String s3) {
		int len1 = s1.length();
		int len2 = s2.length();
        int len3 = s3.length();
		if(len1+len2 != len3){ return false;}
		int[][] match = new int[len1+1][len2+1]; 
        for(int i=0;i<len1+1;i++)
            for(int j=0;j<len2+1;j++){
            	if(i>0 && match[i-1][j]==i-1+j && s1.charAt(i-1)==s3.charAt(i-1+j))
					match[i][j] = i + j;
				if(j>0 && match[i][j-1]==i+j-1 && s2.charAt(j-1)==s3.charAt(i+j-1))
					match[i][j] = i + j;
			}
        return match[len1][len2]==len3;
    }

    private static void printmatrix(int mx[][]){
		for(int i=0;i<mx.length;i++){
			for(int j=0;j<mx[i].length;j++)
 				System.out.print(mx[i][j]+" ");
			System.out.println();
		}
	}

    public static void main(String args[]){
        String s1 = "aabcc";
    	String s2 = "dbbca";
        String s3 = "aadbbcbcac";//"aadbbbaccc";
		System.out.println((new IsInterleave()).isInterleave(s1,s2,s3));
    }
}
/*
Using dynamic programming (DP).
match[i][j]=m means the front to ith charactors of s1 and the front to jth charactors of s2 can form the front to mth charactors of s3, so in the end when match[len_s1][len_s2]==len_s3 return true.
*/
