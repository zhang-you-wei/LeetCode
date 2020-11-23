package yowei.leetCode;

import java.util.*;

public class No347TopK2 {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i:nums){
            if(map.containsKey(i)){
                map.put(i,map.get(i) + 1);
            }
            else {
                map.put(i,1);
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });

        Set<Integer> integers = map.keySet();
        for (Integer j:integers){
            if(pq.size()<k){
                pq.add(j);
            }
            else {
                if(map.get(j) > map.get(pq.peek())){
                    pq.poll();
                    pq.add(j);
                }
            }
        }


        int[] res = new int[k];

        for (int i=0;i<k;i++){
            res[k-i-1] = pq.poll();
        }

        return res;
    }


    public static void main(String[] args) {
        int[] inp = {1,2,3,1,2,5,4,8,5,2,4,1,2,5,7,3,1,5,4,3,1,4,2,3,5,1,4,5,3,6,7,4,8,4,6,7,1,3,4,7,2,5,4,};
        int[] b = {2,2,1,1,1,4,4,4,4,3};
        int[] res = new No347TopK2().topKFrequent(b, 2);
        System.out.println(Arrays.toString(res));
    }
}
