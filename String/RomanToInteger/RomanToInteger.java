/*
Roman to Integer 

Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
*/


public class RomanToInteger {
   
    public int romanToInt(String s) {
        String roman = "IVXLCDM";
        int[] val = {1,5,10,50,100,500,1000};
        int result = 0;
        for(int i=0;i<s.length();i++) {
            if(i>0 && val[roman.indexOf(s.charAt(i))]>val[roman.indexOf(s.charAt(i-1))])
                result += val[roman.indexOf(s.charAt(i))]-val[roman.indexOf(s.charAt(i-1))]*2;
            else  result += val[roman.indexOf(s.charAt(i))]; 
        }
        return result;
    }

    public static void main(String args[]){
        String str = "IX";
        System.out.println((new RomanToInteger()).romanToInt(str));
    }
}

/*
Roman number rules(see wiki):
Forms:
I   1
V   5
X   10
L   50
C   100
D   500
M   1000

Idea: 
scan string from front to end; if current value greater than previous, then
current subtracts previous, such as IV = V - I = 5-1 = 4;
otherwise, accumulate the current value to result.
*/