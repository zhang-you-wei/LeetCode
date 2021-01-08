package yowei.leetCode.array;

/**
 * 最大子序和
 * 记录之前的所有数之和，若其大于零，则可以加上当前值，否则当前值就当做当前最大值
 */
public class No53MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int num: nums){
            if(sum > 0){
                sum += num;
            }else{
                sum = num;
            }
            max = Math.max(sum,max);
        }
        return max;

    }
}
