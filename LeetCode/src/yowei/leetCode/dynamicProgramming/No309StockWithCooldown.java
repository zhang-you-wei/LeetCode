package yowei.leetCode.dynamicProgramming;

/**
 * 带有后效性的动态规划，通过增加一维来消除后效性
 */
public class No309StockWithCooldown {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        int[][] dp = new int[len][3];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;

        // dp[i][0]: 手上不持有股票，并且今天没有卖出股票，拥有的现金数，可以由dp[i-1][0]或dp[i-1][2]转移得到
        // dp[i][1]: 手上持有股票时，拥有的现金数，可以由dp[i-1][1]或dp[i-1][0]转移得到
        // dp[i][2]: 手上不持有股票，并且今天卖出了股票，拥有的现金数，只能由dp[i-1][1]转移得到
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = dp[i - 1][1] + prices[i];
        }
        //最后一天肯定不持有股票钱多
        return Math.max(dp[len - 1][0], dp[len - 1][2]);
    }
}
