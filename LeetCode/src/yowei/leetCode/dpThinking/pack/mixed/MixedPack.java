package yowei.leetCode.dpThinking.pack.mixed;

public class MixedPack {
    //混合背包，有的物品只可以取一次（01背包），有的物品可以取无限次（完全背包），有的物品可以取的次数有一个上限（多重背包）

    public static int mixedPack(int[] value,int[] weight,int[] times,int packSize){
        int len = value.length;
        int[] dp = new int[packSize + 1];
        for(int i = 0;i<len;i++){
            if(times[i] == 1){
                //0-1
                zeroOne(dp,weight[i],value[i],packSize );
            }else if(times[i] > 1000){
                //完全
                complete(dp,weight[i],value[i],packSize );
            }else {
                if(weight[i] * times[i] >= packSize){
                    //完全
                    complete(dp,weight[i],value[i],packSize );
                }else {
                    //0-1，并分段
                    int M = times[i];
                    for(int k = 1; k < M;k*=2){
                        zeroOne(dp,weight[i]*k,value[i]*k,packSize );
                        M -= k;
                    }
                   zeroOne(dp,weight[i]*M,value[i]*M,packSize );
                }
            }
        }
        return dp[packSize];
    }

    private static void zeroOne(int[] dp,int weight,int value,int packSize){
        for(int i = packSize;i>=weight;i--){
            dp[i] = Math.max(dp[i],dp[i-weight] + value);
        }
    }

    private static void complete(int[] dp,int weight,int value,int packSize){
        for(int i = weight;i<=packSize;i++){
            dp[i] = Math.max(dp[i],dp[i-weight] + value);
        }
    }

    public static int mixedPack2(int[] value,int[] weight,int[] times,int packSize){
        int len = value.length;
        int[][] dp = new int[len + 1][packSize + 1];

        for(int i = 0;i < len;i++){

            for(int v = 1;v<=packSize;v++){

                for(int k = 0;k*weight[i] <= v && k<=times[i];k++){

                    //因为循环多个k值，可以得到多个dp[i+1][v]，需要从中选一个最大的
                    //k=0即表示一个都不选
                    dp[i+1][v] = Math.max(dp[i+1][v],dp[i][v - k*weight[i]] + k*value[i]);
                }

            }
        }
        return dp[len][packSize];
    }

    public static void main(String[] args) {
        int[] weight = {2,3,5,6};
        int[] value = {5,6,11,14};
        int[] times = {1,8,10000,1};
        int res = mixedPack(value, weight, times, 31);
        int res2 = mixedPack2(value, weight, times, 31);
        System.out.println(res);
        System.out.println(res2);

    }

}
