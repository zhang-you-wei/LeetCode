package yowei.leetCode.recursiveTree;

import yowei.leetCode.tools.TreeNode;
import yowei.leetCode.tools.TreeTools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Offer32LevelSearch {
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> curRes = new ArrayList<>();
            for(int i = 0;i<size;i++){
                TreeNode cur = queue.poll();
                curRes.add(cur.val);
                if(cur.left != null){
                    queue.add(cur.left);
                }
                if(cur.right != null){
                    queue.add(cur.right);
                }
            }
            res.add(curRes);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {3,9,20,-1,-1,15,7,-1,-1,-1,-1};
        TreeNode tree = TreeTools.getTree(arr);
        Offer32LevelSearch ls = new Offer32LevelSearch();
        List<List<Integer>> lists = ls.levelOrder(tree);
        for(List<Integer> list : lists){
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

}
