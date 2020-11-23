package yowei.leetCode;

public class N033SearchInRotatedArray {
    public int search(int[] nums, int target) {
        int length = nums.length;

        int left = 0,right = length - 1,mid;

        while(left <= right){

            mid = left + (right-left)/2;
            if(target == nums[mid]){
                return mid;
            }

            if(nums[0] <= nums[mid]){
                if(target <= nums[mid] && target >= nums[left]) right = mid - 1;
                else left = mid + 1;

            }else {
                if(target >= nums[mid] && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            }

        }
        return -1;
    }


    public static void main(String[] args) {
        N033SearchInRotatedArray search = new N033SearchInRotatedArray();
        int[] a = {4,5,6,7,0,1,2};
        int res = search.search(a, 0);
        System.out.println(res);
    }
}
