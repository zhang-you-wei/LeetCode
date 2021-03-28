package yowei.leetCode.interview;

import java.util.*;

public class WordCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0;i < n;i++){
            String s = sc.next();
            if(!map.containsKey(s)){
                map.put(s,1);
            }else {
                map.put(s,map.get(s) + 1);
            }

        }

        ArrayList<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort((o1, o2) -> o2.getValue() - o1.getValue());

        int threshold = n/100,count = 0;
        for(Map.Entry<String, Integer> entry:entries){
            if(entry.getValue() > threshold){
                count++;
            }else {
                break;
            }
        }
        System.out.println(count);
    }

}
