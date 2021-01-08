package yowei.leetCode.dynamicProgramming;

import java.util.Arrays;

/**
 * 最长升序子序列
 */
public class No300LongestIncSubsequence {
     public int lengthOfLIS(int[] nums) {
         //动态规划时间复杂度O(n2)
         //创建dp数组，表示以第i个元素结尾的子序列的最大长度
         if(nums == null) return 0;
         int[] dp = new int[nums.length];
         Arrays.fill(dp,1);
         int max = 1;
         //查找前i-1个元素，找到满足条件的最大长度
         for(int i = 0;i<nums.length;i++){
             for(int j = 0;j<i;j++){
                 //若大于之前的某个元素，则将长度加一
                 if(nums[i] > nums[j]){
                     dp[i] = Math.max(dp[i],dp[j] + 1);
                 }
                  //否则跳过
             }
             max = Math.max(max,dp[i]);
         }
         //用max记录最大长度并返回
         return max;
     }

    public int lengthOfLIS2(int[] nums) {
        //动态规划+二分查找
        //创建tail数组，表示最大子序列
        int[] tail = new int[nums.length];
        tail[0] = nums[0];
        int count = 1;

        //找到tail中第一个大于当前元素的位置，交换其位置，否则就将数组长度，并将该元素放置于末尾
        for(int i = 1;i<nums.length;i++){
            if(nums[i] > tail[count -1]){
                tail[count] = nums[i];
                count++;
            }else{
                int left = 0,right = count-1;
                while(left <= right){
                    int mid = (left + right)>>1;
                    if(tail[mid] < nums[i]){
                        left = mid +1;
                    }
                    else{
                        right = mid -1;
                    }
                }
                //left表示第一个大于等于num[i]的元素索引
                tail[left] = nums[i];
            }
        }
        //System.out.println(Arrays.toString(tail));

        return count;
    }
}
