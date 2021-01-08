package yowei.leetCode.array;

import java.util.Arrays;

/**
 * 最短连续乱序子数组
 */
public class No581SUnsortedConSubarray {

    /**
     * 先排序，再找元素不对的位置
     */
     public int findUnsortedSubarray(int[] nums) {
         int [] cp = Arrays.copyOf(nums,nums.length);
         Arrays.sort(cp);
         int left =0 ,right = 0;
         for(int i = 0;i<nums.length;i++){
             if(cp[i] != nums[i]) {
                 left = i;
                 break;
             }
         }
         for(int j = nums.length - 1;j>=0;j--){
             if(cp[j] != nums[j]) {
                 right = j;
                 break;
             }
         }
         return right==left? 0:right - left + 1;
     }

    /**
     * 双指针：从前往后找右边界，从后往前找左边界
     * 核心思路：找到最后一个逆序的元素位置为右边界，找到最靠前的一个逆序元素为左边界
     */
    public int findUnsortedSubarray2(int[] nums) {
        int len = nums.length;
        int max = nums[0];
        int min = nums[len-1];
        int l = 0, r = -1;          //r定为-1最后刚好返回0

        for(int i=0;i<len;i++){
            if(max>nums[i]){
                r = i;
            }else{
                max = nums[i];
            }
            if(min<nums[len-i-1]){
                l = len-i-1;
            }else{
                min = nums[len-i-1];
            }
        }
        return r-l+1;
    }

}
