/*
Divide Two Integers

Divide two integers without using multiplication, division and mod operator.

If it is overflow, return MAX_INT.
*/

public class DivideTwoIntegers1 {
    public int divide(int dividend, int divisor) {
        long a=Math.abs((long)dividend);
        long b=Math.abs((long)divisor);
        long result=0L;
        while (a>=b){
            long c=b; int i=0;
            while(c<=a){
                a=a-c; c=c<<1;
                result+=1<<i;
                i++;
            }
        }
        if (dividend<0&&divisor>0||dividend>0&&divisor<0)
            result=-result;
        return result<Integer.MAX_VALUE?(int)result:Integer.MAX_VALUE;
    }

    public static void main(String args[]){
        int dd = 15, ds = 3;
        System.out.println((new DivideTwoIntegers1()).divide(dd,ds)); 
    }
}
