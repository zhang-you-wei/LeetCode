package yowei.leetCode.interview;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        if(s.length() <= 1 ) System.out.println(s);
        else{
            char[] chars = s.toCharArray();
            int[] arr = new int[26];
            for(int i = 0;i<chars.length;i++){
                arr[chars[i] - 'a'] = i;
            }
            int start = 0;
            boolean flag = false;
            for(int i = 0;i<26;i++){
                int mostRight = arr[i];
                for(int j = start;j<=mostRight;j++){
                    if(chars[j] > ('a' + i)){
                        char tmp = chars[mostRight];
                        chars[mostRight] = chars[j];
                        chars[j] = tmp;
                        flag = true;
                        break;
                    }
                }
                if(flag) break;
                start = mostRight + 1;
            }
            String res = new String(chars);
            System.out.println(res);
        }

    }
}
