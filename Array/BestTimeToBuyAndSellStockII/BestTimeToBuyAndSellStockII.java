/*
Best Time to Buy and Sell StockII

Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions 
as you like (ie, buy one and sell one share of the stock multiple times). However, you 
may not engage in multiple transactions at the same time (ie, you must sell the stock 
before you buy again).
*/
import java.util.*;

public class BestTimeToBuyAndSellStockII {
   
    public int maxProfit(int[] prices) {
        if(prices.length == 0){ return 0;}
        int maxp = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i] > prices[i-1])
                maxp += prices[i] - prices[i-1];   
        }
        return maxp;
    }
    public static void main(String args[]){
        int[] A = {13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};

        System.out.println((new BestTimeToBuyAndSellStockII()).maxProfit(A));
    }
}

