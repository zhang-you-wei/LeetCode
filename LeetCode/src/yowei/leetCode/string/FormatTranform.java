package yowei.leetCode.string;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FormatTranform {
    public static List<String> transform(String str){

        LinkedList<String> words = new LinkedList<>();
        String reg = "[A-Z]";
        if(str.contains("_")){
            String[] temp = str.split("_");
            for(String word : temp){
                words.add(word);
            }
        }else if(str.contains("-")){
            String[] temp = str.split("-");
            for(String word : temp){
                words.add(word);
            }
        }else{
            int start = 0,end = 0;
            char[] chars = str.toCharArray();
            ArrayList<Integer> parts = new ArrayList<>();
            for(int i = 0;i<chars.length;i++){
                if(chars[i] <= 'Z'){
                    parts.add(i - start);
                    start = i;
                    chars[i] += 32;
                }
            }
            parts.add(chars.length - start);
            String newStr = new String(chars);
            start = 0;
            for(Integer len : parts){
                if(len == 0) continue;
                end = start + len;
                words.add(str.substring(start,end -1));
                start = end;
            }
        }
        return words;
    }
}
