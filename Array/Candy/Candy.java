/*
Candy

There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?
*/
import java.util.*;

public class Candy {
    public int candy(int[] ratings) {
        int[] cand = new int[ratings.length];
        Arrays.fill(cand, 1);
        for(int i=0;i<ratings.length-1;i++)
            if(ratings[i+1]>ratings[i] && cand[i+1]<=cand[i])
                cand[i+1] = cand[i] + 1;
        for(int i=ratings.length-1;i>0;i--)
            if(ratings[i-1]>ratings[i] && cand[i-1]<=cand[i])
                cand[i-1] = cand[i] + 1;
        int sum = 0;
        for(int i:cand) sum += i;
        return sum;
    }
    
    public static void main(String args[]){
        int[] ratings = {1,2,2}; 
        System.out.println((new Candy()).candy(ratings));
        
    }
}

/*
Scan the rating array from left to right and then from right to left. 
In every scan just consider the rising order, assign +1 candies to the 
rising position.
*/