package yowei.leetCode.recursiveTree;

import yowei.leetCode.tools.TreeNode;


public class Offer28SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return root == null || recur(root.left, root.right);
    }

    //判断两颗树是否对称
    boolean recur(TreeNode L, TreeNode R) {
        if(L == null && R == null) return true;
        if(L == null || R == null || L.val != R.val) return false;
        return recur(L.left, R.right) && recur(L.right, R.left);
    }
}
