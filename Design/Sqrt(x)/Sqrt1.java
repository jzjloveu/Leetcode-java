/*
Sqrt(x) 

Implement int sqrt(int x).

Compute and return the square root of x.
*/

public class Sqrt1 {
    public int sqrt(int x) {  
        if (x == 0) return 0;
        double last = 0;
        double res = 1;
        while (res != last){
            last = res;
            res = (res + x / res) / 2; 
        }
        return (int)res;
    }

    public static void main(String args[]){
        int x = 9;
        System.out.println((new Sqrt1()).sqrt(x)); 
    }
}

/*
Using Newton's method: a = (a + x / a) / 2
*/