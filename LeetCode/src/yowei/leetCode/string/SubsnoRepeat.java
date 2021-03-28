package yowei.leetCode.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubsnoRepeat {
    public List<String> subsnorepeat(String str){
        String path = "";
        HashSet<String> ans = new HashSet<>();
        getSubs(str,ans,0,path);
        ArrayList<String> res = new ArrayList<>(ans);
        return  res;

    }

    private void getSubs(String str, Set<String> ans, int i, String path) {
        if (i >= str.length()) {
            ans.add(path);
            return;
        }
        getSubs(str, ans, i + 1, path);
        //String yes = path + str.charAt(i);
        getSubs(str, ans, i + 1, path + str.charAt(i));
    }

    public static void main(String[] args) {
        SubsnoRepeat snr = new SubsnoRepeat();
        List<String> res = snr.subsnorepeat("aabbcc");
        for (String str : res){
            System.out.println(str);
        }
    }

}
