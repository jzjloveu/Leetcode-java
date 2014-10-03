// Palindrome Partitioning

// Given a string s, partition s such that every substring of the partition is a palindrome.

// Return all possible palindrome partitioning of s.

// For example, given s = "aab",
// Return

//  [
//    ["aa","b"],
//    ["a","a","b"]
//  ]

import java.util.Arrays;
import java.util.ArrayList;

public class Partition2 {

    public ArrayList<ArrayList<String>> partition(String s) {
        //Dynamic Programming
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        for(int i=0; i<s.length(); i++){
            isPalindrome[i][i]=true;
            if(i<s.length()-1)
                isPalindrome[i][i+1]=s.charAt(i)==s.charAt(i+1);
        }
        for(int l=2; l<s.length(); l++){
            for(int i=0; i<s.length()-l; i++)
                isPalindrome[i][i+l]= s.charAt(i)==s.charAt(i+l) && isPalindrome[i+1][i+l-1];
        }
        
        ArrayList<ArrayList<String>> sol = new ArrayList<ArrayList<String>>();
        partition(s, isPalindrome, 0, sol, new ArrayList<String>());
        return sol;
    }
    
    private void partition(String s, boolean[][] isPalindrome, int index, ArrayList<ArrayList<String>> sol, ArrayList<String> tempSol){
        if(index==s.length()){
            sol.add(tempSol);
            return;
        }
        for(int i=index; i<s.length(); i++){
            if(isPalindrome[index][i]){
                ArrayList<String> temp = (ArrayList<String>) tempSol.clone();
                temp.add(s.substring(index, i+1));
                partition(s, isPalindrome, i+1, sol, temp);
            }
        }
    }
			
    public static void main(String args[]){
        String str = "aab";
        Partition2 sol = new Partition2();
	ArrayList<ArrayList<String>> result = sol.partition(str);
        for(int i=0;i<result.size();i++){
        	for(int j=0;j<result.get(i).size();j++)
			System.out.print(result.get(i).get(j)+" ");
                System.out.println();
       }
    }
}

/*
Dynamic programming. First use isPal to record each substring is palindrome or not. "isPal[i][j] == true" means a substring starts from s[i] (included) to s[j] (included) is a palindrome. Then use DFS.
*/
