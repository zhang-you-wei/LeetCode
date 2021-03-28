package yowei.leetCode.array;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值
 */
public class Offer59MaxValueOfSlidWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for(int j = 0, i = 1 - k; j < nums.length; i++, j++) {
            // 向后滑动一格，删除左边元素，可能刚好为窗口中最大元素，即 deque 中第一个元素
            //只关心有没有可能把最大的删掉
            if(i > 0 && deque.peekFirst() == nums[i - 1])
                deque.removeFirst();

            // 保持 deque 递减
            while(!deque.isEmpty() && deque.peekLast() < nums[j])
                deque.removeLast();
            //加入右端新元素
            deque.addLast(nums[j]);
            // 记录窗口最大值

            if(i >= 0)
                res[i] = deque.peekFirst();
        }
        return res;
    }


}
