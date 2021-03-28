package yowei.leetCode.backTrack;

import java.util.ArrayList;
import java.util.Arrays;

public class Offer38StringPermutation {
    ArrayList<String> res = new ArrayList<>();

    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        dfs(chars,0);
        return res.toArray(new String[]{});
    }
    private void dfs(char[] chars,int index){
        if(index == chars.length - 1){
            res.add(new String(chars));
        }
        for(int i = index;i<chars.length;i++){
            swap(chars,index,i);
            dfs(chars,index + 1);
            swap(chars,index,i);
        }
    }

    private void swap(char[] chars,int i,int j){
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    public static void main(String[] args) {
        Offer38StringPermutation sp = new Offer38StringPermutation();
        String[] abcs = sp.permutation("abc");
        System.out.println(Arrays.toString(abcs));

    }
}
