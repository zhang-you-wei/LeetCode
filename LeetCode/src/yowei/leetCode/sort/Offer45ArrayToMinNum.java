package yowei.leetCode.sort;

import java.util.*;

/**
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *
 * 比较两个数组合的大小，进行排序
 */
public class Offer45ArrayToMinNum {
    public static String minNumber(int[] nums) {
        ArrayList<String> li = new ArrayList<>();
        for(int x : nums){
            li.add(String.valueOf(x));
        }
        Collections.sort(li, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });

        StringBuilder sb = new StringBuilder();
        for(String x:li){
            sb.append(x);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] input = {3,30,34,5,9};
        String res = minNumber(input);
        System.out.println(res);
    }

}
