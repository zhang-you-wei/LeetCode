package yowei.leetCode.dynamicProgramming;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1]
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
 * 但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 */
public class Offer13AreaOfRabot {
    public static int movingCount(int m, int n, int k) {
        boolean[][] dp = new boolean[m][n];
        int count = 0;

        int bottom = m,right = n;
        for(int i = 0;i<n;i++){                 //初始化第一行，同时找到有边界
            int sumK = 0,tmpi = i;
            while(tmpi >= 10 ){
                sumK += tmpi % 10;
                tmpi = tmpi/10;
            }
            sumK += tmpi;
            if(sumK <= k){
                dp[0][i] = true;
                count++;
            }else {
                right = i;
                break;
            }
        }
        for(int i = 1;i<m;i++){             //初始化第一列，同时找到下边界
            int sumK = 0,tmpi = i;
            while(tmpi >= 10 ){
                sumK += tmpi % 10;
                tmpi = tmpi/10;
            }
            sumK += tmpi;
            if(sumK <= k ){
                dp[i][0] = true;
                count++;
            }else {
                bottom = i;
                break;
            }
        }

        for(int i = 1;i<bottom;i++){
            for(int j = 1;j<right;j++){
                int sumK  = 0,tmpi = i,tmpj = j;
                while(tmpi >= 10 ){
                    sumK += tmpi % 10;
                    tmpi = tmpi/10;
                }
                sumK += tmpi;
                while(tmpj >= 10 ){
                    sumK += tmpj % 10;
                    tmpj = tmpj/10;
                }
                sumK += tmpj;

                dp[i][j] = (sumK <= k) && (dp[i-1][j] || dp[i][j-1]);
                if(dp[i][j]) count++;
            }
        }
        return count;

    }

    public static void main(String[] args) {
        int res = movingCount(38, 15, 9);
        System.out.println(res);
    }
}
