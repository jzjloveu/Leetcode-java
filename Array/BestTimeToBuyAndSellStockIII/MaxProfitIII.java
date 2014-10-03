/*
Best Time to Buy and Sell StockIII

Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/
import java.util.*;

public class MaxProfitIII {
   
    public int maxProfit(int[] prices) {
        if(prices.length == 0){ return 0;}
        int maxp = 0, minp = prices[0], end = prices[prices.length-1];
        int[] mp = new int[prices.length];
        for(int i=0;i<prices.length;i++){
            minp = Math.min(minp, prices[i]);
            maxp = Math.max(maxp, prices[i]-minp);  
            mp[i] = maxp;
        }
        maxp = 0;
        for(int i=prices.length-2;i>=0;i--){
            end = Math.max(end,prices[i]);
            maxp = Math.max(maxp,end-prices[i]+mp[i]);
        }
        return maxp;
    }
    public static void main(String args[]){
        int[] A = {13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};

        System.out.println((new MaxProfitIII()).maxProfit(A));
    }
}

/*
The idea is from dynamic programming, the max profit at day i is the max profit before day i + max profit after day i. So there is one loop O(n) to compute the max profit before each each day and another loop O(n) to get the final max profit by compute the max profit after each day reversely and combine the "before day" max profit.

Let's take an example:
prices[ ] =  1,2,4,2,5,7,2,4,9

(1) we compute the forward max profit and save it.  Forward max profit means for each day i, we want to know the max profit we can make no later than this day. Note that we only need to consider 1 transaction:
prices[ ] = 1,2,4,2,5,7,2,4,9
mp[ ]     =  0,1,3,3,4,6,6,6,8

(2) Now what we need is two transactions rather than one, easily we can see from the price list, if we are required exact 2 transactions, we must finish one transaction at some day i, and do the 2nd transaction after that. The max profit is the sum of max profit before day i and after day i. Day i might be every day in the price list, so there is a loop in the code.
Similar to the step(1), but in a reverse order, from the last day -1 to first, we already have the max profit before day i, mp[i], and we can compute the max profit every time for i to n-1 days (n is the number of days), similar to step(1).

e.g.
max_profit = mp[i] + mprofit

                            i
prices[ ] = 1,2,4,2,5,7,2,4,9
mp[ ]     =  0,1,3,3,4,6,6,6,8
max_profit = 6 + (9-4) = 11     (2nd trans. : buy at $4 sell at $9)

                          i   
prices[ ] = 1,2,4,2,5,7,2,4,9
mp[ ]     =  0,1,3,3,4,6,6,6,8
max_profit = 6+ (9-2) = 13    (2nd trans. : buy at $2 sell at $9)

                        i      
prices[ ] = 1,2,4,2,5,7,2,4,9
mp[ ]     =  0,1,3,3,4,6,6,6,8
max_profit = 6+ (9-2) = 13  (max profit after day i not change)

......

                      i                  
prices[ ] = 1,2,4,2,5,7,2,4,9
mp[ ]     =  0,1,3,3,4,6,6,6,8
max_profit = 13  

The final max profit =13

(If you see the case that sell and buy on the same day, this is equal to the case that only 1 transaction. So the "at most 2 transactions" is satisfied)
*/
