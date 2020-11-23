package yowei.leetCode;

public class No55JumpGame {
    public boolean canJump(int[] nums) {
        int length = nums.length;
        if (length<=1) return true;
        boolean[] flags = new boolean[length];
        flags[length-1] = true;
        int tail = length - 1;
        while (tail >0 ){
            --tail;
            boolean flag = false;
            for(int i=1;i<=nums[tail];i++){
                if(flags[tail + i]){
                    flag = true;
                    break;
                }
            }
            flags[tail] = flag;
        }
        return flags[0];
    }


    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        boolean b = new No55JumpGame().canJump(nums);
        System.out.println(b);
    }
}
