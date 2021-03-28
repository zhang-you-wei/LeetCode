package yowei.leetCode.dpThinking.pack.zeroOne;

public class ZeroOnePack {
//    public int zeroOnePakc(int[] value,int[] weight,int packSize){
//        int[] dp = new int[packSize + 1];
//        for (int i = 0; i <= packSize; i++) {
//            for(int j=1;j< value.length;j++){
//                int c = weight[j];
//                if(c <= i){
//                    dp[i] = Math.max(dp[i],dp[i-c] + value[j]);
//                }
//            }
//        }
//        return dp[packSize];
//    }


    //二维数组解法
    //dp[i][v]表示前i件物品放入容量为v的背包的最大价值
    public int zeroOnePack1(int[] value,int[] weight,int packSize){
        int len = value.length;
        int[][] dp = new int[len + 1][packSize + 1];
        for(int i = 0;i<len;i++){
            for(int v = 1;v<=packSize;v++){
                if(v - weight[i] >=0 ){                 //i位置的重量小于背包总重量

                    //注意数组下标，dp[i]表示前i个物品，weight[i]表示第i+1件物品重量。
                    dp[i+1][v] = Math.max(dp[i][v],dp[i][v - weight[i]] + value[i]);
                }

                //i位置的重量大于剩余背包总重量会怎样？？二维数组表示时此步不可省
                else{
                    dp[i+1][v] = dp[i][v];
                }
            }
        }
        return dp[len][packSize];
    }

    //优化数组空间，使用一个一维数组
    //dp表示前i件物品放入容量为v的背包的最大价值
    public int zeroOnePack2(int[] value,int[] weight,int packSize){
        int[] dp = new int[packSize + 1];
        int len = value.length;
        for (int i = 0; i < len; i++) {
            for (int j = packSize; j >=0; j--) {            //容量必须从高到低，因为会用到低位的数据，如果先更新低位，使用的就是本层的数据
                if(j >= weight[i]){
                    dp[j] = Math.max(dp[j],dp[j-weight[i]] + value[i]);     //第i件物品取或者不取，选两者中较大的
                }

                //i位置的重量大于剩余背包总重量会怎样？
                //不会有影响，因为即使跳过数组默认继承上一行数据
            }
        }
        return dp[packSize];
    }

    public static void main(String[] args) {
        ZeroOnePack zop = new ZeroOnePack();
        int[] value = {6,9,8,5,7,5,8,9,11,4,6,7};
        int[] weight = {3,5,4,2,4,5,8,4,4,8,5,7,3};
        int res = zop.zeroOnePack2(value, weight, 25);
        int res2 = zop.zeroOnePack1(value, weight, 25);
        System.out.println(res);
        System.out.println(res2);
    }
}
