/*
Letter Combinations of a Phone Number 

Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.
Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
*/
import java.util.*;
import stringListUtil.*;

public class LetterCombinations {
   
    public List<String> letterCombinations(String digits) {
        Map<String,String> nums = new HashMap<String,String>();
        nums.put("0"," ");nums.put("1","");nums.put("2","abc");nums.put("3","def");
        nums.put("4","ghi");nums.put("5","jkl");nums.put("6","mno");nums.put("7","pqrs");
        nums.put("8","tuv");nums.put("9","wxyz");
        List<String> result = new ArrayList<String>();
        dfsgen(digits,"",nums,result);
        return result;
    }

    private static void dfsgen(String digits,String res,Map<String,
        String> nums,List<String> result){
        if(digits.isEmpty()) result.add(res);
        else{
            char[] chars = nums.get(digits.substring(0,1)).toCharArray();
            for(char c:chars)
                dfsgen(digits.substring(1),res+c,nums,result);
        }
    }

    public static void main(String args[]){
        String S = "23" ;
        StringListUtil.printList((new LetterCombinations()).letterCombinations(S)); 
    }
}

/*
This is a simple problem, we can use the DFS to solve it.
*/

