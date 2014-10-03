/*
Reverse Words in a String 

Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".
*/


public class ReverseWords {

    public String reverseWords(String s) {
/*
        String[] str = s.split("\\s+");
        //java.util.Collections.reverse(java.util.Arrays.asList(str));
	for(int i=0;i<str.length/2;i++){
	    String temp = str[i];
            str[i] = str[str.length-i-1];
            str[str.length-i-1] = temp;
	}
        StringBuffer builder = new StringBuffer();
        for (int i = 0; i < str.length; i++) {
            builder.append(str[i]+" ");
        }
        return builder.toString().trim();
*/
	if(s == null)
	  return s;

        String[] str = s.trim().split("\\s+");
        StringBuilder builder = new StringBuilder();
        for(int i = str.length-1; i>=0; i--){
            builder.append(str[i]);
            if(i>0)
              builder.append(" ");
        }
	return builder.toString();
    }

    public static void main(String args[]){
        ReverseWords sol = new ReverseWords();
	String str = sol.reverseWords("the sky is blue");
	System.out.println(str);
    }
}
