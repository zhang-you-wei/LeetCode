package yowei.leetCode.hash;

import yowei.leetCode.tools.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;


/**

 */
public class No437PathSumIII {
     int count = 0;
     public int pathSum(TreeNode root, int sum) {
         if(root == null) return 0;
         //遍历两次

         //第一次遍历，得到所有的节点
         ArrayList<TreeNode> li = new ArrayList<>();
         LinkedList<TreeNode> queue = new LinkedList<>();
         queue.add(root);
         while(queue.size() > 0 ){
             TreeNode x = queue.poll();
             li.add(x);
             if(x.left != null) queue.add(x.left);
             if(x.right != null) queue.add(x.right);
         }

         //把每个节点当成根节点搜索
         for(TreeNode t:li){
             dfs(t,sum,0);
         }

         return count;
     }

     public void dfs(TreeNode x,int sum,int cur){
         if(x == null) return;
         cur += x.val;
         if(cur == sum) count++;
         dfs(x.left,sum,cur);
         dfs(x.right,sum,cur);
     }


    /**
     * 一次扫描算法
     * 连续向下遍历和为k，转化为前缀和的差值为k，使用hash表记录该前缀和出现的次数
     */

    public int pathSum2(TreeNode root, int sum) {
        //使用hash表记录前缀和，当两节点前缀和差值刚刚好为sum时满足要求
        HashMap<Integer,Integer> map = new HashMap<>();

        //前缀和为0的一条路径
        map.put(0,1);
        return dfs(root,map,sum,0);
    }

    public int dfs(TreeNode x,HashMap<Integer,Integer> map,int sum,int presum){
        if(x == null) return 0;
        int res = 0;
        presum += x.val;

        res += map.getOrDefault(presum - sum, 0);

        // 更新路径上当前节点前缀和的个数,可能存在10,5,-5,0的情况，有多个点的前缀和相等
        map.put(presum, map.getOrDefault(presum, 0) + 1);

        // 3.进入下一层
        res += dfs(x.left, map, sum, presum);
        res += dfs(x.right, map, sum, presum);

        // 4.回到本层，恢复状态，去除当前节点的前缀和数量
        map.put(presum, map.get(presum) - 1);
        return res;

    }
}
