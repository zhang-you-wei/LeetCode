package yowei.leetCode.array;

import java.util.Arrays;

/**
 * 找到升序数组指定元素最小索引和最大索引
 * 要求对数级别算法，考虑二分查找
 * 关键在于找到特定元素后不能停止查找，要继续向左向右查找找到更大/小的索引
 * 左右查找要分两种情况
 */
public class No34FindFALPosition {

    //全局变量保存结果
    int res_l = 0;
    int res_r = 0;

    public int[] searchRange(int[] nums, int target) {
        return binary(0,nums.length - 1,nums,target);
    }

    //单边查找
    public int[] binary(int left,int right,int[] nums,int target){
        int[] res = {-1,-1};
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                res_r = mid;
                res_l = mid;

                //找到指定元素后两边进行查找
                binary(left,mid - 1,nums,target,false);
                binary(mid + 1,right,nums,target,true);
                res[0] = res_l;
                res[1] = res_r;
                return res;
            }
            if(nums[mid] > target) right = mid - 1;
            if(nums[mid] < target) left = mid + 1;
        }

        return res;
    }

    //双边查找
    public void binary(int left,int right,int[] nums,int target,boolean dir){
        if(dir){
            //向右查找
            while(left <= right){
                //左边界大于指定元素直接返回
                if(nums[left] > target) return;
                int mid = left + (right - left)/2;
                if(nums[mid] == target){
                    res_r = mid;
                    //查找到中间值仍等于指定值，继续向右查询
                    binary(mid + 1,right,nums,target,true);
                    break;
                }
                right = mid - 1;
            }
        }else{
            while(left <= right){
                //有边界元素小于指定元素直接返回
                if(nums[right] < target) return;
                int mid = left + (right - left)/2;
                if(nums[mid] == target){
                    res_l = mid;
                    binary(left,mid - 1,nums,target,false);
                    break;
                }
                left = mid + 1;
            }
        }
    }

    public static void main(String[] args) {
        No34FindFALPosition fp = new No34FindFALPosition();
        int[] a = {1,2,3,3,3,3,4,5,9};
        int[] res = fp.searchRange(a, 3);
        System.out.println(Arrays.toString(res));
    }
}
