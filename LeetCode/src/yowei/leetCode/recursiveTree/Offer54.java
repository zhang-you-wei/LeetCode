package yowei.leetCode.recursiveTree;

import yowei.leetCode.tools.TreeNode;

public class Offer54 {
    int res;
    int K;

    public int kthLargest(TreeNode root, int k) {
        this.K = k;     //初始化
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.right);
        if(K == 0){         //提前返回
            return;
        }
        if(--K == 0){
            res = root.val;
        }
        dfs(root.left);
    }
}
