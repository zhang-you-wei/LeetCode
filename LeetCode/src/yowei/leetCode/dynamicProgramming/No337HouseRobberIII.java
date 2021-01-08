package yowei.leetCode.dynamicProgramming;

import yowei.leetCode.tools.TreeNode;

import java.util.HashMap;

public class No337HouseRobberIII {
    public int rob(TreeNode root) {
        //动态规划，对树进行后续遍历，由底向上将结果传送上来
        int[] res = dfs(root);
        return Math.max(res[0],res[1]);
    }

    /**
     *root对应某个节点
     * int[0]表示该节点不偷的最大价值，int[1]表示该几点偷的最大价值
     */
    private int[] dfs(TreeNode root){
        if(root == null){
            return new int[]{0,0};
        }

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int[] dp = new int[2];

        dp[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        dp[1] = root.val + left[0] + right[0];
        return dp;
    }

    /**
     * 递归算法，比较爷爷和四个孙子以及两个父亲偷得的总数大小，记为该节点能偷得的最大价值
     * 使用hash表记录探索过的节点，避免重复遍历
     */
    public int rob2(TreeNode root) {
        HashMap<TreeNode, Integer> memo = new HashMap<>();
        return robInternal(root, memo);
    }

    public int robInternal(TreeNode root, HashMap<TreeNode, Integer> memo) {
        if (root == null) return 0;
        if (memo.containsKey(root)) return memo.get(root);
        int money = root.val;

        //左孙子
        if (root.left != null) {
            money += (robInternal(root.left.left, memo) + robInternal(root.left.right, memo));
        }
        //右孙子
        if (root.right != null) {
            money += (robInternal(root.right.left, memo) + robInternal(root.right.right, memo));
        }
        int result = Math.max(money, robInternal(root.left, memo) + robInternal(root.right, memo));
        memo.put(root, result);
        return result;
    }

}
