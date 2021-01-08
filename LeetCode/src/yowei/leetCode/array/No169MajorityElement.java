package yowei.leetCode.array;

/**
 * 投票算法选众数，要求众数必须大于等于总元素个数的一半
 * 先提名候选值，遇到支持他的（等于后选值）将count加一，否则count-1，当count=0时，重新提名后选值
 */
public class No169MajorityElement {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = nums[0];

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}
