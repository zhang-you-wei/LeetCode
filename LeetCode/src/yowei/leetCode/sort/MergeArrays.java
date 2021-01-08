package yowei.leetCode.sort;

import java.util.Arrays;

public class MergeArrays {
    public static int[] mergeArrays(int[][] nums) {
        int len = nums[0].length;
        //创建结果数组
        int[] res = new int[nums.length*len];
        
        //步长为2开始合并
        for(int i = 0;i < nums.length;i += 2){
            merge(nums,res,i);
        }

        //步长为2，即合并的一半长度为2，总区间长度为4。
        for(int step =2;step <= nums.length;step *= 2){
            for(int i = 0;i<= nums.length;i += step*2){
                mergearr(res,i*len,step*len,Math.min((i+step*2)*len-1, res.length - 1));
            }
        }
        
        return res;
    }

    private static void mergearr(int[] res, int start, int step, int end) {
        //我这里只复制了原数组的一段，因此其长度和原数组不同
        int[] temp = new int[end - start + 1];
        System.arraycopy(res,start,temp,0,(end - start + 1));

        int left = 0,right =  step;
        for(int k = start;k<=end;k++){
            if(left >= step) res[k] = temp[right++];
            else if(right >= end - start + 1) res[k] = temp[left++];
            else if(temp[left] <= temp[right]) res[k] = temp[left++];
            else res[k] = temp[right++];
        }
    }

    private static void merge(int[][] nums,int[] res,int start){
        int len = nums[0].length;
        int index = start * len;
        if(start == nums.length - 1){
            for(int i = 0;i<len;i++){
                res[index++] = nums[start][i];
            }
            return;
        }
        int[] arr1 = nums[start];
        int[] arr2 = nums[start + 1];
        int left = 0,right = 0;
        for(int i = 0;i<len*2;i++){
            if(left >= len) res[index++] = arr2[right++];
            else if(right >= len) res[index++] = arr1[left++];
            else if(arr1[left] <= arr2[right]) res[index++] = arr1[left++];
            else res[index++] = arr2[right++];
        }
    }

    public static void main(String[] args) {
        int[][] a = {{1,4,7},{2,5,8},{3,6,9},{4,5,6},{1,5,9}};
        int[] res = MergeArrays.mergeArray2(a);
        System.out.println(Arrays.toString(res));
    }


    /**
     * 将N个数组合并为一个数组
     * 方法二：每经过依次合并循环后，所得到的二维数组长度减半，直至最后变成一维的
     */
    public static int[] mergeArray2(int[][] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        if (nums.length == 1) {
            return nums[0];
        }
        int len = nums.length;
        boolean flag = len % 2 != 0;
        int half = len % 2 != 0 ? len / 2 + 1 : len / 2;
        int[][] resultNums = new int[half][];
        for (int i = 0; i < len; i += 2) {
            if (flag && i == len - 1) {
                resultNums[i / 2] = nums[i];
            } else {
                resultNums[i / 2] = mergeTwoArray(nums[i], nums[i + 1]);
            }
        }
        return mergeArray2(resultNums);

    }

    public static int[] mergeTwoArray(int[] num1, int[] num2) {
        int len1 = num1.length;
        int len2 = num2.length;
        int index1 = 0;
        int index2 = 0;
        int index = 0;
        int[] resultArray = new int[len1 + len2];
        while (index1 < len1 && index2 < len2) {
            if (num1[index1] < num2[index2]) {
                resultArray[index++] = num1[index1++];
            } else {
                resultArray[index++] = num2[index2++];
            }
        }

        while (index1 < len1) {
            resultArray[index++] = num1[index1++];
        }

        while (index2 < len2) {
            resultArray[index++] = num2[index2++];
        }
        return resultArray;
    }



}
