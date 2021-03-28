package yowei.leetCode.huawei;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        if(str == null || str.equals("")) System.out.println(0);
        int i = 0,start = 0,end = 0,res = 0;

        while(i < str.length()){
            start = i;
            while (i < str.length()-1 && str.charAt(i+1) == str.charAt(i)){
                ++i;
            }
            end = i;
            int len = end - start + 1;
            res += len*(len + 1)/2;
            i++;
        }
        System.out.println(res);
    }
}
