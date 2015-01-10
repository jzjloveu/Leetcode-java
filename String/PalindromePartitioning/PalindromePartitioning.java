/*
Palindrome Partitioning

Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

 [
   ["aa","b"],
   ["a","a","b"]
 ]
*/
import java.util.*;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        int strLen = s.length();
        boolean[][] isPal = new boolean[strLen][strLen];
        // True means substring from s[i](included) 
        //  to s[j](included) is palindrome
        for(int j=0;j<strLen;j++)
        	for(int i=j;i>=0;i--)
			if(s.charAt(i)==s.charAt(j) && (j-i<=1 || isPal[i+1][j-1]==true))
				isPal[i][j] = true;
        dfs(s,isPal,0,result,new ArrayList<String>());
        return result;
    }
    
    private void dfs(String s, boolean[][] isPal, int start, 
            List<List<String>> result, ArrayList<String> palstr){
        int strLen = s.length();
        if(start == strLen){ result.add(palstr); return; }
        for(int end=0;end<strLen;end++)
            if(isPal[start][end] == true){
                ArrayList<String> temp = (ArrayList<String>) palstr.clone();
                temp.add(s.substring(start,end+1));
                dfs(s,isPal,end+1,result,temp);
		}
    }

    public static void main(String args[]){
        String str = "aab";
        PalindromePartitioning sol = new PalindromePartitioning();
        List<List<String>> result = sol.partition(str);
        for(int i=0;i<result.size();i++){
        	for(int j=0;j<result.get(i).size();j++)
			System.out.print(result.get(i).get(j)+" ");
                System.out.println();
       }
    }
}

/*
Dynamic programming. First use isPal to record each substring is palindrome or not. 
"isPal[i][j] == true" means a substring starts from s[i] (included) to s[j] (included) 
is a palindrome. Then use DFS.
*/
