/*
Longest Valid Parentheses

Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
*/
import java.util.*;

public class LongestValidParentheses {
   
    public int longestValidParentheses(String s) {
        if(s.length() < 2) return 0;
        int last = -1, maxpara = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '(') stack.push(i);
            else{
                if(stack.isEmpty()) last = i; // store the index before first '('
                else{
                    stack.pop();
                    if(stack.isEmpty()) maxpara = Math.max(maxpara,i-last); 
                    else maxpara = Math.max(maxpara,i-stack.peek());
                }
            }
        }
        return maxpara;
    }

    public static void main(String args[]){
        String s = ")()())";
        System.out.println((new LongestValidParentheses()).longestValidParentheses(s));
    }
}


