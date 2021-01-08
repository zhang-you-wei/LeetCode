package yowei.leetCode.recursiveTree;

import yowei.leetCode.tools.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class No101SymmetricTree {
    /**
     * 递归方法：当两个节点的值相等，且左右子树分别对称时，两个节点以及父节点构成对称的树
     */
     public boolean isSymmetric2(TreeNode root) {
         if(root == null) return true;
         return dfs(root.left,root.right);
     }

     private boolean dfs(TreeNode left,TreeNode right){
         if(left==null && right == null) return true;
         if(left == null || right == null) return false;

         boolean l = dfs(left.left,right.right);
         boolean m = (left.val == right.val);
         boolean r = dfs(left.right,right.left);
         return l&&m&&r;
     }


    /**
     * 迭代方法：使用一个队列保存两边的节点
     */
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode u, TreeNode v) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(u);
        q.offer(v);
        while (!q.isEmpty()) {
            u = q.poll();
            v = q.poll();
            if (u == null && v == null) {
                continue;
            }
            if ((u == null || v == null) || (u.val != v.val)) {
                return false;
            }

            q.offer(u.left);
            q.offer(v.right);

            q.offer(u.right);
            q.offer(v.left);
        }
        return true;
    }

}
