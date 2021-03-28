package yowei.leetCode.array;

/*
    在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，
    但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。

    分析：无重复就是一一对应关系，即一个萝卜（元素）一个坑（数组下标），有重复时，出现多个萝卜争一个坑的情况
        从第一个位置开始让每个萝卜回到正确的位置
 */
public class Offer03RepeatNum {
    public int findRepeatNumber(int[] nums) {
        for(int i = 0;i < nums.length;i++){
            while(nums[i] != i){                //萝卜位置不对，直至找到为止
                int tmp = nums[nums[i]];            //正确位置上的萝卜
                if(nums[i] == tmp){         //出现了重复萝卜
                    return nums[i];
                }
                nums[nums[i]] = nums[i];      //把萝卜放回它对应的位置
                nums[i] = tmp;              //换来了一个新萝卜，也可能不是对的，继续循环
            }
        }
        return -1;
    }
}
