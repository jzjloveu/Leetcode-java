/*
Generate Parentheses 

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
*/
import java.util.*;

public class GenerateParenthesis {
   
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        if(n == 0) return result;
        generate("",0,0,n,result);
        return result;
    }
    
    private static void generate(String s, int lnum, int rnum, int n, List<String> res){
        if(n < 1) return;
        if(lnum == n && rnum == n) res.add(s);
        else{
            if(lnum <= n) generate(s+"(",lnum+1,rnum,n,res);
            if(rnum < lnum && rnum <= n) generate(s+")",lnum,rnum+1,n,res);
        }
    }

    private static void printArrList(List<String> arr){
        System.out.print("[");
        for(int i=0;i<arr.size();i++){
            if(i<arr.size()-1) System.out.print(arr.get(i)+",");
            else System.out.print(arr.get(i));
        }
        System.out.print("]\n"); 
    }

    public static void main(String args[]){
       printArrList((new GenerateParenthesis()).generateParenthesis(3)); 
    }
}

/*
The classic question from the Cracking the Code Interview. DFS is enough. Note that it is wrong when the number of ')' is more than '(' in the current string. e.g. ()()).
*/

