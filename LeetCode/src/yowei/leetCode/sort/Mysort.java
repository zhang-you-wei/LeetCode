package yowei.leetCode.sort;

import java.util.Arrays;
import java.util.Random;

public class Mysort {
    public void select_sort(int[] nums){
        int len = nums.length;
        for(int i = 0;i< len;i++){
            int min = i;
            for (int j = i+1;j<len;j++){
                if(nums[j] < nums[min]) min = j;
            }
            exch(nums,i,min);
        }
    }

    public void bubble_sort(int[] nums){
        int len = nums.length;
        for(int i = 0;i<len;i++){
            for(int j = 0;j<len - i - 1;j++){
                if(nums[j] > nums[j+1]) exch(nums,j,j+1);
            }
        }

    }

    public void insert_sort(int[] nums){
        int len = nums.length;
        for (int i =0;i<len;i++){
            int j = i - 1;
            while (j >= 0){
                if(nums[i] > nums[j]){
                    break;
                }
                j--;
            }
            if(j == i-1) continue;
            int temp = nums[i];
            System.arraycopy(nums,j+1,nums,j+2,i-j-1);
            nums[j + 1] = temp;

        }

    }

    public void quick_sort(int[] nums){
        int len = nums.length;
        quick_sort(nums,0,len - 1);
    }

    private void quick_sort(int[] arr,int start,int end){
        if(start >= end) return;
        int pivot = arr[start];
        int exp = start + 1;
        for(int i= exp;i<=end;i++){
            if(arr[i] < pivot) {
                exch(arr,exp,i);
                exp++;
            }
        }
        exch(arr,exp - 1,start);
        quick_sort(arr,start,exp - 2);
        quick_sort(arr,exp,end);
    }

    public void merge_sort(int[] nums){
        nums = merge_sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private int[] merge_sort(int[] arr,int lo,int hi){
        if(lo >= hi) {
            int[] si = {arr[lo]};
            return si;
        }
        int mid = (lo + hi)/2;
        int[] a1 = merge_sort(arr,lo,mid);
        int[] a2 = merge_sort(arr,mid + 1,hi);
        return merge(a1,a2);

    }

    private int[] merge(int[] a,int[] b){
        int[] res = new int[a.length + b.length];
        int aptr = 0,bptr = 0;
        for(int i = 0;i<a.length + b.length;i++){
            if(aptr >= a.length) res[i] = b[bptr++];
            else if(bptr >= b.length) res[i] = a[aptr++];
            else if(a[aptr] < b[bptr]) res[i] = a[aptr++];
            else res[i] = b[bptr++];
        }

        return res;
    }

    public void heap_sort(int[] nums){

    }

    private void exch(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        Random random = new Random();
        int[] a = new int[10];
        for (int i = 0; i < 10; i++) {
            a[i] = random.nextInt(20);
        }
        Mysort ms = new Mysort();
        //ms.select_sort(a);
        //ms.bubble_sort(a);
        //ms.insert_sort(a);
        //ms.quick_sort(a);
        ms.merge_sort(a);
        //System.out.println(Arrays.toString(a));
        String ss = "hello";


    }


}
