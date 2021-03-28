package yowei.leetCode.interview;

import java.util.Arrays;
import java.util.Scanner;

public class AAAA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();

        int[] nums = new int[n];
        for(int i = 0;i<n;i++){
            nums[i] = str.charAt(i) - '0';
        }
        System.out.println(Arrays.toString(nums));

        int[] dp = new int[n];
        dp[0] = 0;
        int[] aux = new int[10];
        Arrays.fill(aux,-1);
        aux[nums[0]] = 0;

        for(int i = 1;i<n;i++){
            int cur = nums[i];          //当前数字
            if(aux[cur] == -1){
                aux[cur] = i;           //保存当前数字最先出现的位置
                dp[i] = dp[i-1] + 1;
            }else{
                dp[i] = Math.min(dp[i-1] + 1,dp[aux[cur]] + 1);
            }
        }

        System.out.println(dp[n-1]);
    }


}
