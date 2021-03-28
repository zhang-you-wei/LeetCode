package yowei.leetCode.binarySearch;

public class Offer53FindDispearNum {
    public static int missingNumber(int[] nums) {
        int L = 0,R = nums.length-1;
        while(L <= R){
            int mid = L + ((R - L) >> 1);
            if(nums[mid] > mid){           //缺失数在左边
                R = mid -1 ;
            }else{
                L = mid + 1;
            }
        }
        return L ;
    }

    public static void main(String[] args) {
        int[] zrr = {0,1,3};
        int res = missingNumber(zrr);
        System.out.println(res);
    }
}
