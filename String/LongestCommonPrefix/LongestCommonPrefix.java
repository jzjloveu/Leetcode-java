/*
Longest Common Prefix   

Write a function to find the longest common prefix string amongst an array of strings.
*/
import java.util.*;

public class LongestCommonPrefix {
   
    public String longestCommonPrefix(String[] strs) {
        int strslen = strs.length;
        if(strslen == 0) return "";
        if(strslen == 1) return strs[0];
        int minlen = strs[0].length();
        for(String s:strs) minlen = (s.length() < minlen)? s.length():minlen;
        String compref = "";
        for(int i=0;i<minlen;i++){
            char chtmp = strs[0].charAt(i);
            for(int j=0;j<strslen;j++)
                if(strs[j].charAt(i) != chtmp) return compref;
            compref += chtmp;
        } 
        return compref;
    }

    public static void main(String args[]){
        String[] strs = {"abcd","abc","abd","abbc","ab"}; 
        System.out.println((new LongestCommonPrefix()).longestCommonPrefix(strs)); 
    }
}

/*
The idea is scan from the first character, if it is same for all the strings, go to the next character.Return the string until meet the different character.
*/

