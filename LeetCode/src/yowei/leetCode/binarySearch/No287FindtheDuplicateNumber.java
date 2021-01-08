package yowei.leetCode.binarySearch;

public class No287FindtheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int length = nums.length;
        int left = 1,right = length - 1,res = -1;

        //二分查找
        while(left <= right){
            int mid = (left + right)>>1;
            int count = 0;
            for (int i = 0; i < length; i++) {
                if(nums[i] <= mid){
                    count++;
                }
            }

            //从左边找第一个大于目标的位置
            if(mid <= count){
                left = mid + 1;
            }
            //从右边找第一个小于目标的位置
            else {
                right = mid - 1;
                res = mid;
            }
        }
        //最终位置就是第一个小于目标的位置加一
        return res;
    }
}
