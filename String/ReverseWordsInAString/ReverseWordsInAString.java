/*
Reverse Words in a String 

Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".
*/

public class ReverseWordsInAString {

    public String reverseWords(String s) {
        if(s == null) return s;
        String[] str = s.trim().split("\\s+");
        StringBuilder builder = new StringBuilder();
        for(int i = str.length-1; i>=0; i--){
            builder.append(str[i]);
            if(i > 0) builder.append(" ");
        }
        return builder.toString();
    }

    public static void main(String args[]){
        ReverseWordsInAString sol = new ReverseWordsInAString();
        String str = sol.reverseWords("the sky is blue");   
        System.out.println(str);
    }
}
