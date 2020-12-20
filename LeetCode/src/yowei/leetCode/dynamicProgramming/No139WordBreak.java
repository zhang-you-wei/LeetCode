package yowei.leetCode.dynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class No139WordBreak {
    /**
     * 不带任何剪枝和修饰的回溯，遇到特殊用例堆栈深度会过高超时
     */
    public boolean wordBreak3(String s, List<String> wordDict) {
        return backTrack(s,wordDict);
    }

    private boolean backTrack(String s,List<String> wordDict){
        for(String str:wordDict){
            if(s.equals(str)) return true;
            if(str.length() > s.length()) continue;
            if(s.substring(0,str.length()).equals(str)) {
                if(backTrack(s.substring(str.length()),wordDict)){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 带状态变量的回溯法
     * 使用布尔数组来记录已计算过的位置的状态，避免重复计算
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] marked = new boolean[s.length() + 1];
        return dfs(s, 0, wordDict, marked);
    }
    private boolean dfs(String s, int start, List<String> wordDict, boolean[] marked) {
        for (String str : wordDict) {
            int nextStart = start + str.length();
            if (nextStart > s.length() || marked[nextStart]) {
                continue;
            }

            if (s.indexOf(str, start) == start) {
                if (nextStart == s.length() || dfs(s, nextStart, wordDict, marked)) {       //在此加入递归终止条件，即nextStart == s.length()
                    return true;
                }
                marked[nextStart] = true;
            }
        }
        return false;
    }

    /**
     * 动态规划解法
     * 先得出前m个字符是否能够被完整划分，再判断剩下n-m个字符是否在给定词之中
     */
    public boolean wordBreak2(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        HashSet<String> set = new HashSet<>(wordDict);
        dp[0] = true;
        for(int i = 1; i<=s.length();i++){
            for(int j =0;j<i;j++){
                if(dp[j] && set.contains(s.substring(j,i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        No139WordBreak wb = new No139WordBreak();
        String str = "aaaaaaaaaaaaaaaaaaaaaaaaab";
        String str2 = "leetcode";
        ArrayList<String> li = new ArrayList<>();
        li.add("leet");
        li.add("code");
        for (int i = 1; i < 8; i++) {
            String s = new String(new char[i]).replace("\0", "a");
            li.add(s);
        }
        boolean result = wb.wordBreak3(str, li);
        System.out.println(result);
    }
}
