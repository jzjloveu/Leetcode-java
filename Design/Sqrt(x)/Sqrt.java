/*
Sqrt(x) 

Implement int sqrt(int x).

Compute and return the square root of x.
*/

public class Sqrt {
    public int sqrt(int x) {  
        int left = 0, mid = 0, right = 46340; // is sqrt(MAX_INT)
        while(left <= right){
            mid = (left+right) / 2;
            if(mid*mid <= x && x < (mid+1)*(mid+1)) { break; }
            else if (mid*mid > x) { right = mid - 1; }
            else { left = mid + 1; }
        }
        return mid;
    }

    public static void main(String args[]){
        int x = 9;
        System.out.println((new Sqrt()).sqrt(x)); 
    }
}

/*
Using binary search.
*/