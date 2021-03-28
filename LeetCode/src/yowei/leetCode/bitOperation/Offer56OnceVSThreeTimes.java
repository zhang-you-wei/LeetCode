package yowei.leetCode.bitOperation;

/**
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 */
public class Offer56OnceVSThreeTimes {
    public int singleNumber(int[] nums) {
        int[] counts = new int[32];
        //统计各个位上出现的次数
        for(int num : nums) {
            for(int j = 0; j < 32; j++) {
                counts[j] += num & 1;
                num >>>= 1;
            }
        }

        //对3取余就只剩出现一次的那个数
        int res = 0, m = 3;
        for(int i = 0; i < 32; i++) {
            res <<= 1;
            res |= counts[31 - i] % m;
        }
        return res;
    }
}
