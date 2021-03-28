package yowei.leetCode.dpThinking.pack.twodimension;

/*
    对于每件物品，具有两种不同的空间耗费，选择这件物品必须同时付出这两种代价。对于每种代价都有一个可付出的最大值
    （背包容量）。问怎样选择物品可以得到最大的价值。
    一种隐含的方式：最多只能取U件物品。作为第二维限制
 */
public class TwoDimension {
    public static int twoDimenPack(int[] value,int[] weight,int packSize,int count) {
        int len = value.length;
        int[][] dp = new int[packSize + 1][count + 1];

        for(int i = 0;i<len;i++){

            for(int w = packSize; w >= weight[i] ; w--){

                for(int u = count; u>= 1; u--){
                    dp[w][u] = Math.max(dp[w][u],dp[w-weight[i]][u-1] + value[i]);
                }
            }
        }
        return dp[packSize][count];
    }


    public static void main(String[] args) {
        int[] weight = {2,3,5,6,7,8};
        int[] value = {5,8,11,14,16,19};
        //int[] times = {1,8,10000,1};
        int res = twoDimenPack(value, weight, 20, 4);
        System.out.println(res);
    }
}
