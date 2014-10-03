/*
Best Time to Buy and Sell Stock 

Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
*/
import java.util.*;

public class MaxProfit {
   
    public int maxProfit(int[] prices) {
        if(prices.length == 0){ return 0;}
        int maxp = 0, minp = prices[0];
        for(int currp:prices){
            minp = Math.min(minp, currp);
            maxp = Math.max(maxp, currp-minp);  
        }
        return maxp;
    }
    public static void main(String args[]){
        int[] A = {13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};

        System.out.println((new MaxProfit()).maxProfit(A));
    }
}

/*
Scan the array from left to right, update the max-profit by comparing max-profit so far with current price subtracts prioves lowest price.
*/
