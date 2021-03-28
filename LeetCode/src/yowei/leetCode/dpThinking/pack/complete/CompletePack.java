package yowei.leetCode.dpThinking.pack.complete;

public class CompletePack {

    public int completePack1(int[] value,int[] weight,int packSize){
        int len = value.length;
        int[][] dp = new int[len + 1][packSize + 1];

        for(int i = 0;i < len;i++){

            for(int v = 1;v<=packSize;v++){

                for(int k = 0;k*weight[i] <= v;k++){

                    //因为循环多个k值，可以得到多个dp[i+1][v]，需要从中选一个最大的
                    //k=0即表示一个都不选
                    dp[i+1][v] = Math.max(dp[i+1][v],dp[i][v - k*weight[i]] + k*value[i]);
                }

            }
        }
        return dp[len][packSize];
    }

    public int completePack2(int[] value,int[] weight,int packSize){
        int[] dp = new int[packSize + 1];
        for (int i = 0; i <= packSize; i++) {
            for(int j=1;j< value.length;j++){
                int c = weight[j];
                if(c <= i){
                    dp[i] = Math.max(dp[i],dp[i-c] + value[j]);
                }
            }
        }
        return dp[packSize];
    }

    public static void main(String[] args) {
        CompletePack cp = new CompletePack();
        int[] weight = {3,5,4,2,6,7};
        int[] value = {6,9,8,5,14,17};
        int res1 = cp.completePack1(value, weight, 15);
        int res2 = cp.completePack2(value, weight, 15);
        System.out.println(res1);
        System.out.println(res2);

    }



}
