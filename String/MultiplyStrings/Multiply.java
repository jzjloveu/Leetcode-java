/*
Multiply Strings 

Given two numbers represented as strings, return multiplication of the numbers as a string.

Note: The numbers can be arbitrarily large and are non-negative.
*/
import java.util.*;
//import java.lang.*;

public class Multiply {
   
    public String multiply(String num1, String num2) {
        if(num1.isEmpty() || num2.isEmpty()) return "0";
        num1 = (new StringBuilder(num1)).reverse().toString();
        num2 = (new StringBuilder(num2)).reverse().toString();
        char[] result = new char[num1.length()+num2.length()];
        Arrays.fill(result, '0');            
        for(int i=0;i<num1.length();i++){
            int digi1 = num1.charAt(i) - '0'; 
            int carry = 0;
            for(int j=0;j<num2.length();j++){
                int digi2 = num2.charAt(j) - '0';
                int exist = result[i+j] - '0';
                result[i+j] = (char)((digi1*digi2+carry+exist)%10+'0');
                carry = (digi1*digi2+carry+exist) / 10;
            }
            if(carry > 0) result[i+num2.length()] = (char)(carry + '0');
        }
        String total = new String(result);
        return(new StringBuilder(total)).reverse().toString().replaceAll("^0+(?!$)","");
    }

    public static void main(String args[]){
        String num1 = "1";//"123";
        String num2 = "10";//"456";
        System.out.println((new Multiply()).multiply(num1,num2));
    }
}

/*
Straight forward idea. Just like the way we multiply numbers. Don't forget considering the carry and be careful. e.g.
exit()
  123*456,

what we usually do is:


      123
*     456
-----------

      738
     615
+   492
-----------
    56088
thus, 123*456 = 56088.

In the same way, the algorithm is:
A*B
(1)For each element B[i]
    Compute tmp = B[i]*A
    Add tmp to the previous result, note the start position. res = res"+"tmp
(2)Return result.

To be specific,
(1) char2int,     int(char-'0');
(2) int2char,     char(int+'0')
(3) Don't forget the carry in each add or multiply operation.
(4) Don't forget the carry after last operation. e.g.  82+33 = 115.
(5) Be careful with the string order and the number order.
*/

