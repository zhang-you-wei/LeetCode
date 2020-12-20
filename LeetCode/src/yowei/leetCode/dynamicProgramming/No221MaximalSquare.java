package yowei.leetCode.dynamicProgramming;

import java.util.PriorityQueue;

/**
 * 以某个点为右下角的正方形的最大面积等于其上，左，左上三个点为右下角正方形面积最小值加1（当该点为1时）
 */
public class No221MaximalSquare {
    public int maximalSquare(char[][] matrix) {

        //创建二维数组
        int[][] dp = new int[matrix.length][matrix[0].length];

        //初始化边缘数据
        for(int i = 0;i<matrix[0].length;i++){
            dp[0][i] = matrix[0][i] - '0';
        }

        for(int j = 0;j<matrix.length;j++){
            dp[j][0] = matrix[j][0] - '0';
        }

        //动态规划
        int max = 0;
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                if(i-1 >=0 && j-1>=0 ){
                    if(matrix[i][j] == '1'){
                        dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i-1][j-1]),dp[i][j-1]) + 1;
                    }else
                        dp[i][j] = 0;
                }
                max = Math.max(max,dp[i][j]);

            }
        }
        return max*max;
    }
}
