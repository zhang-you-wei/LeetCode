package yowei.leetCode.dynamicProgramming;

import java.util.*;

public class No78Subsets {

    List<List<Integer>> res = new ArrayList<>();

    /*
    public List<List<Integer>> subsets(int[] nums) {

        Deque<Integer> path = new LinkedList<>();
        backTrack(nums,0,path);

        return res;
    }
    public void backTrack(int[] nums,int curlen,Deque<Integer> path){
        if(curlen == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        res.add(new ArrayList<>(path));

        for (int i = curlen ; i < nums.length; i++) {
            path.addLast(nums[i]);
            backTrack(nums,i+1,path);
            path.removeLast();
        }

    }*/
    public List<List<Integer>> subsets2(int[] nums){
        res.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int size = res.size();
            for (int j = 0; j < size; j++) {
                int cur = nums[i];
                ArrayList<Integer> li = new ArrayList<>();
                li.addAll(res.get(j));
                li.add(cur);
                res.add(li);
            }
        }

        return res;
    }


    public static void main(String[] args) {
        No78Subsets ss = new No78Subsets();
        int[] x = {1,2,3,4,5};
        List<List<Integer>> res = ss.subsets2(x);
        for (List<Integer> li : res) {
            System.out.println(li);
        }

    }
}
