package yowei.leetCode.hash;

import java.util.HashMap;

/**
 * 连续子数组和为k
 * 使用hash表记录前缀和
 */
public class No560SubarrayOfK {

    /**
     * 动态规划形式的枚举法
     */
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for(int i = nums.length- 1;i>=0;i--){           //从后往前填
            for(int j = nums.length - 1;j>i;j--){           //每次填的长度加一
                nums[j] += nums[i];
                if(nums[j] == k) count++;
            }
            if(nums[i] == k) count++;
        }
        return count;
    }

     public int subarraySum2(int[] nums, int k) {
         int count = 0, pre = 0;
         HashMap <Integer, Integer> mp = new HashMap<>();
         mp.put(0, 1);
         for (int i = 0; i < nums.length; i++) {
             pre += nums[i];
             if (mp.containsKey(pre - k)) {
                 count += mp.get(pre - k);
             }
             mp.put(pre, mp.getOrDefault(pre, 0) + 1);
         }
         return count;
     }
}
