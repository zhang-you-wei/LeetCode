package yowei.leetCode.sort;

public class Offer51ReverseCounts {
    public int InversePairs(int [] array) {
        if(array.length<=1) return 0;
        //归并排序，合并时计算逆序数
        //int[] aux = Arrays.copyOf(array,array.length);
        int[] aux = new int[array.length];

        return mergerAndCount(array,0,array.length - 1,aux);

    }

    //归并排序，返回start-end区间的逆序数
    private int mergerAndCount(int[] arr,int start,int end,int[] temp){
        //结束判断
        if(start == end) return 0;

        //分之计算左右两边
        int mid = (start + end)/2;
        int leftcounts = mergerAndCount(arr,start,mid,temp);
        int rightcounts = mergerAndCount(arr,mid + 1,end,temp);

        //特殊情况
        if(arr[mid] <= arr[mid + 1]) return leftcounts + rightcounts;

        //交叉的逆序对
        int crosscounts = merge(arr,start,mid,end,temp);
        return leftcounts + rightcounts + crosscounts;
    }

    private int merge(int[] arr,int start,int mid,int end,int[] temp){
        for(int i = start;i<=end;i++){
            temp[i] = arr[i];
        }
        int count = 0;
        int left = start,right = mid + 1;
        //合并
        for(int i = start;i<=end;i++){
            //有一边拿完了
            if(left > mid){
                arr[i] = temp[right++];
            }
            else if(right > end){
                arr[i] = temp[left++];
            }
            else if(temp[left] <= temp[right]){
                arr[i] = temp[left++];
            }else{
                arr[i] = temp[right++];
                //计算逆序数
                count += mid - left + 1;
            }
        }
        return count;
    }

    /*
     *  public static int[] mergeArrays(int[][] nums) {
        return merge(nums);
    }

    //两两合并数组
    public static int[] merge(int[][] nums) {
        if (nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int rows = nums.length / 2;
        //两两合并后的新数组
        int[][] result = new int[rows][];
        for (int i = 0; i < nums.length; i += 2) {
            result[i / 2] = mergeTwoArray(nums[i], nums[i + 1]);
        }
        return merge(result);
    }


    //具体对两个数组进行合并，成为一个新数组
    public static int[] mergeTwoArray(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int[] helper = new int[length1 + length2];
        int p1 = 0, p2 = 0, index = 0;
        while (p1 < length1 && p2 < length2) {
            if (nums1[p1] < nums2[p2]) {
                helper[index++] = nums1[p1++];
            } else {
                helper[index++] = nums2[p2++];
            }
        }
        while (p1 < length1) {
            helper[index++] = nums1[p1++];
        }
        while (p2 < length2) {
            helper[index++] = nums2[p2++];
        }
        return helper;
    }
     *
     *
     *
     */

    public static void main(String[] args) {
        Offer51ReverseCounts orc = new Offer51ReverseCounts();
        int[] a = {1,4,7,2,5,8};
        int res = orc.InversePairs(a);
        System.out.println(res);
    }
}
