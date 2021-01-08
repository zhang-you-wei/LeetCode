package yowei.leetCode.dynamicProgramming;

import java.util.Arrays;

public class No322CoinChange {
    /*public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,-1);
        int length = coins.length;
        for(int i = 0;i< length;i++){
            if(coins[i] > amount) continue;
            dp[coins[i]] = 1;
        }

        for(int i = 1;i<=amount;i++){
            if(dp[i] == 1) continue;
            int curmax = Integer.MAX_VALUE;
            boolean flag = true;
            for(int j = 0;j<length;j++){
                if(i < coins[j]) continue;
                if(dp[i-coins[j]] == -1) continue;
                curmax = Math.min(curmax, 1+dp[i-coins[j]]);
                flag = false;
            }
            if(flag) dp[i] = -1;
            else dp[i] = curmax;
        }
        return dp[amount];
    }*/

    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }


    public static void main(String[] args) {
        No322CoinChange cc = new No322CoinChange();
        int[] aaa = {474,83,404,3};
        int b = 264;
        int i = cc.coinChange(aaa, b);
        System.out.println(i);
    }
}
