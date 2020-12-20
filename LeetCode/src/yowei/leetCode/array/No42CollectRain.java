package yowei.leetCode.array;

import java.util.Deque;
import java.util.LinkedList;

public class No42CollectRain {

    /*
    方法一:暴力解法
           时间：O(n²)
           空间：O(1)
           求解每根柱子能容纳多少水，加起来
     */
    public int trap(int[] height) {

        if(height==null || height.length<=2) return 0;

        int len = height.length;
        int sum = 0;
        for (int i = 1; i < len-1; i++) {
            int left_max = 0,right_max = 0;
            int left =i;
            int right = i;

            //找左边最大值
            while (left>=0){
                left_max = Math.max(height[left],left_max);
                --left;
            }
            //右边最大值
            while (right <= len - 1){
                right_max = Math.max(height[right],right_max );
                ++right;
            }
            int cur = Math.min(left_max,right_max) - height[i];
            sum += cur;
        }
        return sum;
    }


    /*
        动态规划优化暴力解法
        时间：O(n)99.99%
        空间：O(n)86.44%
     */
    public int trap2(int[] height){
        if(height==null || height.length<=2) return 0;

        int len = height.length;
        int[] max = new int[len];           //利用两个数组记录每根柱子左右两端的最大高度
        int[] max_rev = new int[len];
        int sum = 0;

        int temp_max = 0;

        for (int i = 0; i < len; i++) {
            temp_max = Math.max(temp_max,height[i]);
            max[i] = temp_max;
        }

        temp_max = 0;

        for (int i = len-1; i >=0; i--) {
            temp_max = Math.max(temp_max,height[i]);
            max_rev[i] = temp_max;
        }

        for (int i = 1; i < len - 1; i++) {
            sum += (Math.min(max[i],max_rev[i]) - height[i]);
        }

        return sum;
    }


    /*
        递减栈
        时间：O(n)45.48%
        空间：O(n)91.48%
     */
    public int trap3(int[] height){

        if(height==null || height.length<=2) return 0;

        Deque<Integer> stack = new LinkedList<>();
        int sum = 0;

        int len = height.length;


        /*
            从头开始遍历，所有可能的左壁入递减栈，直至遇到右壁
            向前循环，得出容器每轮长度和高度（一层一层的加）
         */
        for (int i = 0; i < len; i++) {

            while (!stack.isEmpty() && height[i]>height[stack.peek()]){
                int bottom = height[stack.pop()];
                //栈为空表示没有左壁
                if(stack.isEmpty()) break;
                //得到较短的边
                int border = Math.min(height[i],height[stack.peek()]);
                int disance = i - stack.peek() - 1;
                sum += ((border - bottom)*disance);

            }
            stack.push(i);
        }
        return sum;
    }


    /*
        双指针法：按每根柱子求
        时间：O(n)99.99%
        空间：O(1)91.59%
        以左右两边较高的一边为容器的高壁（尽管不是最高的，也不需要求出最高的，能满足需求即可）
        较低的一边总是为容器的短壁，即较低的一边的最高壁也小于另一边
        因此每根柱子的的积水量取决于较低一边的最长壁
     */
    public int trap4(int[] height){

        int left = 0,right = height.length - 1;
        int left_max = 0,right_max = 0,sum = 0;
        /*
            双指针
            如果left_max<right_max成立，那么它就知道自己能存多少水了。无论右边将来会不会出现更大的right_max，都不影响这个结果
         */
        while (left <= right){
            //由左往右执行，前提一定会包括leftmax在内的所有左边元素都小于height[right],否则就会转到从右往左执行
            if(height[left] <= height[right]){
                left_max = Math.max(height[left],left_max);
                sum += (left_max - height[left]);
                left++;
            }
            //从右往左执行，前提一定会包括rightmax在内的所有右边元素都小于height[left],
            else {
                right_max = Math.max(right_max,height[right]);
                sum += (right_max - height[right]);
                right--;
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        int[] aa = {3,2,1,1,1,2,3};
        No42CollectRain no42CollectRain = new No42CollectRain();
        int trap = no42CollectRain.trap4(aa);
        System.out.println(trap);
    }
}
