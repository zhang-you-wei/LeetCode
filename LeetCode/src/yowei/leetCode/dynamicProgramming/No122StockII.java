package yowei.leetCode.dynamicProgramming;

/**
 * 给定一个数组，它的第i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class No122StockII {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len < 2) return 0;

        int[][] dp = new int[len][2];
        //dp[i][0]表示第i天时不持有股票，所拥有的现金数
        //dp[i][1]表示第i天时持有股票，所拥有的现金数
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for(int i = 1;i<len;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] - prices[i]);
        }
        return dp[len - 1][0];
    }

}
