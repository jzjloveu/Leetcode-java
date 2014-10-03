/*
Reverse Integer

Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321
*/
import java.util.*;

public class ReverseInteger {
   
    public int reverse(int x) {
        String numstr = "" + x;
        if(x >= 0) { 
             numstr = new StringBuilder(numstr).reverse().toString(); 
             return Integer.parseInt(numstr);
        }
        else{
            numstr = numstr.substring(0,1)+
               (new StringBuilder(numstr.substring(1)).reverse().toString());
            return Integer.parseInt(numstr);
        }
    }

    public static void main(String args[]){
        int x1 = 123, x2 = -123;
        ReverseInteger sol = new ReverseInteger();
        System.out.println(sol.reverse(x1));
        System.out.println(sol.reverse(x2));
    }
}

