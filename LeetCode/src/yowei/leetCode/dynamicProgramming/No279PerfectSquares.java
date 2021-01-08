package yowei.leetCode.dynamicProgramming;

import java.util.Arrays;

/**
 * 完全背包问题：包为n，东西为各个平方数，将n填满且使用的平方数最少
 * 动态规划：记录每个小于n的数的最少组成数
 */
public class No279PerfectSquares {
    public int numSquares(int n) {
        //初始化dp数组
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;

        //初始化平方数组
        int max_sqrt = (int)Math.sqrt(n) + 1;
        int[] square_number = new int[max_sqrt];
        for(int i =0; i < max_sqrt;i++){
            square_number[i] = i*i;
        }

        //调用循环，不用按照两数相加和为n挨个比较，只需要观察各个平方数和剩余部分，并且一个平方数用1直接替代
        for(int m = 1;m < n+1;m++){
            for(int k = 1;k < max_sqrt;k++){
                if( m < square_number[k]) break;
                dp[m] = Math.min(1+dp[m - square_number[k]],dp[m]);
            }
        }
        return dp[n];
    }
}
