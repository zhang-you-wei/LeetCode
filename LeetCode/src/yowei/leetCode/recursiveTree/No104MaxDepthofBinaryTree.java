package yowei.leetCode.recursiveTree;

import yowei.leetCode.tools.TreeNode;

/**
 * 求二叉树最大深度
 * 深度优先遍历每个节点，得出最大深度
 */
public class No104MaxDepthofBinaryTree {
    int max = 0;
    public int maxDepth(TreeNode root) {
        dfs(root,0);
        return max;
    }

    private void dfs(TreeNode x,int curdep){
        if(x != null) {
            dfs(x.left,curdep + 1);
            dfs(x.right,curdep + 1);
        }else
            max = Math.max(max,curdep);

    }
}
