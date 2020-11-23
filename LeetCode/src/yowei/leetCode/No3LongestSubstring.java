package yowei.leetCode;

import java.util.HashMap;
/*
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

*/

public class No3LongestSubstring {


    //滑动窗口
    public int lengthOfLongestSubstring(String s) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        int head = 0;       //指定不含重复字符串的头指针
        int length = 0,curlen = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(map.containsKey(chars[i])){
                length = Math.max(length,i-head);       //发现重复字符时求取当前的长度

                head = Math.max(head, map.get(chars[i]) + 1);       //重新确认头指针位置，
            }
            map.put(chars[i],i);
        }
        curlen = chars.length - head;
        if(curlen > length) length = curlen;
        return length;
    }




    public static void main(String[] args) {
        String str = " ";
        System.out.println(str.length());
        int x = new No3LongestSubstring().lengthOfLongestSubstring(str);
        System.out.println(x);
    }
}
