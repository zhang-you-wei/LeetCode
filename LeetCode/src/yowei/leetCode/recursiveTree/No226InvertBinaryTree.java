package yowei.leetCode.recursiveTree;

import yowei.leetCode.tools.TreeNode;

/**
 * 翻转二叉树：将二叉树镜像翻转
 * 深度优先遍历，将遍历到的每个节点的左右子节点交换
 */
public class No226InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode x){
        if(x == null ) return;
        TreeNode temp = x.left;
        x.left = x.right;
        x.right = temp;
        dfs(x.left);
        dfs(x.right);
    }
}
