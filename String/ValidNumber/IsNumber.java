/*
Valid Number

Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
*/


public class IsNumber {
   
    public boolean isNumber(String s) {
        s = s.trim();
        int slen = s.length();
        if(slen==0) return false;
        int i=0;
        boolean e =false; // check if 'e' exists
        boolean dot=false; // check if '.' exists
        boolean digit =false;
         
        while (i<slen-1){
            if (i==0){ // a number can start with +, -, .
                if (s.charAt(i)<'0' || s.charAt(i)>'9'){ // if is 0-9 continue
                    if (s.charAt(i)=='+' || s.charAt(i)=='-' || s.charAt(i)=='.'){
                        if (slen==1){return false;} // only +, - , . is not a number
                        if (s.charAt(i)=='.'){dot=true;}
                    }
                    else {return false;}
                }else{digit=true;}
                i++;continue;
            }
            if (i>0){
                switch (s.charAt(i)){
                    case 'e': // e cannot follow +,-
                        if ( e==false && s.charAt(i-1)!='+' && s.charAt(i-1)!='-' && digit && i!=slen-1) {
                            e = true;
                        }else{
                            return false;
                        }
                        break;
                   case 'E': // e cannot follow +,-
                        if ( e==false && s.charAt(i-1)!='+' && s.charAt(i-1)!='-' && digit && i!=slen-1) {
                            e = true;
                        }else{
                            return false;
                        }
                        break;
                   case '+': // + can only occur before e
                        if (s.charAt(i-1)=='e' || s.charAt(i-1)=='E'){}else{return false;}
                        break;
                   case '-': // - can only occur before e
                        if (s.charAt(i-1)=='e' || s.charAt(i-1)=='E'){}else{return false;}
                        break;
                   case '.': // . can only occur once and cannot occure after e
                        if (dot==false && e==false){dot=true;}else{return false;}
                        break;
                   default:  // only 0-9 can be valid numbers
                        if (s.charAt(i)<'0'||s.charAt(i)>'9'){return false;}
                        else{digit = true;}
                        break;
            } 
                i++;continue;
            }
        }
         
        //last digit can only be 0-9, or ., when it is . there is no . and e before
        if (s.charAt(slen-1)>='0' && s.charAt(slen-1)<='9'){return true;}
        if (s.charAt(slen-1)=='.' && slen>1 && !dot && !e && s.charAt(slen-2)>='0' && s.charAt(slen-2)<='9') {return true;}        
        return false;
    }

    public static void main(String args[]){
        String[] str = {"0",// true
                        " -0.1 ", // true
                        "abc", // false
                        "1 a", // false
                        "+2e10", // true
                        ".", // false
                        "3."}; // true
        for(String s:str) //System.out.println(s.charAt(0)=='.');
            System.out.println((new IsNumber()).isNumber(s));
    }
}

/*
The problem is about Deterministic finite automaton(DFA).

But this solution is not using DFA.
Here are some considerations:
(1)  " . ":   "1."  true,   "1.e2" true, ".3" true.
(2) " e ":   ".e1" false,  "1e.1" false, "1e1.1" false, "2.3e" false.
(3) "+/-":  "+1.e+5" true.
*/
