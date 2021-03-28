package yowei.leetCode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsPermutation {
    public List<String> subspermutation(String str){
        char[] chars = str.toCharArray();
        ArrayList<String> res = new ArrayList<>();
        getSubsper(chars,res,0);
        return res;
    }

    private void getSubsper(char[] chars, ArrayList<String> res, int i) {
        if(i >= chars.length){
            res.add(new String(chars));
            return;
        }
        for(int j = i;j < chars.length;j++){
            swap(chars,i,j);
            getSubsper(chars,res,i+1);
            swap(chars,i,j);
        }
    }

    private void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    public static void main(String[] args) {
        SubsPermutation sp = new SubsPermutation();
        List<String> res = sp.subspermutation("aab");
        for (String str : res){
            System.out.println(str);
        }
    }
}
