package yowei.leetCode;

import java.util.*;

public class No39CombinaSum {

    List<List<Integer>> res = new ArrayList<>();

    /*public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        int len = candidates.length;
        for (int i = 0; i < len; i++) {
            List<Integer> cur_res = new ArrayList<>();
            int sum = 0;
            backTrack(candidates,target,i,sum,cur_res);
        }

        return res;
    }

    public void backTrack(int[] candidates,int target,int cur, int sum, List<Integer> cur_res){
        sum += candidates[cur];
        if(sum == target) {
            cur_res.add(candidates[cur]);
            res.add(cur_res);
            return;
        }
        if(sum > target) return;
        else{
            cur_res.add(candidates[cur]);
            for (int i = cur; i < candidates.length; i++) {
                if(sum + candidates[i] > target) break;
                backTrack(candidates,target,i,sum,cur_res);
                cur_res.remove(cur_res.size() - 1);
            }
        }
    }*/

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        if (len == 0) {
            return res;
        }
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates,target, path,0,0);
        return res;
    }

    /**
     * 传入已存在的路径、已填入的总和和起始位置
     * @param candidates 候选数组
     * @param target      目标值
     * @param sum        当前和
     * @param path       从根结点到叶子结点的路径，是一个栈
     */
    private void dfs(int[] candidates,int target,Deque<Integer> path,int start,int sum) {
        //初始i为起始位置，由于数组排过序，就不会造成重复，例如在此之前2,2,3已经被使用过了，就不会出现2,3,2的情况，
        //只会从2,3,3开始
        for (int i = start; i < candidates.length; i++) {
            /*
                什么时候需要回溯？
                （1）当到达搜索尽头得到一个结果时
                （2）当到达某个结点不可行时
                就可以在对应的判断条件的末尾回溯
                应该在同一层进行添加和删除：某一层进行了添加，就必须在该层进行删除
             */
            if(sum + candidates[i] == target) {

                //由于对sum进行的加操作，这里的所有操作是在下一层
                path.addLast(candidates[i]);
                ArrayList<Integer> coms = new ArrayList<>(path);
                path.removeLast();
                res.add(coms);
                return;
            }
            if(sum + candidates[i] > target) return;

            //在当前层进行添加
            path.addLast(candidates[i]);
            dfs(candidates,target,path,i,sum + candidates[i]);
            //当前层进行删除，不管后面有多少层，都是成对进行增删，递归回来后仍然回到当前层
            path.removeLast();
        }

    }


    public static void main(String[] args) {
        No39CombinaSum cs = new No39CombinaSum();
        int[] a = {2,3,5};
        List<List<Integer>> lists = cs.combinationSum(a, 8);
        System.out.println(lists);
    }
}
