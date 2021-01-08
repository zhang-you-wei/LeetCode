package yowei.leetCode.interview;

import java.util.*;

/**
 * 百度测试部一面
 * n个数字组成一个最小的长整型数
 */
public class Solve {
    public long getnumber(int[] nums){
        PriorityQueue<String> strArr = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o1 + o2) - Integer.parseInt(o2 + o1);
            }
        });
        for(int x: nums){
            strArr.add(String.valueOf(x));
        }
        StringBuilder sb = new StringBuilder();
        while (strArr.size() > 0 ){
            sb.append(strArr.poll());
        }
        String res = sb.toString();


        return Long.valueOf(res);
    }

    public static void main(String[] args) {
        Solve solve = new Solve();
        int[] a= {13,6,57,31,8};
        System.out.println(solve.getnumber(a));
    }

}
