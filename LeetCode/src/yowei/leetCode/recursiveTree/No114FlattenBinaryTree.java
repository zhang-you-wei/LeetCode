package yowei.leetCode.recursiveTree;

import yowei.leetCode.tools.TreeNode;

public class No114FlattenBinaryTree {
    public void flatten(TreeNode root) {
        dfs(root);
    }

    private TreeNode dfs(TreeNode root) {
        if (root == null)
            return root;
        // 返回叶子节点
        if (root.left == null && root.right == null)
            return root;
        // 备份左右子树，留待遍历
        TreeNode tleft = root.left;
        TreeNode tright = root.right;
        if (tleft != null) {
            root.right = root.left;// 左子树接到右侧
            // 右子树接到左子树下方
            tleft = dfs(tleft);// 懒得新建变量，直接left存左子树尾节点
            tleft.right = tright;
        }
        root.left = null;
        return tright == null ? tleft:dfs(tright) ;// 然后跑右子树，返回右子树尾节点，若不存在，返回左子树尾节点
    }
}
