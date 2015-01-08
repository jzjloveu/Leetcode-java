/*
Valid Parentheses 

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid 
but "(]" and "([)]" are not.
*/
import java.util.*;

public class ValidParentheses {
   
    public boolean isValid(String s) {
        if(s.isEmpty()) return true;
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{')
                stack.push(s.charAt(i));
            else{
                if(stack.empty()) return false;
                if(s.charAt(i)==')' && stack.peek()!='(') return false;
                if(s.charAt(i)==']' && stack.peek()!='[') return false;
                if(s.charAt(i)=='}' && stack.peek()!='{') return false;
                stack.pop();
            }
        }
        return stack.empty();
    }

    public static void main(String args[]){
        String S = "()[]{}" ;// "([)]"; 
        System.out.println((new ValidParentheses()).isValid(S)); 
    }
}

/*
Use a stack to store the chars, scan from the 1st to the last char in string s.
( [ { are free to push in the stack.
When meets ) if stack top is (, then pop (.
When meets ] if stack top is [, then pop [.
When meets } if stack top is {, then pop {.
Otherwise return false.
*/

