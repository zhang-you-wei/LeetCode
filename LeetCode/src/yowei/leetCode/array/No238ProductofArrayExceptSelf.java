package yowei.leetCode.array;

/**
 * 计算出数组中除了自身以外其他剩余数字的积
 * 使用两个数组，分别记录某个位置左边的积和右边的积，然后相乘得到结果
 */
public class No238ProductofArrayExceptSelf {
     public int[] productExceptSelf(int[] nums) {
         if(nums.length <= 1) return nums;

         int[] seq = new int[nums.length];
         int[] rev = new int[nums.length];
         seq[0] = 1;
         rev[nums.length - 1] = 1;
         for (int i = 1; i < rev.length; i++) {
             int j = rev.length - i -1;
             seq[i] = seq[i-1] * nums[i-1];
             rev[j] = rev[j + 1] *nums[j+1];
         }
         for(int i =0;i<nums.length;i++){
             seq[i] = seq[i]*rev[i];
         }
         return seq;
     }

     /*###################################################################*/

    /**
     * 只使用一个数组，第二个数组借助变量R替代功能
     */
    public int[] productExceptSelf2(int[] nums) {
        int length = nums.length;
        int[] answer = new int[length];

        // answer[i] 表示索引 i 左侧所有元素的乘积
        // 因为索引为 '0' 的元素左侧没有元素， 所以 answer[0] = 1
        answer[0] = 1;
        for (int i = 1; i < length; i++) {
            answer[i] = nums[i - 1] * answer[i - 1];
        }

        // R 为右侧所有元素的乘积
        // 刚开始右边没有元素，所以 R = 1
        int R = 1;
        for (int i = length - 1; i >= 0; i--) {
            // 对于索引 i，左边的乘积为 answer[i]，右边的乘积为 R
            answer[i] = answer[i] * R;
            // R 需要包含右边所有的乘积，所以计算下一个结果时需要将当前值乘到 R 上
            R *= nums[i];
        }
        return answer;
    }
}
