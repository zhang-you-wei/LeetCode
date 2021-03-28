package yowei.leetCode.binarySearch;

/**
 * 在旋转后的数组中查找指定元素
 * 可以使用二分查找，但是查找条件要细分
 */
public class No33SearchInRotatedArray {
    public int search(int[] nums, int target) {
        int length = nums.length;

        int left = 0,right = length - 1,mid;

        while(left <= right){

            mid = left + (right-left)/2;
            if(target == nums[mid]){
                return mid;
            }

            //说明大数堆更长
            if(nums[0] <= nums[mid]){
                if(target <= nums[mid] && target >= nums[left]) right = mid - 1;
                else left = mid + 1;

            }else {             //小数堆更长
                if(target >= nums[mid] && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            }

        }
        return -1;
    }


    public static void main(String[] args) {
        No33SearchInRotatedArray search = new No33SearchInRotatedArray();
        int[] a = {4,5,6,7,0,1,2};
        int res = search.search(a, 0);
        System.out.println(res);
    }
}
