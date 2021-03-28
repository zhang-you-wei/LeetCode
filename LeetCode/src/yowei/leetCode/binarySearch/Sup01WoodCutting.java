package yowei.leetCode.binarySearch;

import java.util.Scanner;

/**
 * 给定长度为n的数组，每个元素代表一个木头的长度，木头可以任意截断，从这堆木头中截出至少k个相同长度为m的木块。已知k，求max(m)。
 * 输入两行，第一行n, k，第二行为数组序列。输出最大值。
 *
 * 解法：从木有长度由高到低遍历，判断截断数量能否达到k值
 * 优化：查找过程中使用二分，不用遍历整个长度
 */
public class Sup01WoodCutting {

    private static int parts(int[] nums,int m){
        int k = 0;
        for (int num : nums) {
            k += num / m;
        }
        return k;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        int max = 0;
        for(int i = 0;i<n;i++){
            nums[i] = sc.nextInt();
            max = Math.max(max,nums[i]);
        }

        int left = 1,right = max;
        while (left <= right){
            int mid = left + ((right - left)>>1);
            int count = parts(nums, mid);
            if(count >= k){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        System.out.println(right);
    }
}
