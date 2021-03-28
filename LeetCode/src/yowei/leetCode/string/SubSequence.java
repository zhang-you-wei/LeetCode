package yowei.leetCode.string;

import java.util.ArrayList;
import java.util.List;

public class SubSequence {
    public List<String> subsequence(String str){
        String path = "";
        ArrayList<String> res = new ArrayList<>();
        getSubs(str,res,0,path);
        return  res;

    }

    private void getSubs(String str, List<String> res, int i, String path) {
        if(i >= str.length()){
            res.add(path);
            return;
        }
        getSubs(str,res,i+1, path);
        //String yes = path + str.charAt(i);
        getSubs(str,res,i+1,path + str.charAt(i));
    }

    public static void main(String[] args) {
        SubSequence ss = new SubSequence();
        List<String> res = ss.subsequence("abcd");
        for (String str : res){
            System.out.println(str);
        }
    }


}
