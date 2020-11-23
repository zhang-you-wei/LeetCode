package yowei.leetCode;

import java.util.*;

public class N046Permutations {
    private List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer> rest = new ArrayList<>();
        for (int i:nums) {
            rest.add(i);
        }
        Deque<Integer> path = new LinkedList<>();
        pbackTrack(rest,path);



        return res;
    }

    public void pbackTrack(List<Integer> rest,Deque<Integer> path){
        for (int i = 0; i < rest.size(); i++) {
            int node = rest.remove(i);
            path.addLast(node);
            pbackTrack(rest,path);
            rest.add(i,node);
        }


    }
}
