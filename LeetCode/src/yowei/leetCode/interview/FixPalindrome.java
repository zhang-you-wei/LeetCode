package yowei.leetCode.interview;

import java.util.Scanner;

/**
 * 补全回文串
 */
public class FixPalindrome {
    private static boolean isPalindrome(char[] arr,int i,int j){
        while(i <= j){
            if(arr[i] != arr[j]){
                break;
            }
            i++;
            j--;
        }
        return i > j;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int len = s.length();
        if(s.equals("") || len == 1){
            System.out.println(s);
        }
        char[] arr = s.toCharArray();
        int left = 0;
        while(left <= len - 1){
            if(isPalindrome(arr,left,len - 1)) break;
            left++;
        }
        StringBuilder sb = new StringBuilder(s);
        for(int i = left-1;i>=0;i--){
            sb.append(arr[i]);
        }
        System.out.println(sb.toString());

    }
}
