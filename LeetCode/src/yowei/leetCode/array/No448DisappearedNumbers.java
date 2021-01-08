package yowei.leetCode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 找到到数组中消失的元素：有n个数并且范围在1-n之间
 * 原地修改时间O(n),空间O(1)算法：将出现的数字对应索引值改为负的，以区分
 */
public class No448DisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        //用来存放结果
        List<Integer> res = new ArrayList<>();
        //1. 遍历下数组的元素，对对应的索引位置的元素作标记
        int len = nums.length;
        for(int i = 0; i < len; i++){
            int num = Math.abs(nums[i]);  //由于数组的元素有可能被*-1，所以取绝对值
            int index = num - 1;
            if(nums[index] > 0){
                nums[index] *= -1;
            }
        }
        // 寻找没有标记的索引位置
        for(int i = 0; i < len; i++){
            if(nums[i] > 0){
                int num = i + 1;  //将索引转化为对应的元素
                res.add(num);
            }
        }
        return res;
    }
}
