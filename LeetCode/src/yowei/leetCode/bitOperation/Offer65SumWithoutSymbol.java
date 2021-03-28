package yowei.leetCode.bitOperation;

/*
要求计算两个数相加不能用四则运算符
 */
public class Offer65SumWithoutSymbol {
    public int add(int a, int b) {
        int c = 0;
        while(b !=0){                      //一轮计算过后可能再次产生进位
            c = (a & b) << 1;           //计算进位
            a ^= b;                     //非进位
            b = c;
        }
        return a;

    }
}
