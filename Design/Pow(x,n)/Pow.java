/*
Pow(x, n) 

Implement pow(x, n).
*/

public class Pow {
    public double pow(double x, int n) { 
        return (n>=0)? power(x,n) : 1.0/power(x,-n);
    }
    private double power(double x, int n) {
        if(n ==0) {return 1;}
        double half = power(x, n/2);
        return (n%2==0)? half*half : half*half*x;
    }

    public static void main(String args[]){
        double x = 4.0; int n = 3;
        System.out.println((new Pow()).pow(x,n)); 
    }
}

/*
Using binary search. Also need consider when n < 0.
Consider this way:
For compute 2^10:
2^10  = 2^4 * 2^4 *2^2
2^4 = 2^2*2^2
2^2 = 2*2
*/