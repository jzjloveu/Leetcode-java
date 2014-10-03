/*
String to Integer (atoi) 

Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

spoilers alert... click to show requirements for atoi.

Requirements for atoi:
The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
*/


public class Atoi {
   
    public int atoi(String str) {
        str = str.trim();
        String numstr = "";
        for(int i=0;i<str.length();i++){
        	if('0'<=str.charAt(i) && str.charAt(i)<='9' || (i==0 && (str.charAt(i)=='+'||str.charAt(i)=='-'))) numstr += str.charAt(i);
            else break;
        }
        if(numstr.equals("+") || numstr.equals("-") || numstr.isEmpty()){ return 0;}
   		else{
			long value = Long.parseLong(numstr);
        	if(Integer.MIN_VALUE <= value && value <= Integer.MAX_VALUE) return (int)value;
            else if(value > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            else return Integer.MIN_VALUE;
		}
    }

    public static void main(String args[]){
        String str = "+-2";//"2147483648";
        System.out.println((new Atoi()).atoi(str));
    }
}

