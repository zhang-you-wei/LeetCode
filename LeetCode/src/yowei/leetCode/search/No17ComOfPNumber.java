package yowei.leetCode.search;

import java.util.*;

public class No17ComOfPNumber {

    public List<String> letterCombinations(String digits) {

        HashMap<Character, String[]> map = new HashMap<>();

        Deque<String> queue = new LinkedList<>();

        String[] s2 = {"a","b","c"};
        String[] s3 = {"d","e","f"};
        String[] s4 = {"g","h","i"};
        String[] s5 = {"j","k","l"};
        String[] s6 = {"m","n","o"};
        String[] s7 = {"p","q","r","s"};
        String[] s8 = {"t","u","v"};
        String[] s9 = {"w","x","y","z"};
        map.put('2',s2);
        map.put('3',s3);
        map.put('4',s4);
        map.put('5',s5);
        map.put('6',s6);
        map.put('7',s7);
        map.put('8',s8);
        map.put('9',s9);

        boolean isfirst = true;

        char[] chars = digits.toCharArray();
        for (Character s : chars) {
            String[] strs = map.get(s);
            if(isfirst) {
                for (String str : strs) {
                    queue.addLast(str);
                }
                isfirst = false;
            }
            else {
                int cursize = queue.size();
                for (int i = 0; i < cursize; i++) {
                    String cur = queue.removeFirst();
                    for (String str : strs) {
                        queue.addLast(cur + str);
                    }
                }

            }
        }

        List<String> lis = new ArrayList<>();
        lis.addAll(queue);
        return lis;
    }


    public List<String> letterCombinations2(String digits){

        LinkedList<String> res = new LinkedList<>();
        if(digits == null || digits.length()==0) return res;

        String[] s2 = {"a","b","c"};
        String[] s3 = {"d","e","f"};
        String[] s4 = {"g","h","i"};
        String[] s5 = {"j","k","l"};
        String[] s6 = {"m","n","o"};
        String[] s7 = {"p","q","r","s"};
        String[] s8 = {"t","u","v"};
        String[] s9 = {"w","x","y","z"};

        HashMap<Character, String[]> map = new HashMap<Character, String[]>() {
            {
                put('2', s2);
                put('3', s3);
                put('4', s4);
                put('5', s5);
                put('6', s6);
                put('7', s7);
                put('8', s8);
                put('9', s9);
            }
        };

        dfs(res,map,"",digits,0);

        return res;
    }

    public void dfs(LinkedList<String> res,HashMap<Character, String[]> map,String curs,String digits,int index){

        char c = digits.charAt(index);
        String[] strings = map.get(c);

        if(index == digits.length()-1){
            for (String str : strings) {
              res.add(curs + str);
            }
        }
        else {
            for (String str : strings) {
                dfs(res, map, curs + str, digits, index + 1);
            }
        }
    }



    public static void main(String[] args) {
        No17ComOfPNumber cn = new No17ComOfPNumber();
        List<String> strings = cn.letterCombinations2("");
        System.out.println(strings);
    }

}
