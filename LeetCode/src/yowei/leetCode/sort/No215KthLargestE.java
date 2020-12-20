package yowei.leetCode.sort;

public class No215KthLargestE {
    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 堆排序，建立大根堆
     */
    public int findKthLargest(int[] nums, int k) {
        //堆排序
        int size = nums.length;

        //将原始数组下沉排序
        for(int i = nums.length/2 - 1;i>=0;i--){
            sink(nums,i,size);
        }

        //取出前k个元素
        for(int i = 1;i < k;i++){
            swap(nums,0,size - 1);
            size--;
            sink(nums,0,size);
        }
        return nums[0];
    }

    private void sink(int[] nums,int cur,int size){
        int left = cur*2 +1,right = cur*2 + 2,larger = cur;
        //找到子节点较大的那个和根节点交换
        if(left < size && nums[larger] < nums[left]) larger = left;
        if(right < size && nums[larger] < nums[right]) larger = right;
        //排成有序,子节点比根节点小的情况下才进行交换和向下遍历
        if(larger != cur){
            swap(nums,cur,larger);
            sink(nums,larger,size);
        }
    }


    /**
     *快速排序
     */
    public int findKthLargest2(int[] nums, int k) {
        //快排
        quicksort(nums,0,nums.length - 1,k);
        return nums[k-1];
    }

    private void quicksort(int[] nums,int left,int right,int k){
        if(left >= right) return;
        int mid = partition(nums,left,right);
        //判断条件优化，只需要排序k所在的那个区间
        if(mid < k-1) quicksort(nums,mid + 1,right,k);
        if(mid > k-1) quicksort(nums,left,mid - 1,k);
    }

    private int partition(int[] nums,int left,int right){
        int pivot = nums[left];
        int exchpoint = left + 1;

        for(int cur = left + 1;cur <= right;cur++){
            if(nums[cur] > pivot) {
                swap(nums,exchpoint,cur);
                exchpoint++;
            }
        }
        swap(nums,left,exchpoint - 1);
        return exchpoint - 1;
    }

    public static void main(String[] args) {
        No215KthLargestE kl = new No215KthLargestE();
        int[] nums = {5,2,4,1,3,6,0};
        int kthLargest = kl.findKthLargest(nums, 4);
        System.out.println(kthLargest);
    }
}
