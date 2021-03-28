package yowei.leetCode.dpThinking.pack.complete;

/**
 * 一组不同面值的货币，每种面值有无限多张，给定一个总额，问总共有多少种找零方案
 */
public class WaysOfChangeCoins {


    public static int recurveWay(int[] changes,int aim){
        if(aim <= 0) return 0;
        if(changes == null || changes.length <=0) return 0;
        return process(changes,0,aim);
    }

    private static int process(int[] changes, int i, int rest) {

        //唯一判断条件，当且仅当零钱全部用完且剩余金额为0时为一种解决方案
        //金额为0但零钱还有没使用过的，可以继续进行后续操作但仍会回到这种状态
        if(i == changes.length){
            return  rest == 0 ? 1 : 0;
        }

        int res = 0;

        for(int zhang = 0; zhang*changes[i] <= rest;zhang++){
            res += process(changes,i+1,rest - zhang*changes[i]);
        }

        return res;
    }


    public static int dpWay(int[] changes,int aim){
        int len = changes.length;
        int[][] dp = new int[len + 1][aim + 1];

        dp[len][0] = 1;         //零钱全部用完且剩余金额为0时表示一种找零方案

        for(int i = len - 1;i>=0;i--){
            for(int rest=0;rest<=aim ;rest++){


                for(int zhang = 0; zhang*changes[i] <= rest;zhang++){
                    dp[i][rest] += dp[i+1][rest - zhang*changes[i]];
                }
            }
        }
        return dp[0][aim];
    }

    //完全背包一维数组解法
    public static int dpWay2(int[] changes,int aim){
        int len = changes.length;
        int[] dp = new int[aim + 1];
        dp[0] = 1;

        for (int change : changes) {
            for (int j = change; j <= aim; j++) {
                dp[j] += dp[j - change];
            }
        }
        return dp[aim];
    }

    public static void main(String[] args) {
        int[] changes = {2,3,7};
        int res1 = recurveWay(changes, 16);
        int res2 = dpWay(changes, 16);
        int res3 = dpWay2(changes, 16);
        System.out.println(res1);
//        System.out.println(res2);
        System.out.println(res3);
    }
}
