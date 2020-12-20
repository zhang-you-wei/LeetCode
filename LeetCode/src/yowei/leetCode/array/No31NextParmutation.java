package yowei.leetCode.array;

import java.util.Arrays;
/*
    下一个排列值能够组成的下一个较大的整数
    指针从后往前移动，直至找到一个下一个元素（ptr-1)比当前指针(ptr)元素小的位置
    将指针位置以后的元素倒序
    找到倒序后排列中第一个大于(ptr-1)的元素位置，交换两者
 */
public class No31NextParmutation {

    public void nextPermutation(int[] nums) {
        int ptr = nums.length - 1;
        while (ptr >= 1 && nums[ptr - 1] >= nums[ptr] ){
            --ptr;
        }
        if(ptr == 0){
            reverse(nums,0, nums.length-1);
            return ;
        }

        //将ptr开始的后续元素变为顺序
        reverse(nums,ptr, nums.length - 1);

        //ptr的前一个元素需要被交换，但不一定和ptr交换，因为ptr
        int place = ptr - 1;

        //开始的元素都严格大于等于place,有可能会相等，则需要将ptr依次后移
        while ( nums[ptr] <= nums[place]){
           ++ptr;
        }

        int temp = nums[place];
        nums[place] = nums[ptr];
        nums[ptr] = temp;
    }

    private static void reverse(int[] nums,int i,int j){
        int temp = 0;
        while (i < j){
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            ++i;
            --j;

        }
    }

    public static void main(String[] args) {
        int[] x = {1,1,1,2};
        No31NextParmutation par = new No31NextParmutation();
        for (int i = 0; i < 100; i++) {
            par.nextPermutation(x);
            System.out.println(Arrays.toString(x));
        }
    }
}
