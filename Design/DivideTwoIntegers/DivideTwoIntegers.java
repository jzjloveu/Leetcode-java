/*
Divide Two Integers

Divide two integers without using multiplication, division and mod operator.

If it is overflow, return MAX_INT.
*/

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        int sign = 1; long quot = 0L;
        long dd = Math.abs((long)dividend);
        long ds = Math.abs((long)divisor);
        if(dividend < 0) { sign = -sign; }
        if(divisor < 0) { sign = -sign; }
        while(dd >= ds) {
            int k = 0; long tmp = ds;
            while(dd >= tmp) {
                quot += 1 << k;
                dd -= tmp;
                tmp <<= 1;
                k++;
            }
        }
        quot = (sign > 0)? quot : -quot;
        return quot<Integer.MAX_VALUE?(int)quot:Integer.MAX_VALUE;
    }

    public static void main(String args[]){
        int dd = 15, ds = 3;
        System.out.println((new DivideTwoIntegers()).divide(dd,ds)); 
    }
}

/*
Using bit operator.
Note that is the dividend < divisor as they all integer and the return 
value is also integer, the return value would be 0.  (e.g. 1/4=0)

Without using the *, /, and % operator, what we can use is +,-, and <<, >> .
<< 1 is to multiply 2,e.g. 2<<1  = 4;
>> 1 is to divide 2, e.g.   8>>1 = 4;

use << to speed up.
1. Keep  multiply 2 (<<1) to the divisor, until it is greater than the dividend. 
Store the times of shift operation.
2. if dividend > divisor, then dividend = dividend - divisor*2(<<1). 
Until dividend < original divisor. Store the result.
3. Output the result.

e.g. 15/3
3*2*2*2=24>15, 
15 - 24/2 = 3 - 12/2/2=0 < 3, end.
res = 4,        res = 4+1,   res=5
*/