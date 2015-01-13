
/*Word Break

Given a string s and a dictionary of words dict, determine if s can be segmented 
into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code". 
*/
import java.util.Set;
import java.util.HashSet;
public class WordBreak1 {
    public boolean wordBreak(String s, Set<String> dict) {
        boolean[] segment = new boolean[s.length()+1];
        segment[0] = true;
        for(int i=0;i<s.length();i++)
            for(int j=i;j>=0;j--)
                if(segment[j] && dict.contains(s.substring(j,i+1))){
                    segment[i+1] = true;
                    break;
                }
        return segment[s.length()];
    }

    public static void main(String args[]){
        String str = "leetcode";
        Set<String> dict = new HashSet<String>();
        dict.add("leet"); dict.add("code");
        WordBreak1 sol = new WordBreak1();
        System.out.println(sol.wordBreak(str,dict));
    }
}

/*
The same DP method but in reverse way.

We solve this problem using DP
Define a boolean array A[0..n-1], where
A[i] = True, means s[i..n-1] can be segmented into words
------------------------------------
The recursive formula is:
A[i] = True, if there exists j>i (s[i..n-1] = s[i..j-1] + s[j..n-1])
           such that s[i..j-1] is a word and A[j] = True
or A[i] = True, if s[i..n-1] is a word
------------------------------------
We fill A-table from i=n-1 to n
*/