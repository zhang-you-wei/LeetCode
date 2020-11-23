package yowei.leetCode;

public class No5LongestPadSubstring {
    public String longestPalindrome(String s) {
        int length = s.length();
        int step = 1;
        boolean[][] dp_arr = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            dp_arr[i][i] = true;
        }
        int left_side = 0,right_side = 0;
        while (step < length){
            for (int left = 0; left < length; left++) {
                int right = left + step;
                if(right >= length) break;
                if(s.charAt(right) != s.charAt(left)) {
                    dp_arr[left][right] = false;
                    continue;
                }

                if (dp_arr[left+1][right-1] || step==1) {
                    dp_arr[left][right] = true;
                    left_side = left;
                    right_side = right;
                }
            }
            step++;
        }
        return s.substring(left_side,right_side+1);
    }

    public static void main(String[] args) {
        No5LongestPadSubstring sub = new No5LongestPadSubstring();
        String substr = sub.longestPalindrome("cb");
        System.out.println(substr);
    }
}
