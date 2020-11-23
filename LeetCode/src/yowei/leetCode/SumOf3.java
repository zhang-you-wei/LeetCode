package yowei.leetCode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
    三数之和解法：
    1、首先进行排序保证不会造成重复结果
    2、固定第一个数，后两个数使用双指针移动使时间复杂度减小为O(n)
 */
public class SumOf3 {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        ArrayList<List<Integer>> lists = new ArrayList<>();

        if(nums.length <= 2) return lists;      //优化一：不符合条件的输入直接返回

        int length = nums.length;
        int left,right;
        for (int i = 0; i < length - 2; i++) {
            if(nums[i] > 0) break;              //优化二：第一个数大于零时直接返回
            if(i > 0 && nums[i]==nums[i-1]) continue;      //优化三：排除重复元素

            left = i + 1;
            right = length - 1;
            while (left < right){

                if((nums[i] + nums[left] + nums[right])==0){
                    ArrayList<Integer> comb = new ArrayList<>();
                    comb.add(nums[i]);
                    comb.add(nums[left]);
                    comb.add(nums[right]);
                    lists.add(comb);
                    ++left;
                    --right;
                    
                }
                else if((nums[i] + nums[left] + nums[right]) > 0){
                    --right;
                }
                else ++left;
            }
        }
    return lists;
    }


    public static void main(String[] args) {
        int[] nums = {-1,-8,-2,5,2,4,6,2,3,3,1,5,7,5,2,6,9,-3,-7,-6,0,0,0,0,0,0,0,0,-6,-4,-5,-1,-2,-8};
        SumOf3 sumOf3 = new SumOf3();
        List<List<Integer>> lists = sumOf3.threeSum(nums);
        for (List<Integer> comb:lists) {
            System.out.println(comb);
        }
    }
}
