package yowei.leetCode;

import java.util.Arrays;

public class ColorSort {
    public void sortColors(int[] nums) {
        /*int red=0,white=0,blue=0;

        for (int num : nums) {
            if(num==0) red++;
            else if(num==1) white++;
            else blue++;
        }

        for (int i=0;i< nums.length;i++){
            if(i<red) nums[i] = 0;
            else if(i<red+white) nums[i] = 1;
            else nums[i] = 2;
        }
        System.out.println(Arrays.toString(nums));*/
        if(nums==null || nums.length==1) return;

        int len = nums.length;
        int head = 0,tail = len-1;

        for (int cur=0;cur<=tail;cur++) {

            while (nums[cur] == 2 && cur<=tail ) {

                swap(cur,tail,nums);
                --tail;

            }
            if(nums[cur] == 0 ) {
                swap(head, cur, nums);
                ++head;
            }


        }
        System.out.println(Arrays.toString(nums));
    }

    public static void swap(int a,int b,int[] nums){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }


    public static void main(String[] args) {
        int[] a = {0,2,0,1,0,2,1,1,0,2,1,0,2,2,0};
        new ColorSort().sortColors(a);

    }
}

