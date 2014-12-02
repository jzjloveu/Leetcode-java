/*
Climbing Stairs

You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways 
can you climb to the top?
*/

public class ClimbingStairs {
    public int climbStairs(int n) {
        if(n < 3) return n;
        int f1 = 1, f2 = 2;
        for(int i=3;i<=n;i++){
            f2 = f2 + f1;
            f1 = f2 - f1;
        }
        return f2;
    }

    public static void main(String args[]){
        int n = 5;
        System.out.println((new ClimbingStairs()).climbStairs(n)); 
    }
}

/*
The idea is a Fibonacci number. f(n) = f(n-1) + f(n-2).
The nth stairs is from either n-1th the stair or the n-2th stair. 
*/