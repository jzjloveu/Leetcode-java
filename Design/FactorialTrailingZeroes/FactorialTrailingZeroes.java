/*
Factorial Trailing Zeroes

Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.
*/

public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int count = 0;
        while(n >= 5) { n /= 5; count += n; }
        return count;
    }

    public static void main(String args[]){
        int n = 32;
        System.out.println((new FactorialTrailingZeroes()).trailingZeroes(n)); 
    }
}

/*
It is a math problem. see http://en.wikipedia.org/wiki/Trailing_zero
Formula: 5^k+1 > n
e.g.
5^3 > 32, 32! = 263130836933693530167218012160000000 ends in
|_32/5_| + |_32/5^2_| = 6 + 1 = 7 zeros. If n < 5, the inequality is satisfied by k = 0. 
*/