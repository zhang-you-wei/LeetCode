package yowei.leetCode.sharpBrain;

public class No152MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int curmax = 1,curmin = 1;
        for (int i = 0; i < nums.length; i++) {
            //是负数,交换最大值和最小值
            if(nums[i] < 0){
                int temp = curmax;
                curmax = curmin;
                curmin = temp;
            }
            //不是负数
            curmax = Math.max(curmax*nums[i],nums[i]);
            curmin = Math.min(curmin*nums[i],nums[i]);

            //当前最大值
            max  = Math.max(curmax,max);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] a = {-1,0,-1,1,-1,1,-1,1,-1,1,-1};
        No152MaximumProductSubarray mps = new No152MaximumProductSubarray();
        int res = mps.maxProduct(a);
        System.out.println(res);

    }
}
