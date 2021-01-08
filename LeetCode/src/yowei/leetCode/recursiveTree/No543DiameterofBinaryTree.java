package yowei.leetCode.recursiveTree;

import yowei.leetCode.tools.TreeNode;

/**
 * 二叉树的直径
 * 递归求左右子树的最大深度，相加求长度
 * 最大长度可能在子树中，使用额外的变量保存
 */
public class No543DiameterofBinaryTree {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        dfs(root);
        return max - 1;
    }

    private int dfs(TreeNode x){
        if(x == null) return 0;
        int left = dfs(x.left);
        int right = dfs(x.right);
        max = Math.max(max,left + right + 1);
        return Math.max(left,right) + 1;
    }
}
