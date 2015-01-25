/*
Word Break II 

Given a string s and a dictionary of words dict, add spaces in s to construct 
a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"]. 
*/
import java.util.*;

public class WordBreakII {
    public List<String> wordBreakII(String s, Set<String> dict) {
        ArrayList words[] = new ArrayList[s.length()];
        for(int i=s.length()-1; i>=0; i--){
            words[i] = new ArrayList<String>();
            for(int j=i+1; j<=s.length(); j++){
                if(dict.contains(s.substring(i,j))){
                    if(j==s.length()) words[i].add(s.substring(i,j));
                    else 
                        for(int k=0; k<words[j].size(); k++)
                            words[i].add(s.substring(i,j)+" "+words[j].get(k)); 
                }
            }
        }
        return (ArrayList<String>)words[0];
    }

    public static void main(String args[]){
        String str = "catsanddog";
        Set<String> dict = new HashSet<String>();
        dict.add("cat");dict.add("cats");dict.add("and");dict.add("sand");dict.add("dog");
        WordBreakII sol = new WordBreakII();
        List<String> slist = sol.wordBreakII(str,dict);
        for(int i=0;i<slist.size();i++)
		System.out.println(slist.get(i));
    }
}
/*
Using dynamic programming, we keep in the ith element of an array all the 
posible sentences from the ith letter.
*/