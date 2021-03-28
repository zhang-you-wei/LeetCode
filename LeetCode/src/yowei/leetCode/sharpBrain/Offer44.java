package yowei.leetCode.sharpBrain;

/**
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。
 * 在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 * 请写一个函数，求任意第n位对应的数字。
 */
public class Offer44 {
    public int findNthDigit(int n) {
        int digit = 1;          //位数
        long start = 1;            //开始的数字
        long count = 9;
        while (n > count) { // 1.
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit; // 2.得到具体数字
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.转化到对应位置
    }
}
