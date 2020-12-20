package yowei.leetCode.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class No49GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for (String str : strs) {
            String nstr = strsort(str);
            if(!map.containsKey(nstr)){
                map.put(nstr,new ArrayList<>());
            }
            map.get(nstr).add(str);
        }
        for (String str : map.keySet()) {
            res.add(map.get(str));
        }

        return res;
    }

    public String strsort(String str){
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static void main(String[] args) {
        //String[] x = {"eat","tea","tan","ate","nat","bat"};
        String[] x ={"a"};
        No49GroupAnagrams ga = new No49GroupAnagrams();
        List<List<String>> res = ga.groupAnagrams(x);
        System.out.println(res.toString());
    }
}
