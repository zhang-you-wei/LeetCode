package yowei.leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class No1TwoSum {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] a = {2,7,11,15};
        int[] res = new No1TwoSum().twoSum(a, 9);
        System.out.println(Arrays.toString(res));
    }
}
