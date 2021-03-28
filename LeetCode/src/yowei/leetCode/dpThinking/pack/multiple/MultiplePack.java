package yowei.leetCode.dpThinking.pack.multiple;

public class MultiplePack {

    public static int multiplePack(int[] value,int[] weight,int[] times,int packSize){
        int len = value.length;
        int[] dp = new int[packSize + 1];
        for(int i = 0;i<len;i++){

            if(weight[i]*times[i] >= packSize){
                //完全背包
                complete(dp,weight[i], value[i],packSize);

            }else{
                //0-1背包
                for(int k = 1;k<times[i];){
                    zeroOne(dp,k*weight[i], k*value[i],packSize);
                    times[i] -= k;
                    k*=2;
                }
                zeroOne(dp,times[i]*weight[i], times[i]*value[i],packSize);
            }
        }

        return dp[packSize];
    }

    private static void complete(int[] dp,int weight,int value,int packSize){
        for (int i = weight;i<=packSize;i++){
            dp[i] = Math.max(dp[i],dp[i-weight] + value);
        }
    }
    private static void zeroOne(int[] dp,int weight,int value,int packSize){
        for (int i = packSize;i>=weight;i--){
            dp[i] = Math.max(dp[i],dp[i-weight] + value);
        }
    }

    public static int multiplePack2(int[] value,int[] weight,int[] times,int packSize){
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
        int[] weight = {2,3,5};
        int[] value = {5,8,10};
        int[] times = {6,4,3};
        int[] times2 = {6,4,3};

        int res = multiplePack(value, weight, times, 18);
        int res2 = multiplePack2(value, weight, times2, 18);
        System.out.println(res);
        System.out.println(res2);
    }

}
