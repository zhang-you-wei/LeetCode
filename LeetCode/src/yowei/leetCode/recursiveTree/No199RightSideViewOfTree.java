package yowei.leetCode.recursiveTree;

import yowei.leetCode.tools.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 */
public class No199RightSideViewOfTree {
    public List<Integer> rightSideView(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null) return null;
        queue.add(root);
        while(!queue.isEmpty()){
            int lastLevelSize = queue.size();
            for(int i = 0;i<lastLevelSize;i++){
                TreeNode cur = queue.poll();
                if(i == 0) res.add(cur.val);
                if(cur.right != null) queue.add(cur.right);
                if(cur.left != null) queue.add(cur.left);
            }
        }
        return res;
    }

}
