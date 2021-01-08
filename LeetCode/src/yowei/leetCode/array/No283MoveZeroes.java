package yowei.leetCode.array;

/**
 * 将所有的零移动到尾部，要求不能使用额外空间
 */
public class No283MoveZeroes {
    public void moveZeroes(int[] nums) {
        int zeroptr = 0;
        for(int i = 0;i< nums.length;i++){
            if(nums[i] == 0) {
                continue;
            }
            if(zeroptr < i) {
                nums[zeroptr] = nums[i];
                nums[i] = 0;
            }
            zeroptr++;
        }
    }
}
