package Dynamic_programming.Buy_And_Sell_Stokes;

//Say you have an array for which the ith element is the price of a given stock on day i.
//Design an algorithm to find the maximum profit. You may complete as many transactions as you like
// (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
//
//        You may not engage in multiple transactions at the same time
//        (ie, you must sell the stock before you buy again).
//        After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)

//        Example:
//        Input: [1,2,3,0,2]
//        Output: 3
//        Explanation: transactions = [buy, sell, cooldown, buy, sell]


public class BuySellStokes_Cooling {
    public static void main(String[] args) {
        int[] prices = {1,2,3,0,1,2};
        System.out.println(max_Profit(prices));
    }
    private static int max_Profit(int[] prices){
        int[] hold = new int[prices.length];
        int[] sell = new int[prices.length];
        int[] rest = new int[prices.length];

        hold[0] = -prices[0];
        sell[0] = Integer.MIN_VALUE;
        rest[0] = 0;

        for (int i = 1; i < prices.length; i++){
            hold[i] = Math.max(hold[i - 1], rest[i - 1] - prices[i]);
            sell[i] = prices[i] + hold[i - 1];
            rest[i] = Math.max(sell[i - 1], rest[i - 1]);
        }
        return Math.max(sell[prices.length - 1], rest[prices.length - 1]);
    }
}
