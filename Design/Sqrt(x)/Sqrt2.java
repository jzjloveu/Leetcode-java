/*
Sqrt(x) 

Implement int sqrt(int x).

Compute and return the square root of x.
*/

public class Sqrt2 {
    public int sqrt(int x) {  
        long i = 0;
        long j = x / 2 + 1;
        while (i <= j) {
            long mid = (i + j) / 2;
            if (mid * mid == x) return (int)mid;
            if (mid * mid < x) i = mid + 1;
            else j = mid - 1;
        }
        return (int)j;
    }

    public static void main(String args[]){
        int x = 9;
        System.out.println((new Sqrt2()).sqrt(x)); 
    }
}

/*
Using binary search.
*/