package yowei.leetCode.twoPointer;

/**
 * 给你两个有序整数数组nums1 和 nums2，请你将 nums2 合并到nums1中，使 nums1 成为一个有序数组。
 * 初始化nums1 和 nums2 的元素数量分别为m 和 n 。你可以假设ums1 的空间大小等于m + n，这样它就有足够的空间保存来自 nums2 的元素。
 *
 * 思路：双指针，从后往前填，避免额外空间
 */
public class No88MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;

        int p = m + n - 1;

        while ((p1 >= 0) && (p2 >= 0))
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];

        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }
}
