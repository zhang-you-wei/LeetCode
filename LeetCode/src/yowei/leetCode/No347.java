package yowei.leetCode;

import java.util.*;

public class No347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> index = new ArrayList<>();
        int [] res = new int[k];

        for (int i:nums){
            if(map.containsKey(i)) map.put(i,map.get(i)+1);
            else {
                map.put(i, 1);
            }
        }

        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        final Object[] objects = map.keySet().toArray();
        for(Object ob:objects){
            index.add((Integer) ob);
        }

//        List<Integer> res = new ArrayList<>();

        for(int i=0;i<k;i++){
            int max =0,n=0,m=0;
            for(Integer x:map.values()){
                if(x>max) {max = x;m=n;}
                n++;
            }
            int t = index.remove(m);
            res[i] = t;
            map.remove(t);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] x  = {3,0,1,0};
        int[] res= new No347().topKFrequent(x,1);
        System.out.println(Arrays.toString(res));
    }
}
