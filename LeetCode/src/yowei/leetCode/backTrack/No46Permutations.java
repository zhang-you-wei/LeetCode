package yowei.leetCode.backTrack;

import java.util.*;

/**
 * 返回数组的全排列
 */
public class No46Permutations {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

        Arrays.sort(nums);
        Deque<Integer> path = new LinkedList<>();
        List<Integer> rest = new ArrayList<>();
        for (int i : nums) {
            rest.add(i);
        }
        permus(rest,path);
        return res;
    }

    public void permus(List<Integer> rest,  Deque<Integer> path){
        if(rest.size() == 0) {
            res.add(new ArrayList<>(path));
        }

        for (int i = 0; i < rest.size(); i++) {
            int cur = rest.remove(i);
            path.addLast(cur);

            permus(rest,path);

            path.removeLast();
            rest.add(i,cur);
        }
    }

    public static void main(String[] args) {
        int[] a = {4,7,2,3,5,8};
        No46Permutations pt = new No46Permutations();
        List<List<Integer>> res = pt.permute(a);
        System.out.println(res);
    }
}
