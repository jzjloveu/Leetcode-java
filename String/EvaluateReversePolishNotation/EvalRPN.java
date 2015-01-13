/*
Evaluate Reverse Polish Notation

Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression. 

Some examples:

 ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
*/
import java.util.Stack;
public class EvalRPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> nums = new Stack<Integer>();
        int result=0,a,b;
        for(int i=0;i<tokens.length;i++){
            try{
                a = Integer.parseInt(tokens[i]);
                nums.push(a);
                if(tokens.length < 2)
                    return a;		
    	    }
    	    catch(NumberFormatException e){
                a = nums.pop();
                b = nums.pop();
                switch(tokens[i]){
                    case "+":
                        result = b + a; break;
                    case "-":
                        result = b - a; break;
                    case "*":
                        result = b * a; break;
                    case "/":
                        result = b / a; break;
                }
                nums.push(result);
    	    }
        }
        return result;
    }
   
    public static void main(String args[]){
        String[] str1 = {"2", "1", "+", "3", "*"}; //9
        String[] str2 = {"4", "13", "5", "/", "+"}; //6
        String[] str3 = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"}; // 22
        EvalRPN sol = new EvalRPN();
        System.out.println(sol.evalRPN(str1));
        System.out.println(sol.evalRPN(str2));
        System.out.println(sol.evalRPN(str3));
    }
}
