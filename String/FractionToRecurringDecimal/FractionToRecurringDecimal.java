/*
Fraction to Recurring Decimal

Given two integers representing the numerator and denominator of a fraction, 
return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

For example,

Given numerator = 1, denominator = 2, return "0.5".
Given numerator = 2, denominator = 1, return "2".
Given numerator = 2, denominator = 3, return "0.(6)".
*/
import java.util.HashMap;

public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        if (denominator == 0) return "";
        String ans = "";
        if ((numerator<0) ^ (denominator<0)) ans += "-";
        long num = numerator, den = denominator; 
        num = Math.abs(num); den = Math.abs(den);
        long res = num / den; ans += "" + res;
        long rem = (num % den) * 10; 
        if (rem == 0) return ans;
        ans += ".";
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        while (rem != 0) {
            if (map.containsKey(rem)) {
                int beg = map.get(rem);  
                ans = ans.substring(0,beg)+"("+ans.substring(beg,ans.length())+")"; 
                return ans; 
            }
            map.put(rem, ans.length()); 
            res = rem / den;
            ans += "" + res; 
            rem = (rem % den) * 10; 
        }
        return ans;
    }

    public static void main(String args[]){
        int a=1,b=6; //a=455, b=38;
        System.out.println((new FractionToRecurringDecimal()).fractionToDecimal(a,b));
    }
}

/*
The key insight here is to notice that once the remainder starts repeating, 
so does the divided result.

You will need a hash table that maps from the remainder to its position of the fractional part. 
Once you found a repeating remainder, you may enclose the reoccurring fractional part with 
parentheses by consulting the position from the table.

The remainder could be zero while doing the division. That means there is no repeating fractional 
part and you should stop right away.

Just like the question Divide Two Integers, be wary of edge case such as negative fractions and 
nasty extreme case such as -2147483648 / -1.

e.g.
    0.16 
   ______ 
6 ) 1.00
    0
    _____ 
    1 0       <-- Remainder=1, mark 1 as seen at position=0.
    - 6
    _____
      40      <-- Remainder=4, mark 4 as seen at position=1.
    - 36 
    _____
       4      <-- Remainder=4 was seen before at position=1, 
                  so the fractional part which is 16 starts repeating at position=1 => 1(6).
*/