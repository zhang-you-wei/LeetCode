package yowei.leetCode.binarySearch;

/**
 * 找到数组中第一个大于等于给顶元素的位置
 */
public class FirstLargeNumbers {

    int res = 1;
    public int upper_bound_ (int n, int v, int[] a) {
        // write code here
        //找到数组中第一次给定值出现的位置，二分查找到结果之后还要继续查找左边部分
        res = n + 1;
        binary(0,n - 1,a,v);
        return res;

    }

    public void binary(int left,int right,int[] nums,int target){
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                //找到指定元素后继续向左进行查找
                res = mid +1;
                right = mid - 1;

            }
            if(nums[mid] > target) right = mid - 1;
            if(nums[mid] < target) left = mid + 1;
        }
    }

    public static void main(String[] args) {
        FirstLargeNumbers fln = new FirstLargeNumbers();
        int[] a = {1,2,4,4,5};
        int res = fln.upper_bound_(5, 4, a);
        System.out.println(res);
    }
}
