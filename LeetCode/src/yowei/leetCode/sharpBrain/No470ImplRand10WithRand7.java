package yowei.leetCode.sharpBrain;

import java.util.Random;

/**
 * 已有方法 rand7 可生成 1 到 7 范围内的均匀随机整数，
 * 试写一个方法 rand10 生成 1 到 10 范围内的均匀随机整数。
 */
public class No470ImplRand10WithRand7 {
    public int rand10() {
        int row, col, idx;
        do {
            row = rand7();
            col = rand7();
            idx = col + (row - 1) * 7;          //均匀分布式1-49中每个数字出现概率为1/49
        } while (idx > 40);                 //大于40时拒绝采样
        return 1 + (idx - 1) % 10;
    }

    private int rand7(){
        return new Random().nextInt(7);
    }

}
