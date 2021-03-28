package yowei.leetCode.string;

import java.util.ArrayList;
import java.util.List;

public class SubsPerNoRepeat {
    public List<String> subsPerNoRepeat(String str){
        char[] chars = str.toCharArray();
        ArrayList<String> res = new ArrayList<>();
        getSubsNoRe(chars,res,0);
        return res;
    }

    private void getSubsNoRe(char[] chars, ArrayList<String> res, int i) {
        if(i >= chars.length){
            res.add(new String(chars));
            return;
        }
        boolean[] map = new boolean[26];            //使用布尔数组代替哈希表在i位置上去重
        for(int j = i;j < chars.length;j++){
            if(!map[chars[j] - 'a']){               //如果i位置上出现过该字母直接跳过
                map[chars[j] - 'a'] = true;
                swap(chars,i,j);
                getSubsNoRe(chars,res,i+1);
                swap(chars,i,j);
            }

        }
    }

    private void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    public static void main(String[] args) {
        SubsPerNoRepeat spn = new SubsPerNoRepeat();
        List<String> res = spn.subsPerNoRepeat("aab");
        for (String str : res){
            System.out.println(str);
        }
    }
}
