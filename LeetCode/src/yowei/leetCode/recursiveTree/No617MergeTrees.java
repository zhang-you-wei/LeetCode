package yowei.leetCode.recursiveTree;

import yowei.leetCode.tools.TreeNode;

/**
 * 合并两颗二叉树
 * 功能：由给定的两颗二叉树返回合并后的树
 */
public class No617MergeTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null)  return t2;
        if(t2 == null)  return t1;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

}
