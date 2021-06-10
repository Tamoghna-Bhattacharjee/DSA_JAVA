package Dynamic_programming.Buy_And_Sell_Stokes;

//Say you have an array for which the ith element is the price of a given stock on day i.
//Design an algorithm to find the maximum profit.
// You may complete as many transactions as you like
// (i.e., buy one and sell one share of the stock multiple times).
//Note: You may not engage in multiple transactions at the same time
// (i.e., you must sell the stock before you buy again).


public class BuySellStokes_II {

    public static void main(String[] args) {
        int[] prices = {1,2,3,0,1,2};
        System.out.println(maxProfit(prices));
    }
    private static int maxProfit(int[] prices){
        if (prices.length == 0 || prices.length == 1) return 0;
        int[] hold = new int[prices.length];
        int[] sell = new int[prices.length];
        hold[0] = -prices[0];
        sell[0] = 0;
        for (int i = 1; i < prices.length; i++){
            hold[i] = Math.max(hold[i - 1], sell[i - 1] - prices[i]);
            sell[i] = Math.max(sell[i - 1], hold[i - 1] + prices[i]);
        }
        return sell[prices.length - 1];
    }
}
