package yowei.leetCode;

import java.util.Arrays;

public class ReverseString {
    public void reverseString(char[] s) {
        int size = s.length;
        if(size <= 1) return;
        int head=0,tail=size-1;
        while (head<tail){
            char temp = s[head];
            s[head] = s[tail];
            s[tail] = temp;
            ++head;
            --tail;
        }
        System.out.println(Arrays.toString(s));
    }

    public static void main(String[] args) {
        char[] a = {'h','e','l','l','o'};
        new ReverseString().reverseString(a);
    }
}
