package yowei.leetCode.huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> nums = new ArrayList<>();
        int sum = 0;
        String next = sc.next();
        String[] split = next.split(",");
        int len = split.length;
        for(int i = 0;i<len;i++){
            Integer cur = Integer.valueOf(split[i]);
            nums.add(cur);
            sum += cur;
        }
        /*while (sc.hasNextInt()){
            int cur = sc.nextInt();
            nums.add(cur);
            sum += cur;
        }*/
        Collections.sort(nums);
        int bag = sum/2;
        boolean[][] dp = new boolean[nums.size() + 1][bag+1];
        for(int i = 0;i<nums.size();i++){
            dp[i][0] = true;
        }

        for(int i = 1;i<=nums.size();i++){
            for(int j = bag;j>=0;j--){
                dp[i][j] = dp[i-1][j] || dp[i-1][j - nums.get(i-1)];
            }
        }
        int res = 0;
        for(int j = bag;j>=0;j--){
            if(dp[nums.size()][j]) {
                res = j;
                break;
            }
        }
        System.out.println(res);
    }
}
