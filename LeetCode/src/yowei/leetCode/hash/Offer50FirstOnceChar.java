package yowei.leetCode.hash;

import java.util.LinkedHashMap;

public class Offer50FirstOnceChar {
    public char firstUniqChar(String s) {
        LinkedHashMap<Character, Integer> lmap = new LinkedHashMap<>();
        for(char x :s.toCharArray()){
            if(!lmap.containsKey(x)){
                lmap.put(x,1);
            }
            else lmap.put(x,lmap.get(x) + 1);
        }
        for(Character x : lmap.keySet()){
            if(lmap.get(x) == 1) {
                return x;
            }
        }
        return '0';
    }

    public static void main(String[] args) {
        String s = "asdsgdfsadsad";
        Offer50FirstOnceChar foc = new Offer50FirstOnceChar();
        char res = foc.firstUniqChar(s);
        System.out.println(res);
    }
}
